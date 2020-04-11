package kcp.springJDBC.bo;

import lombok.Data;

@Data
public class PlayerListBO {
	private String playerName;
	private int pid;
	private String player_type;
	private String country;
	private int salary;
	private String grade;

}
