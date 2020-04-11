package kcp.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kcp.spring.dao.AuthonticateDAO;
@Service("authService")
public class AuthonticateServiceImpl implements AuthonticateService {
	@Autowired
	private AuthonticateDAO dao;

	public String fatchLogin(String UserName, String password) {
		return dao.Login(UserName, password);
	}

}
