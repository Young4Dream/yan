package com.tstar.callcenter.dao.admin;

import java.util.List;

import com.tstar.callcenter.pub.chooseData.DataSource;
import com.tstar.callcenter.pub.data.ResultMap;

public interface AdminConfMapper {
	@DataSource("postgre")
	List<ResultMap> selectEmplByPage(ResultMap map);
	
	int selectEmplByCount(ResultMap map);
	
	List<Long>selectSkillIdByEmplId(long employeeId);
	
	List<ResultMap> selectSkillTreeChild();
	
	List<ResultMap> selectSkillGroups();
	
	List<ResultMap> selectDeptByPage(ResultMap map);
	
	int selectDeptByCount(ResultMap map);
	
	List<ResultMap> deptSelectList();
	
	List<ResultMap> selectSkillByPage(ResultMap map);
	
	int selectSkillByCount(ResultMap map);
	
	List<ResultMap> select114ByPage(ResultMap map);
	
	int select114ByCount(ResultMap map);
	
	int selectDeptChildByCount(ResultMap map);
	
	int selectEmplCountByDept(ResultMap map);
	
	@DataSource("oracle")
	int selectoral();
	
	int insertRecord(ResultMap map);
	
	List<ResultMap> selectRecordByPage(ResultMap map);
	
	int selectAllRecordCount(ResultMap map);
	
	List<ResultMap> selectEmplNameByEmplNo(ResultMap map);
	
	List<ResultMap> selectEmplByLog(ResultMap map);
	
	int insertLoginLog(ResultMap map);

	List<ResultMap> selectSysConf();

	int updateSysConf(ResultMap map);
	
	List<ResultMap> selectSystemIp();
}
