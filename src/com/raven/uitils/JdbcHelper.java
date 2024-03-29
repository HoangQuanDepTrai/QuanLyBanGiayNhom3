package com.raven.uitils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lê Minh Khôi
 */
public class JdbcHelper {

    public static String connectionURL
            = "jdbc:sqlserver://LocalHost:1433;"
            + "database=QL_SHOPGIAY;"
            + "user=sa;"
            + "password=123;"
            + "encrypt=false;"
            + "trustServerCertificate=false;"
            + "loginTimeout=30;";

    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection conn = DriverManager.getConnection(connectionURL);
        PreparedStatement pstm = null;
        if (sql.trim().startsWith("{")) {
            pstm = conn.prepareCall(sql);
        } else {
            pstm = conn.prepareStatement(sql);

        }
        for (int i = 0; i < args.length; i++) {
            pstm.setObject(i + 1, args[i]);
        }
        return pstm;
    }

    public static int update(String sql, Object... agrs) {
        try {
            PreparedStatement pps = getStmt(sql, agrs);
            try {
                return pps.executeUpdate();
            } finally {
                pps.getConnection().close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JdbcHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static ResultSet query(String sql, Object... agrs) {
        try {
            PreparedStatement pps = getStmt(sql, agrs);
            return pps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(JdbcHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Object value(String columnName, String sql, Object... agrs) {
        try {
            ResultSet rs = query(sql, agrs);
            if (rs.next()) {
                return rs.getObject(columnName);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(JdbcHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
