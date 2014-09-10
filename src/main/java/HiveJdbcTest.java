import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

class HiveJdbcTest {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Class.forName("org.apache.hive.jdbc.HiveDriver");

    Connection connection = DriverManager
        .getConnection("jdbc:hive2://localhost:10000", "lian", "");

    ResultSet resultSet = connection
        .getMetaData()
        .getTables(null, "default", null, new String[]{"TABLE"});

    while (resultSet.next()) {
      System.out.printf("%s, %s, %s, %s, %s\n",
          resultSet.getString("TABLE_CAT"),
          resultSet.getString("TABLE_SCHEM"),
          resultSet.getString("TABLE_NAME"),
          resultSet.getString("TABLE_TYPE"),
          resultSet.getString("REMARKS"));
    }

    connection.close();
  }
}
