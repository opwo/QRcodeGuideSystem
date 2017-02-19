package com.wt.notification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.wt.DB.DBOperation;

public class OperNotification {
	/**
	 * 查看所有通知
	 * @return
	 */
	public static List<Notification> selectNotifi() {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con=DBOperation.getConnection();
		List<Notification> list = new ArrayList<Notification>();
		String sql = "select * from notification_table order by time desc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Notification nfc = new Notification(rs.getString(1), rs.getString(2), rs.getTimestamp(3));
				list.add(nfc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBOperation.closeAll(rs, ps, con);
		}
		return list;
		
	}

	public static boolean AddNotification(Notification noti){
		Connection con = DBOperation.getConnection();
		PreparedStatement ps = null;
		String sql ="INSERT INTO NOTIFICATION_TABLE VALUES(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, noti.getTitle());
		    ps.setString(2, noti.getContent());
		            Timestamp ta = new Timestamp(noti.getDate().getTime());
		    ps.setTimestamp(3, ta);
		   
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
	 * 根据时间删除通知
	 * @param Time
	 * @return
	 */
	public static boolean deleteNotification(long Time){
		Connection con = DBOperation.getConnection();
		PreparedStatement ps = null;
		String sql =" delete from NOTIFICATION_TABLE where time =?";
		try {
			ps = con.prepareStatement(sql);
			Timestamp time = new Timestamp(Time);
			ps.setTimestamp(1, time);
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
}
