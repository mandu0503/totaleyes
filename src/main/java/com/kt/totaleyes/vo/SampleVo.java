package com.kt.totaleyes.vo;

import java.io.Serializable;

public class SampleVo implements Serializable{
			
	private static final long serialVersionUID = 3389098890567660866L;
	
	private long seq;
	private String subject;
	private String contents;
	private String createDt;
	private String createId;
	
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getCreateId() {
		return createId;
	}
	public void setCreateId(String createId) {
		this.createId = createId;
	}	
}
