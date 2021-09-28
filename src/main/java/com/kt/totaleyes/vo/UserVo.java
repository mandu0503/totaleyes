package com.kt.totaleyes.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7723642932846116355L;
	private String userId;
	private String pwd;
	private String userNm;
	private String userEmail;
	private String userCntctNo;
	private String userRole;
	private String mstrYn;
	private String apprvlYn;
	private Integer bizSeq;
	private String bizNm;
	private String bizNo;
	private String ceoNm;
	private String bizCndt;
	private String bizType;
	private String agntNm;
	private String agntEmail;
	private String agntCntctNo;	
	
	private String createdTm;
	private String bizApprvlYn;
}
