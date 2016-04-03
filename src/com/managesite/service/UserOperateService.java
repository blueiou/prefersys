package com.managesite.service;

import com.managesite.dao.impl.UserOperateDaoImpl;

public class UserOperateService {
private UserOperateDaoImpl userOperateDaoImpl;

public UserOperateDaoImpl getUserOperateDaoImpl() {
	return userOperateDaoImpl;
}

public void setUserOperateDaoImpl(UserOperateDaoImpl userOperateDaoImpl) {
	this.userOperateDaoImpl = userOperateDaoImpl;
}

}
