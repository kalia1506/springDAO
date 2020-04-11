package kcp.spring.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kcp.spring.bo.PersonalInfoBO;

@Repository("infoDAO")
public class PersonalInfoDAOImpl implements PersonalInfoDAO {
	@Autowired
	private SimpleJdbcInsert insert;

	public int insertData(PersonalInfoBO bo) {
		/*Map<String,Object> params=new HashMap<String, Object>();
		params.put("pid",bo.getPid());
		params.put("name",bo.getPname());
		params.put("address",bo.getAddress());
		params.put("company",bo.getCompany());
		params.put("deptno",bo.getDeptNo());
		params.put("desg",bo.getDesg() );
		params.put("salary",bo.getSalary());
		insert.withTableName("personal_info");*/
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("pid", bo.getPid());
		params.addValue("name", bo.getPname());
		params.addValue("address", bo.getAddress());
		params.addValue("company", bo.getCompany());
		params.addValue("deptno", bo.getDeptNo());
		params.addValue("desg", bo.getDesg());
		params.addValue("salary", bo.getSalary());
		insert.withTableName("personal_info");
		return insert.execute(params);
	}
}
