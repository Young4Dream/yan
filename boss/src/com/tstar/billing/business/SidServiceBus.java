package com.tstar.billing.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.ibatis.session.SqlSession;

import com.tstar.ocs.dao.SidOperatorTrunkMapper;
import com.tstar.ocs.dao.SidServiceCategoryMapper;
import com.tstar.ocs.dao.SidServiceMapper;
import com.tstar.ocs.dao.SidVoiceConfigItemMapper;
import com.tstar.ocs.dao.SidVoiceConfigMapper;
import com.tstar.ocs.model.SidOperatorTrunk;
import com.tstar.ocs.model.SidService;
import com.tstar.ocs.model.SidServiceCategory;
import com.tstar.ocs.model.SidVoiceConfig;
import com.tstar.ocs.model.SidVoiceConfigItem;
import com.tstar.util.MyBatisSessionFactory;

public class SidServiceBus {

	/**
	 * 根据业务类别别名获取业务类别
	 * 业务类别别名从decoder.xml获取
	 */
	private static ConcurrentHashMap<String, SidServiceCategory> categories = null;
	public static SidServiceCategory findCategory(String abbr) {
		if (categories == null) {
			SqlSession session = MyBatisSessionFactory.getSession();
			try {
				SidServiceCategoryMapper dao = session.getMapper(SidServiceCategoryMapper.class);
				List<SidServiceCategory> lst = dao.selectAll();
				categories = new ConcurrentHashMap<String, SidServiceCategory>();
				for (SidServiceCategory obj : lst) {
					categories.put(obj.getAbbr(), obj);
				}
			} finally {
				session.close();
			}
		}
		return categories.get(abbr);
	}
	
	/**
	 * 字冠表
	 * 字冠表不包含默认字冠（*）
	 * 字冠表按照字冠长度进行分组，长字冠排在前面
	 */
	private static List<PrefixMap> callTypeItems = null;
	private static SidVoiceConfigItem defaultCallTypeItem = null;
	
	private static void loadCallTypes() {
		SqlSession session = MyBatisSessionFactory.getSession();
		try {
			SidVoiceConfigItemMapper dao = session.getMapper(SidVoiceConfigItemMapper.class);
			defaultCallTypeItem = dao.selectDefaultConfigItem();
			callTypeItems = new ArrayList<PrefixMap>();
			List<SidVoiceConfigItem> lst = dao.selectAllOrderByLen();
			if (lst == null || lst.size() == 0) return;
			int lastLen = 0;
			PrefixMap curr = null;
			for (int i = 0; i < lst.size(); i++) {
				SidVoiceConfigItem item = lst.get(i);
				int currLen = item.getCalleePrefix().length();
				if (currLen != lastLen) {
					lastLen = currLen;
					curr = new PrefixMap(currLen, new ConcurrentHashMap<String, SidVoiceConfigItem>());
					callTypeItems.add(curr);
				}
				if (curr != null) {
					curr.map.put(item.getCalleePrefix(), item);
				}
			}
		} finally {
			session.close();
		}
	}
	
	private static SidVoiceConfigItem findCallTypeItemInMap(String callee) {
		for (int i = 0; i < callTypeItems.size(); i++) {
			PrefixMap pm = callTypeItems.get(i);
			if (pm.length >  callee.length()) {
				// 字冠比号码长，查找下一个
				continue;
			}
			String prefix = callee.substring(0, pm.length);
			SidVoiceConfigItem item = pm.map.get(prefix);
			if (item != null) {
				return item;
			}
		}
		return null;
	}
	
	public static SidVoiceConfigItem findCallTypeItem(String callee) {
		if (callTypeItems == null) {
			loadCallTypes();
		}
		SidVoiceConfigItem item = findCallTypeItemInMap(callee);
		if (item == null) {
			return defaultCallTypeItem;
		} else {
			return item;
		}
	}
	
	/**
	 * 查找呼叫类型名
	 */
	private static Map<String, String> callTypes = null;
	public static String findCallTypeName(String id) {
		if (callTypes == null) {
			SqlSession session = MyBatisSessionFactory.getSession();
			try {
				SidVoiceConfigMapper dao = session.getMapper(SidVoiceConfigMapper.class);
				List<SidVoiceConfig> lst = dao.selectAll();
				callTypes = new ConcurrentHashMap<String, String>();
				for (SidVoiceConfig obj : lst) {
					callTypes.put(obj.getId(), obj.getName());
				}
			} finally {
				session.close();
			}
		}
		return callTypes.get(id);
	}
	
	/**
	 * 根据分类和呼叫类型查找服务
	 */
	private static Map<String, SidService> services = null;
	public static SidService findService(String categoryId, String callTypeId, String dataId) {
		if (services == null) {
			SqlSession session = MyBatisSessionFactory.getSession();
			try {
				SidServiceMapper dao = session.getMapper(SidServiceMapper.class);
				List<SidService> lst = dao.selectAll();
				services = new ConcurrentHashMap<String, SidService>();
				for (SidService obj : lst) {
					String key = obj.getCategoryId() + "-" +
						(obj.getVoiceId() == null || "".equals(obj.getVoiceId()) ? "*" : obj.getVoiceId()) + "-" +
						(obj.getDataId() == null || "".equals(obj.getDataId()) ? "*" : obj.getDataId());
					services.put(key, obj);
				}
			} finally {
				session.close();
			}
		}
		String key = categoryId + "-" + (callTypeId == null ? "*" : callTypeId) + "-" + (dataId == null ? "*" : dataId);
		return services.get(key);
	}
	
	/**
	 * 根据中继号获取运营商
	 */
	private static Map<String, SidOperatorTrunk> trunks = null;
	public static SidOperatorTrunk findOp(String sourceName, String trunkNo) {
		if (trunks == null) {
			SqlSession session = MyBatisSessionFactory.getSession();
			try {
				SidOperatorTrunkMapper dao = session.getMapper(SidOperatorTrunkMapper.class);
				List<SidOperatorTrunk> lst = dao.selectAll();
				trunks = new ConcurrentHashMap<String, SidOperatorTrunk>();
				for (SidOperatorTrunk obj : lst) {
					String key = obj.getSourceName() + "-" + obj.getTrunkNo();
					trunks.put(key, obj);
				}
			} finally {
				session.close();
			}
		}
		return trunks.get(sourceName + "-" + trunkNo);
	}
	
	public static void main(String[] args) {
		SidVoiceConfigItem item = findCallTypeItem("4861141");
		System.out.println(item.getCalleeLocation());
//		item = findCallTypeItem("020661");
//		System.out.println(item.getCalleeLocation());
//		item = findCallTypeItem("021661");
//		System.out.println(item.getCalleeLocation());
//		item = findCallTypeItem("05960661");
//		System.out.println(item.getCalleeLocation());
//		item = findCallTypeItem("008520661");
//		System.out.println(item.getCalleeLocation());
//		item = findCallTypeItem("006520661");
//		System.out.println(item.getCalleeLocation());
//		System.out.println("service:");
//		SidService sv = findService("1", "1", null);
//		System.out.println("id=" + sv.getId() + ", name=" + sv.getName());
//		sv = findService("2", null, "1");
//		System.out.println("id=" + sv.getId() + ", name=" + sv.getName());	
//		sv = findService("3", null, null);
//		System.out.println(sv == null ? "null" : sv.getName());
	}
}
