package com.school.service.dao;

import java.util.Map;

public interface IAttendenceDao {
	
	public void saveOrUpdateAttendenceDetails(String userId , String logDateTime);
	public Map<String , Object> getDeviceAttendenceLog(String tableName,String startDateTime , String endDateTime);

}
