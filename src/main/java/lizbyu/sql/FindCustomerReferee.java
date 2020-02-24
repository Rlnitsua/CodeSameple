package lizbyu.sql;

public class FindCustomerReferee {
	public static final String SQL = "select name from customer"
			+ "where"
				+ "referee_id is null or"
				+ "referee_id != 2";
}
