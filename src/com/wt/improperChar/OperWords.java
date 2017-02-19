package com.wt.improperChar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wt.DB.DBOperation;

public class OperWords {
	public static List<ImproperWord> selectWord(){
		List<ImproperWord> list = new ArrayList<ImproperWord>();
		Connection con = DBOperation.getConnection();
		String sql = "select * from IMPROPER_CHARACTER";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				ImproperWord iw = new ImproperWord();
				iw.setWords(rs.getString(1));
				list.add(iw);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBOperation.closeAll(rs, ps, con);
		}
		
		return list;
		
	}
}
