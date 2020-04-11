package kcp.spring.dto;

import lombok.Data;

@Data
public class PersonalInfoDTO {
	private int pid;
	private String pname;
	private String address;
	private String company;
	private int deptNo;
	private String desg;
	private double salary;
}
