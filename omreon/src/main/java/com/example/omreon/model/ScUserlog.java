package com.example.omreon.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
//Spring Boot
public class ScUserlog implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="db_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "session_id")
	private String sessionId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "log_time")
	private Date logTime;
	
	
	@Column(name= "instance_name")
	private String instanceName;
	
	public ScUserlog() {
		
	}

	public ScUserlog(long dbId, String sessionID, Date logTime,/* String log,*/ String instanceName) {
		this.id = dbId;
		this.sessionId = sessionID;
		this.logTime = logTime;
		this.instanceName = instanceName;
	}

	public long getDbId() {
		return id;
	}

	public void setDbId(long dbId) {
		this.id = dbId;
	}

	public String getSessionID() {
		return sessionId;
	}

	public void setSessionID(String sessionID) {
		this.sessionId = sessionID;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}



	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}


}
