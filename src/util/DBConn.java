package util;

import java.sql.*;

public class DBConn {

    private static Connection dbCon = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    public static Connection getInstance() {
        if (dbCon == null) {
            try {
                // DB 접속부분
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String url = "Jdbc:oracle:thin:@localhost:1521:xe";
                // 각자 DB 사용자 이름과 비밀번호로 변경
                String id = "hr";
                String pw = "hr";
                dbCon = DriverManager.getConnection(url, id, pw);
                System.out.println("DB 연결중...");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return dbCon;
    }

    public static void dbClose() {
        try {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (dbCon != null)
                dbCon.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs = null;
            pstmt = null;
            dbCon = null;
        }
    }

    public static int statementUpdate(String sql) {
        DBConn.getInstance();
        int rValue = -1;
        if (dbCon != null) {
            try {
                if (pstmt == null) {
                    pstmt = dbCon.prepareStatement(sql);
                }
                rValue = pstmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("DB가 연결되지 않았습니다.");
        }
        return rValue;
    }

    public static ResultSet statementQuery(String sql) {
        DBConn.getInstance();
        if (DBConn.dbCon != null) {
            try {
                if (pstmt == null) {
                    pstmt =  dbCon.prepareStatement(sql);
                }
                rs = pstmt.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("DB가 연결되지 않았습니다.");
        }
        return rs;
    }

    public static ResultSet prepareStatementQuery1(String sql, int num) {
        DBConn.getInstance();
        if (DBConn.dbCon != null) {
            try {
                if (pstmt == null) {
                    pstmt =  dbCon.prepareStatement(sql);
                }
                pstmt = dbCon.prepareStatement(sql);
                pstmt.setInt(1, num);
                rs = pstmt.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("DB가 연결되지 않았습니다.");
        }
        return rs;
    }
}
