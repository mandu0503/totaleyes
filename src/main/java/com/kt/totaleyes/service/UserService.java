package com.kt.totaleyes.service;

import java.util.List;

import com.kt.totaleyes.common.SearchVo;
import com.kt.totaleyes.vo.UserVo;

public interface UserService {

	/**
	 * 사용자 user_id 카운트
	 * @param userId
	 * @return
	 */
	public int countById (String userId);
	/**
	 * 사용자 사업자 등록번호 카운드
	 * @param bizNo
	 * @return
	 */
	public int countByBizNo (String bizNo);
	/**
	 * 사용자 biz_seq 조회
	 * @param bizNo
	 * @param bizNm
	 * @return
	 */
	public Integer findBizSeqByBizNoAndApprvlY (String bizNo, String bizNm);
	/**
	 * 사용자 회원 가입
	 * @param userVo
	 * @return
	 */
	public boolean createUser(UserVo userVo);

	/**
	 * 관리자 승인 목록 카운트
	 * @param searchVo
	 * @return
	 */
	public int countByApprvlN(SearchVo searchVo);
	/**
	 * 관리자 승인 목록(대표, 일반)
	 * @param searchVo
	 * @return
	 */
	public List<UserVo> findByApprvlN(SearchVo searchVo);
	/**
	 * 관리사 사용자 승인(대표, 일반)
	 * @param userId
	 * @param updatedBy
	 * @return
	 */
	public int updateApprovalById(String userId, String updatedBy);
}
