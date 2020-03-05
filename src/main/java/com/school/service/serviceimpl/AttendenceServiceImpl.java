package com.school.service.serviceimpl;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.school.service.dao.IAttendenceDao;
import com.school.service.service.IAttendenceService;

@Named
public class AttendenceServiceImpl implements IAttendenceService{
	
	@Inject
	private IAttendenceDao attendenceDao;
	

	@Override
	public void saveOrUpdateAttendenceDetails(String userId , String logDateTime) {
		
		attendenceDao.saveOrUpdateAttendenceDetails(userId, logDateTime);
		
	}

	@Override
	public Map<String , Object> getDeviceAttendenceLog(String tableName,String startDateTime , String endDateTime) {
		
		return attendenceDao.getDeviceAttendenceLog(tableName, startDateTime, endDateTime);
	}

}
