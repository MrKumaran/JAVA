package Learning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseInJAVA{
    public static void main(String[] args) throws Exception{
        String url = "jdbc:mysql://localhost:3306/sql_hr";
        String username = "root"; // MySQL credentials
        String password = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        String query = "Select * from employees";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()){
            System.out.println(rs.getString(1)+ " " + rs.getString(2) + " "+
                    rs.getString(3)+ " " + rs.getString(4) + " "+
                    rs.getString(5)+ " " + rs.getString(6) + " "+
                    rs.getString(7)+ " ");
        }
        st.close();
        con.close();
    }
}