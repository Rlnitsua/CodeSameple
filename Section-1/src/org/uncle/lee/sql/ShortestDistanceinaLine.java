package org.uncle.lee.sql;

public class ShortestDistanceinaLine {
	public static final String SQL = "select"
			+ "min(abs(p1.x - p2.x)) as shortest"
			+ "from"
				+ "point p1"
					+ "join"
				+ "point p2 on p1.x != p2.x";
}
