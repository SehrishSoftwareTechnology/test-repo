package com.school.service.service;

import java.util.Map;

public interface IAttendenceService {
	
	public void saveOrUpdateAttendenceDetails(String userId , String logDateTime);
	
	public Map<String , Object> getDeviceAttendenceLog(String tableName,String startDateTime , String endDateTime);

}
