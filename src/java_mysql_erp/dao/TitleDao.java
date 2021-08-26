package java_mysql_erp.dao;

import java.util.ArrayList;

import java_mysql_erp.dto.Title;

public interface TitleDao {
	// select, delete, insert, update
	ArrayList<Title> selectTitleByAll();
	
	Title selectTitleByCode(Title title);
	
	int insertTitle(Title title);
	
	int updateTitle(Title title);
	
	int deleteTitle(Title title);
}
