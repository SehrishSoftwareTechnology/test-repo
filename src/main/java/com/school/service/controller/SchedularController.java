package com.school.service.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.school.service.service.IAttendenceService;

@Component
public class SchedularController {
	
	@Inject
	private IAttendenceService attendenceService;
	
	
	//@Scheduled(cron = "0 0/15 6-19 * * 1-6")
	@Scheduled(cron = "0 0/15 6-19 * * 1-6")
	public void saveAttendenceDetails() {
		
		try {

			LocalDate localDate = LocalDate.now();
			String tableName = "ebioserver.deviceLogs_";
			tableName = tableName.concat(Integer.toString(localDate.getMonthValue()));
			tableName = tableName.concat("_");
			tableName = tableName.concat(Integer.toString(localDate.getYear()));

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			LocalDateTime now = LocalDateTime.now();
		
			//String endDateTime = formatter.format(now);
			String endDateTime = "2019-11-15 16:00:00";
			
			LocalDateTime now1 = now.minusMinutes(15);
			//String startDateTime = formatter.format(now1);   
			
			String startDateTime ="2019-11-15 07:01:45";
			Map<String, Object> dataMap = null;

			dataMap = attendenceService.getDeviceAttendenceLog(tableName, endDateTime, startDateTime);
			
			JSONObject jsonObject = new JSONObject(dataMap);
			JSONArray getArray = jsonObject.getJSONArray("responseData");

			for (int i = 0; i < getArray.length(); i++) {
				String userId = getArray.getJSONObject(i).getString("UserId");
				String logDateTime = getArray.getJSONObject(i).getString("LogDate");

				attendenceService.saveOrUpdateAttendenceDetails(userId, logDateTime);
				System.out.println("saveOrUpdateAttendenceDetails--------- "+i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
