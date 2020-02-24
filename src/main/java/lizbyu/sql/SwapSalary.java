package lizbyu.sql;

public class SwapSalary {
	public static final String SQL = "update salary set sex = "
			+ "case sex"
			+ "when 'm'"
				+ "then 'f'"
			+ "else 'm'"
			+ "end";
}
