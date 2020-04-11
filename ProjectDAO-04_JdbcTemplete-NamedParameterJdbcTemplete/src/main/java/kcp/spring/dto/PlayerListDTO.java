package kcp.spring.dto;

import lombok.Data;

@Data
public class PlayerListDTO {
	private String playerName;
	private int pid;
	private String player_type;
	private String destinationPlace;
	private int salary;
	private String grade;
}
