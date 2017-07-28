package org.uncle.lee.sql;

public class ConsecutiveAvailableSeats {
	public static final String SQL = "select distinct a.seat_id"
			+ "from cinema a join cinema b"
			+ "on abs(a.cinema - b.cinema) = 1"
			+ "and a.free = true and b.free = true"
			+ "order by a.seat_id";
}
