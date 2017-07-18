package SpringSE.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class connection_db {

	private DataSource datasource =null;

	
	public DataSource getDatasource() {
		return datasource;
	}



	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public void query() throws SQLException{
		String sql = "Select table_name from tabs";
		PreparedStatement pstm = this.datasource.getConnection().prepareStatement(sql);
		System.out.println(pstm.executeQuery());
	}

	public static void main(String[] args) {

	}

}
