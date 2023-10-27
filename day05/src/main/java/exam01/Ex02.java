package exam01;

import java.sql.*;

public class Ex02 {
    public static void main(String[] args) throws ClassNotFoundException {

    Class.forName("oracle.jdbc.driver.OracleDriver");
    String url = "jdbc:oracle:thin:@localhost:1521:XE?user=scott&password=tiger";
    String sql = "SELECT * FROM DEPT2";

    try(Connection conn = DriverManager.getConnection(url)) {
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);

        while(result.next()){
            int deptNo = result.getInt("DEPTNO");
            String dName = result.getString("DNAME");
            String loc = result.getString("LOC");
            System.out.printf("DEPTNO=%S, DNAME=%s, LOC=%s%n", deptNo, dName, loc);
        }

    } catch (SQLException e){
        e.printStackTrace();
    }
    }
}
