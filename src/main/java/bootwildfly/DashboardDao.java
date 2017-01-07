package bootwildfly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DashboardDao implements IDashboardDao {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://54.169.121.47/sys";

	// Database credentials
	static final String USER = "batteryadmin";
	static final String PASS = "battery123";

	@Override
	public Map<String, String> getLatestMonitorStatus() throws SQLException, ClassNotFoundException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			Map<String, String> status = new HashMap<>();
			Statement stmt = connection.createStatement();

			String sql = "select * from sys.mod_monitor_status order by last_updated DESC limit 1";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String volt = rs.getString("mod_voltage");
				String current = rs.getString("mod_current");
				String soc = rs.getString("mod_SOC");
				status.put("VOLT", volt);
				status.put("Current", current);
				status.put("soc", soc);
			}
			rs.close();
			return status;
		} finally {
			if (null != connection) {
				connection.close();
			}
		}
	}

}
