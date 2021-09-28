package com.kt.totaleyes.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kt.totaleyes.common.SearchVo;
import com.kt.totaleyes.vo.UserVo;

@Mapper
public interface UserMapper {

	/**
	 * 사용자 user_id 카운트
	 * @param userId
	 * @return
	 */
	public int countById(String userId);
	/**
	 * 사용자 사업자 등록번호 카운드
	 * @param bizNo
	 * @return
	 */
	public int countByBizNo (String bizNo);
	/**
	 * 사용자 biz 회원 가입시 biz_seq와 biz_no가 존재 하는지 카운드
	 * @param bizSeq
	 * @param bizNo
	 * @return
	 */
	public int countByBizNoAndApprvlY (@Param("bizSeq")Integer bizSeq, @Param("bizNo") String bizNo);
	/**
	 * 사용자 biz_seq 조회
	 * @param bizNo
	 * @param bizNm
	 * @return
	 */
	public Integer findBizSeqByBizNoAndApprvlY (@Param("bizNo")String bizNo, @Param("bizNm")String bizNm);
	/**
	 * 사용자 회원가입(회사 대표)
	 * @param userVo
	 * @return
	 */
	public int createBiz (UserVo userVo);
	/**
	 * 사용자 회원가입(회사)
	 * @param userVo
	 * @return
	 */
	public int createBizUser (UserVo userVo);
	/**
	 * 사용자 회원가입(일반)
	 * @param userVo
	 * @return
	 */
	public int createUser(UserVo userVo);
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
	 * 관리자/사용자 사용자 조회
	 * @param userId
	 * @return
	 */
	public UserVo findById(String userId);
	/**
	 * 관리자 사용자 승인
	 * @param userId
	 * @param updatedBy
	 * @return
	 */
	public int updateForApprvl(@Param("userId") String userId, @Param("updatedBy") String updatedBy);
	/**
	 * 관리자 비즈 승인
	 * @param bizSeq
	 * @param updatedBy
	 * @return
	 */
	public int updateForBizApprvl(@Param("bizSeq") Integer bizSeq, @Param("updatedBy") String updatedBy);
	
	public int deleteById(String userId);
	public int deleteByBizSeq(Integer bizSeq);
	public int deleteBizById(Integer bizSeq);
}
