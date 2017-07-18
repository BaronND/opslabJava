package app.service.sql;

public class BusinessLogSQL {
	public static final String HQL_QUERY_PAGE =
			"from BusinessLog a order by a.startTime desc, a.id desc";
}
