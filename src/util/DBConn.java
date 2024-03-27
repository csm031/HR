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


    public static ResultSet statementQuery(String sql) {
        DBConn.getInstance();
        if (DBConn.dbCon != null) {
            try {
                if (pstmt == null) {
                    pstmt = dbCon.prepareStatement(sql);
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

    public static ResultSet selectWhereQuery(String sql, int num) {
        DBConn.getInstance();
        if (DBConn.dbCon != null) {
            try {
                if (pstmt == null) {
                    pstmt = dbCon.prepareStatement(sql);
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

    public static int deleteQuery(String sql, int num) {
        DBConn.getInstance();
        int result = 0;
        if (DBConn.dbCon != null) {
            try {
                if (pstmt == null) {
                    pstmt = dbCon.prepareStatement(sql);
                }
                pstmt = dbCon.prepareStatement(sql);
                pstmt.setInt(1, num);
                result = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("DB가 연결되지 않았습니다.");
        }
        return result;
    }

    public static int insertQuery(String sql, String[] data) {
        DBConn.getInstance();
        int result = 0;
        if (DBConn.dbCon != null) {
            try {
                if (pstmt == null) {
                    pstmt = dbCon.prepareStatement(sql);
                }
                pstmt = dbCon.prepareStatement(sql);
                pstmt.setString(1, data[0]);
                pstmt.setString(2, data[1]);
                pstmt.setString(3, data[2]);
                pstmt.setString(4, data[3]);
                pstmt.setString(5, data[4]);
                result = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("DB가 연결되지 않았습니다.");
        }
        return result;
    }

    public static int updateQuery(String sql, Object[] data) {
        DBConn.getInstance();
        int result = 0;
        if (DBConn.dbCon != null) {
            try {
                if (pstmt == null) {
                    pstmt = dbCon.prepareStatement(sql);
                }
                pstmt = dbCon.prepareStatement(sql);
                pstmt.setString(1, (String) data[1]);
                pstmt.setInt(2, (int) data[0]);
                result = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("DB가 연결되지 않았습니다.");
        }
        return result;
    }

    public static int updateQuery2(String sql, Object[] data) {
        DBConn.getInstance();
        int result = 0;
        if (DBConn.dbCon != null) {
            try {
                if (pstmt == null) {
                    pstmt = dbCon.prepareStatement(sql);
                }
                pstmt = dbCon.prepareStatement(sql);
                pstmt.setInt(1, (int) data[0]);
                result = pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("DB가 연결되지 않았습니다.");
        }
        return result;
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
}