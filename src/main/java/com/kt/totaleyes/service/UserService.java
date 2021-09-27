package com.kt.totaleyes.service;

import java.util.List;

import com.kt.totaleyes.common.SearchVo;
import com.kt.totaleyes.vo.UserVo;

public interface UserService {

	public int countById (String userId);
	public int countByBizNo (String bizNo);
	public int countByBizNoAndApprvlY (String bizNo);
	public boolean createUser(UserVo userVo);

	public int countByApprvlN(SearchVo searchVo);
	public List<UserVo> findByApprvlN(SearchVo searchVo);
}
