package java_mysql_erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_mysql_erp.dao.TitleDao;
import java_mysql_erp.dto.Title;
import java_mysql_erp.util.JdbcUtil;

public class TitleDaoImpl implements TitleDao {
	private static final TitleDaoImpl instance = new TitleDaoImpl();

	private TitleDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static TitleDaoImpl getInstance() {
		return instance;
	}

	@Override
	public ArrayList<Title> selectTitleByAll() {
		String sql = "select code, name from title";
		ArrayList<Title> list = new ArrayList<Title>();
		
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
		
			while(rs.next()) {
				list.add(getTitle(rs));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;// size가 0이거나 그렇지 않은 경우
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		int code = rs.getInt("code");
		String name = rs.getString("name");
		return new Title(code, name);
	}

	@Override
	public Title selectTitleByCode(Title title) {
		String sql = "select code, name from title where code = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setInt(1, title.getCode());
			System.out.println("pstmt >> " + pstmt);
			
			try(ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				return getTitle(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertTitle(Title title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTitle(Title title) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTitle(Title title) {
		// TODO Auto-generated method stub
		return 0;
	}

}
