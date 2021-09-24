package com.kt.totaleyes.service;

import java.util.List;

import com.kt.totaleyes.common.SearchVo;
import com.kt.totaleyes.vo.UserVo;

public interface UserService {

	public int findByBizNo (String bizNo);
	public int findByBizNoAndApprvlY (String bizNo);
	public boolean createUser(UserVo userVo);

	public int countByApprvlN(SearchVo searchVo);
	public List<UserVo> findByApprvlN(SearchVo searchVo);
}
