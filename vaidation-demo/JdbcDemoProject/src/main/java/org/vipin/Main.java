package org.vipin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "12345678";

        Connection con =
                DriverManager.getConnection(url, username, password);

        System.out.println("Database connected successfully");
        Statement st = con.createStatement();
        System.out.println("System created...");
        st.executeUpdate("CREATE TABLE student(" + "id INT PRIMARY KEY," + "name VARCHAR(100))"
        );
        st.executeUpdate(

                "INSERT INTO student " +
                        "VALUES(1,'Rahul')"

        );
        st.executeUpdate(

                "UPDATE student " +
                        "SET name='Aman' " +
                        "WHERE id=1"

        );
        st.executeUpdate(

                "DELETE FROM student " +
                        "WHERE id=1"

        );
        ResultSet rs =
                st.executeQuery(

                        "SELECT * FROM student"

                );
        System.out.println(rs);

        con.close();


    }
}