package com.internousdev.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.tweetapp.dto.TextInfoDTO;
import com.internousdev.tweetapp.util.DBConnector;

public class TextInfoDAO {
	public List<TextInfoDTO> getTextInfoAll(){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		List<TextInfoDTO> textInfoAllList=new ArrayList<TextInfoDTO>();

		String sql="select * from text_info";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				TextInfoDTO textInfoDTO=new TextInfoDTO();
				textInfoDTO.setId(rs.getInt("id"));
				textInfoDTO.setUserName(rs.getString("user_name"));
				textInfoDTO.setContent(rs.getString("content"));
				textInfoAllList.add(textInfoDTO);
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
		return textInfoAllList;
	}

	public List<TextInfoDTO> getTextInfo(String userName){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		List<TextInfoDTO> textInfoList=new ArrayList<TextInfoDTO>();

		String sql="select * from text_info where login_id=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userName);

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				TextInfoDTO textInfoDTO=new TextInfoDTO();
				textInfoDTO.setId(rs.getInt("id"));
				textInfoDTO.setUserName(rs.getString("user_name"));
				textInfoDTO.setContent(rs.getString("content"));
				textInfoList.add(textInfoDTO);
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
		return textInfoList;
	}

	public int setTextInfo(String userName,String content){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		int count = 0;
		String sql="insert into text_info(user_name,content,insert_date,update_date) values(?,?,now(),now())";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, content);

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

	public int updateContent(int id,String userName,String content){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		int count = 0;

		String sql="update text_info set content=? where id=? and user_name=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, id);
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
	public int deleteContent(int id, String userName){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		int count = 0;

		String sql="delete * from text_info where id=? and user_name=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, userName);

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
