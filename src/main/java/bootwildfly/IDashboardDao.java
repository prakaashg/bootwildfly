package bootwildfly;

import java.sql.SQLException;
import java.util.Map;

public interface IDashboardDao {

	Map<String, String> getLatestMonitorStatus() throws SQLException, ClassNotFoundException;

}
