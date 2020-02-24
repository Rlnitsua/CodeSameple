package lizbyu.sql;

public class TriangleJudgement {
	public static final String SQL = "select"
			+ "case"
				+ "when t.x > 0 and t.y > 0 and t.z > 0 and"
				+ "(t.x + t.y > t.z) and"
				+ "(t.y + t.z > t.x) and"
				+ "(t.x + t.z > t.y) then 'YES'"
				+ "else 'NO'"
			+ "end as triangle"
		+ "from triangle t";
}
