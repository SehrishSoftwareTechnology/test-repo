/**
 * 
 */
package com.school.service.util;

import java.io.Serializable;

/**
 * @author Sumanta
 *
 */
public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 357777038811257033L;
	/**
	 * 
	 */
	
	private String status;
	private String responseMessage;
	private int searchCount;
	private Object resObject;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public int getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(int searchCount) {
		this.searchCount = searchCount;
	}

	public Object getResObject() {
		return resObject;
	}

	public void setResObject(Object resObject) {
		this.resObject = resObject;
	}

	public Response() {
		// TODO Auto-generated constructor stub
	}

}
