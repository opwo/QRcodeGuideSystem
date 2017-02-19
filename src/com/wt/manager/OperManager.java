package com.wt.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wt.DB.DBOperation;

public class OperManager {
	
	
	/**
	 * ͨ���û���������֤�Ƿ��¼
	 * @param name
	 * @param pwd
	 * @return
	 */
	public  static boolean verifyLogin(String name,String pwd){
		Connection con = DBOperation.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from admin_table where name='"+name+"' and pwd='"+pwd+"'";
		try {
			 ps = con.prepareStatement(sql);
			 rs =  ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBOperation.closeAll(rs, ps, con);
		}
		return false;
		
	}
	/**
	 * ͨ��ID��֤�ܷ�ע��
	 * @param name
	 * @param pwd
	 * @return
	 */
	public  static boolean verifyID(int id){
		Connection con = DBOperation.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from admin_table where id ="+id;
		try {
			 ps = con.prepareStatement(sql);
			 rs =  ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBOperation.closeAll(rs, ps, con);
		}
		return false;
		
	}
	/**
	 * ��ѯ���й���Ա
	 * @return
	 */
	public static List<Manager> selectAdmin(){
		List<Manager> list = new ArrayList<Manager>();
		Connection con = DBOperation.getConnection();
		String sql = "select * from admin_table";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Manager mg = new Manager(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(mg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBOperation.closeAll(rs, ps, con);
		}
		
		return list;
		
	}
	
	
	
	public static List<Manager> fuzzySelectAdmin(String key){
		List<Manager> list = new ArrayList<Manager>();
		Connection con = DBOperation.getConnection();
		String sql = "select * from admin_table where name like '%"+key+"%'";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Manager mg = new Manager(rs.getInt(1), rs.getString(2), rs.getString(3));
				list.add(mg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBOperation.closeAll(rs, ps, con);
		}
		
		return list;
		
	}
	
	
	/**
	 * ����idɾ������Ա��
	 * @param id
	 * @return ����trueɾ���ɹ���falseʧ��
	 */
	public static boolean deleteAdmin(int id){
		Connection con = DBOperation.getConnection();
		PreparedStatement ps = null;
		String sql =" delete from admin_table where id ='"+id+"'";
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
	 * ����id�޸�
	 * @param id
	 * @param name
	 * @param pwd
	 * @return
	 */
	public static boolean modifyAdmin(int id,String name,String pwd){
		Connection con = DBOperation.getConnection();
		PreparedStatement ps = null;
		String sql ="UPDATE ADMIN_TABLE SET name ='"+name+"',PWD='"+pwd+"' where id='"+id+"'";
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
	 * �����Ա
	 * @param id
	 * @param name
	 * @param pwd
	 * @return
	 */
	public static boolean AddAdmin(int id,String name,String pwd){
		Connection con = DBOperation.getConnection();
		PreparedStatement ps = null;
		String sql ="INSERT INTO ADMIN_TABLE VALUES ("+id+",'"+name+"','"+pwd+"')";
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
	
}
