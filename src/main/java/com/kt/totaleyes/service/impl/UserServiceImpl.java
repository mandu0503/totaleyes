package com.kt.totaleyes.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kt.totaleyes.common.Const;
import com.kt.totaleyes.common.Role;
import com.kt.totaleyes.common.SearchVo;
import com.kt.totaleyes.mapper.UserMapper;
import com.kt.totaleyes.service.UserService;
import com.kt.totaleyes.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int countById(String userId) {
		// TODO Auto-generated method stub
		return userMapper.countById(userId);
	}
	
	@Override
	public int countByBizNo(String bizNo) {
		// TODO Auto-generated method stub
		return userMapper.countByBizNo(bizNo);
	}

	@Override
	public Integer findBizSeqByBizNoAndApprvlY(String bizNo, String bizNm) {
		// TODO Auto-generated method stub
		return userMapper.findBizSeqByBizNoAndApprvlY(bizNo, bizNm);
	}

	@Override
	@Transactional
	public boolean createUser(UserVo userVo) {
		// TODO Auto-generated method stub
		
		userVo.setUserRole(Role.ROLE_USER.toString());
		
		if (StringUtils.equals(Const.YES, userVo.getMstrYn())) {
			if (StringUtils.isNotEmpty(userVo.getBizNo()) && userMapper.countByBizNo(userVo.getBizNo()) == 0) {
				userMapper.createBiz(userVo);
				userMapper.createBizUser(userVo);
			} else {
				return false;
			}
		} else if (StringUtils.equals(Const.NO, userVo.getMstrYn())) {
			if (userVo.getBizSeq() != null && userVo.getBizSeq() > 0 && userMapper.countByBizNoAndApprvlY(userVo.getBizSeq(), userVo.getBizNo()) > 0) {
				userMapper.createBizUser(userVo);
			} else {
				return false;
			}
		} else if (StringUtils.isEmpty(userVo.getMstrYn())) {
			userMapper.createUser(userVo);
		} else {
			return false;
		}

		return true;
	}

	@Override
	public int countByApprvlN(SearchVo searchVo) {
		// TODO Auto-generated method stub
		return userMapper.countByApprvlN(searchVo);
	}

	@Override
	public List<UserVo> findByApprvlN(SearchVo searchVo) {
		// TODO Auto-generated method stub
		return userMapper.findByApprvlN(searchVo);
	}

	@Override
	@Transactional
	public int updateApprovalById(String userId, String updatedBy) {
		// TODO Auto-generated method stub
		
		UserVo userVo = userMapper.findById(userId);
		
		if (userVo != null && StringUtils.equals(Const.NO, userVo.getApprvlYn()) 
				&& (userVo.getMstrYn() == null || StringUtils.equals(Const.YES, userVo.getMstrYn()))) {
			if (StringUtils.equals(Const.YES, userVo.getMstrYn())) {
				userMapper.updateForBizApprvl(userVo.getBizSeq(), updatedBy);
			}
			return userMapper.updateForApprvl(userId, updatedBy);
		}
		
		return 0;
	}

	
}
