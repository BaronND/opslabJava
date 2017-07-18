package SpringSE.test;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;

import SpringSE.Context;
import SpringSE.db.connection_db;


public class SpringTest {
	public static void main(String[] args) {

		ApplicationContext ctx = Context.getAppContext();
		
		connection_db db = (connection_db) ctx.getBean("connection_db");
		try {
			db.query();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
