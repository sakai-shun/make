package com.internousdev.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.tweetapp.dto.UserInfoDTO;
import com.internousdev.tweetapp.util.DBConnector;

public class UserInfoDAO {
	public UserInfoDTO getUserInfo(String loginId,String loginPass){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		UserInfoDTO userInfoDTO=new UserInfoDTO();

		String sql="select * from user_info where login_id=?,login_pass=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,loginId);
			ps.setString(2, loginPass);

			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				userInfoDTO.setLoginId(rs.getString("login_id"));
				userInfoDTO.setLoginPass(rs.getString("login_pass"));
				userInfoDTO.setUserName(rs.getString("user_name"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return userInfoDTO;
	}

	public int setUserInfo(String loginId,String loginPass,String userName){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		int count = 0;
		String sql="insert into user_info(login_id,login_pass,user_name,login_flag,insert_date,updated_date) values (?,?,?,0,now(),now())";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, loginPass);
			ps.setString(3, userName);

			count=ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return count;
	}

	public int updateLoginFlag(String loginId,String loginPass){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		int count = 0;
		String sql="update user_info set login_flag=1 where login_id=?";

		try{
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, loginPass);

			count=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return count;
	}
	public boolean isExistsUser(String loginId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;

		String sql="select count(*) as count from user_info where login_id=?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				if(rs.getInt("count")>0){
					result=true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	public boolean isExistsUserInfo(String loginId,String loginPass){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		boolean result=false;

		String sql="select count(*) as count from user_info where login_id=? and login_pass=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, loginPass);

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				if(rs.getInt("count")>0){
					result=true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}
	public int logout(String loginId,String loginPass){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		int count = 0;
		String sql="update user_info set login_flag=0 where login_id=?";

		try{
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, loginPass);

			count=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return count;
	}
}
