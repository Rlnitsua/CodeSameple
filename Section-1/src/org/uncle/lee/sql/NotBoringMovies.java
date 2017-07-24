package org.uncle.lee.sql;

public class NotBoringMovies {
	public static final String SQL = "select * from cinema"
			+ "where"
				+ "description != 'boring'"
				+ "and id % 2 != 0"
			+ "order by rating desc";
}
