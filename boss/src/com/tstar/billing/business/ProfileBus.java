package com.tstar.billing.business;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.tstar.portal.dao.ProfileMapper;
import com.tstar.portal.model.Profile;
import com.tstar.util.MyBatisSessionFactory;

public class ProfileBus {
	
	public static final String SECTION_SYS = "system";
	public static final String SECTION_OCS = "ocs";
	public static final String PROFILE_COLLECT_INTERVAL = "CollectInterval";
	public static final String PROFILE_IMS_NATIONAL_PREFIX = "ImsNationalPrefix";
	public static final String PROFILE_IMS_LOCAL_PREFIX = "ImsLocalPrefix";
	public static final String PROFILES_CDR_WARN_DURATION = "WarnDuration";
	
	private static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	public static Profile getProfile(String sectionName, String profileName) {
		String key = sectionName + "." + profileName;
		Profile profile = profiles.get(key);
		if (profile == null) {
			SqlSession session = MyBatisSessionFactory.getSession();
			try {
				ProfileMapper dao = session.getMapper(ProfileMapper.class);
				profile = dao.selectByUk(sectionName, profileName);
				profiles.put(key, profile);
			} finally {
				session.close();
			}
		}
		return profile;
	}
	
	// 采集间隔
	public static int getCollectInterval() {
		Profile profile = getProfile(SECTION_OCS, PROFILE_COLLECT_INTERVAL);
		if (profile == null || profile.getProfileValue() == null || "".equals(profile.getProfileValue())) {
			return 60;
		} else {
			return Integer.parseInt(profile.getProfileValue());
		}
	}
	
	// 中国字冠
	public static String getNationalPrefix() {
		Profile profile = getProfile(SECTION_OCS, PROFILE_IMS_NATIONAL_PREFIX);
		if (profile == null || profile.getProfileValue() == null || "".equals(profile.getProfileValue())) {
			return "86";
		} else {
			return profile.getProfileValue();
		}
	}
	
	// 本地字冠
	public static String getLocalPrefix() {
		Profile profile = getProfile(SECTION_OCS, PROFILE_IMS_LOCAL_PREFIX);
		if (profile == null || profile.getProfileValue() == null || "".equals(profile.getProfileValue())) {
			return "8620";
		} else {
			return profile.getProfileValue();
		}
	}
	
	// 话单时长告警线
	public static int getWarnDuration() {
		Profile profile = getProfile(SECTION_OCS, PROFILES_CDR_WARN_DURATION);
		if (profile == null || profile.getProfileValue() == null || "".equals(profile.getProfileValue())) {
			return 18000;
		} else {
			return Integer.parseInt(profile.getProfileValue());
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(getCollectInterval());
	}

}
