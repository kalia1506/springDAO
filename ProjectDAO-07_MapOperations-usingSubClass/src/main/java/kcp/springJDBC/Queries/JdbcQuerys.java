package kcp.springJDBC.Queries;

public class JdbcQuerys {
	public final static String playerNamebyId = "select * from playerslist where pid=?";
	public final static String PlayerListByType="select * from playerslist where player_type in(?,?)";
}
