package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.PlayerRegistrationBO;

public final class PlayerRegistrationImpl implements PlayerRegistration{
	private DataSource ds;
	private static final String PLAYER_REGISTRATION_QUERY ="INSERT INTO PLAYER_REGISTRATION VALUES(PNO_SEQ1.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
	
	//consturctor

	public PlayerRegistrationImpl(DataSource ds) {
	
		this.ds = ds;
	}




	@Override
	public int insert(PlayerRegistrationBO bo) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		
		//get Connection
		con=ds.getConnection();
		//get prparestatement
		ps=con.prepareStatement(PLAYER_REGISTRATION_QUERY);
		//store result
		ps.setString(1, bo.getpName());
		ps.setInt(2, bo.getAge());
		ps.setString(3, bo.getCountry());
		ps.setString(4, bo.getTeam());
		ps.setInt(5, bo.getMatches());
		ps.setInt(6, bo.getInnings());
		ps.setInt(7, bo.getTotalRun());
		ps.setInt(8, bo.getTotalWicket());
		ps.setFloat(9, bo.getAverageRun());
		ps.setFloat(10, bo.getAverageWicket());
		count = ps.executeUpdate();

		// close conn
		ps.close();
		con.close();

		return count;
		
		
		
	}
}
