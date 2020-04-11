package kcp.spring.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;


@Repository("authDAO")
public class AuthonticateDAOImpl implements AuthonticateDAO {
	@Autowired
	private SimpleJdbcCall call;

	public String Login(String userName, String password) {
		Map<String,Object> inParams=new HashMap<String, Object>();
		inParams.put("UN", userName);
		inParams.put("PWD",password);
		//System.out.println(inParams);
		call.setProcedureName("P_AUTHONTICATION");
		Map<String,Object> outParams=call.execute(inParams);
		String result=(String) outParams.get("result");
		return result;
	}

}
