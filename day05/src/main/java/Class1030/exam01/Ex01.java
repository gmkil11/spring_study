package Class1030.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01 {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String userId = "scott";
        String userPw = "tiger";
        Class.forName("oracle.jdbc.driver.OracleDriver"); // 오라클 클래스 파일을 동적로딩 시킨다. (런타임에 실행시킨다는 뜻)
        System.out.println("드라이버 호출 성공");

        System.out.println("DB 연결 준비...");
        try(Connection conn = DriverManager.getConnection(url, "SCOTT", "tiger")) {
            System.out.println("DB 연결 성공!");
            Statement stmt = conn.createStatement();
            int deptNo = 50;
            String dName = "DEPT1";
            String loc = "LOC1";

            String sql = "INSERT INTO DEPT2 VALUES ("+ deptNo +", '" + dName + "', '" + loc +"')";
            int affectedRow = stmt.executeUpdate(sql);

            System.out.println(affectedRow);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
