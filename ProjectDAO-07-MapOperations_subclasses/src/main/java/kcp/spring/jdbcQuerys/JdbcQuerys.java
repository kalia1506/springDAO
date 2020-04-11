package kcp.spring.jdbcQuerys;

public interface JdbcQuerys {
	String playerNamebyId = "select * from playerslist where pid=?";
	String PlayerListByType = "select * from playerslist where player_type in(?,?)";
	String PlayerListhikeSalByType = "update playerslist set salary=salary+? where player_type in(?)";

}
