package kcp.spring.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kcp.spring.bo.PersonalInfoBO;
import kcp.spring.dao.PersonalInfoDAO;
import kcp.spring.dto.PersonalInfoDTO;

@Service("Service")
public class PersonalInfoServiceIMPL implements PersonalInfoService {
	@Autowired
	PersonalInfoDAO dao;

	public String FatchData(PersonalInfoDTO dto) {
		PersonalInfoBO bo = null;
		int count = 0;
		bo = new PersonalInfoBO();
		BeanUtils.copyProperties(dto, bo);
		count = dao.insertData(bo);
		if (count == 1) {
			return " insert sucvessfully";
		} else {
			return "failed";
		}
	}

}
