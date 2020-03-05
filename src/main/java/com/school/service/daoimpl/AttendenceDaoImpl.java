package com.school.service.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;

import com.school.service.dao.IAttendenceDao;

@Named
public class AttendenceDaoImpl implements IAttendenceDao {

	private JdbcTemplate jdbcTemplate;

	@Inject
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdateAttendenceDetails(String userId, String logDateTime) {
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<SqlParameter> parameterList = new ArrayList<SqlParameter>();
		try {
			final String procedureCall = "{call schoolAttendenceProcedure(?,?)}";
			Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection connection) throws SQLException {
					CallableStatement callableStatement = connection.prepareCall(procedureCall);
					callableStatement.setString(1, userId);
					callableStatement.setString(2, logDateTime);

					return callableStatement;
				}
			}, parameterList);

			result.put("responseData", resultMap.get("#result-set-1"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Map<String, Object> getDeviceAttendenceLog(String tableName,String startDateTime , String endDateTime) {
		
		Map<String, Object> result = new HashMap<String, Object>();

		try {

			List<SqlParameter> parameterList = new ArrayList<SqlParameter>();
			final String procedureCall = "{call getAttendenceLogByDateTime(?,?,?)}";
			Map<String, Object> resultMap = jdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection connection) throws SQLException {
					CallableStatement callableStatement = connection.prepareCall(procedureCall);
					
					callableStatement.setString(1, tableName);
					callableStatement.setString(2, startDateTime);
					callableStatement.setString(3, endDateTime);

					return callableStatement;
				}
			}, parameterList);

			result.put("responseData", resultMap.get("#result-set-1"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

}
