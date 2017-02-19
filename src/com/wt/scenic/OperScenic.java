package com.wt.scenic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wt.DB.DBOperation;
import com.wt.manager.Manager;

public class OperScenic {
	/**
	 * 添加景点
	 */
	public static boolean addScenic(ScenicInfo scenic){
		Connection con = DBOperation.getConnection();
		PreparedStatement ps = null;
		String sql ="INSERT INTO scenic_table VALUES ("+scenic.getScenicid()+",'"+scenic.getScenicname()+"','"+scenic.getSceniccontents()+"')";
		try {
			ps = con.prepareStatement(sql);
			if(ps.executeUpdate()>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBOperation.closeAll(null, ps, con);
		}
		
		return false;
	}
	/**
	 * 查看景点
	 */
	public static List<ScenicInfo> selectScenic(){
		List<ScenicInfo> list = new ArrayList<ScenicInfo>();
		Connection con = DBOperation.getConnection();
		String sql = "select * from SCENIC_TABLE";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				ScenicInfo sc = new ScenicInfo(rs.getString(1), rs.getString(2), rs.getString(3));
				list.add(sc);
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
