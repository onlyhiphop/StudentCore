package com.edcu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edcu.domain.Score;
import com.edcu.util.ConnectUtil;

public class ScoreDao {
	
	Connection conn = null;
	ResultSet rs = null;
	
	//查询某门课程所有学生的分数
	public ArrayList<Score> getAllStuScore(String courseNO) throws SQLException{
		ArrayList<Score> scoreList = new ArrayList<Score>();
		conn = ConnectUtil.getConnect();
		
		String sql = "SELECT STU.STUNO,STU.STUNAME,SCO.TYPE,SCO.SCORE "
				+ "FROM T_STUDENT STU,T_SCORE SCO "
				+ "WHERE STU.STUNO=SCO.STUNO "
				+ "AND SCO.COURSENO=?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, courseNO);
		rs = ps.executeQuery();
		
		while(rs.next()){
			String stuNo = rs.getString("STUNO");
			String stuName = rs.getString("STUNAME");
			String type = rs.getString("TYPE");
			String core = rs.getString("SCORE");
			Score score = new Score(stuNo, stuName, type, core);
			scoreList.add(score);
		}
		ConnectUtil.Close(conn, null, rs);
		ps.close();
		return scoreList;
	}
	
	//修改某个学生某个类型的成绩
	public void UpdateStuScore(Score score,String courseNo) throws SQLException{
		
		conn = ConnectUtil.getConnect();
		
		String sql = "UPDATE T_SCORE SET SCORE=? "
				+ "WHERE TYPE=? AND STUNO=? AND COURSENO=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, score.getCore());
		ps.setString(2, score.getType());
		ps.setString(3, score.getStuNo());
		ps.setString(4, courseNo);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	
}
