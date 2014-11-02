package com.main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    private static final String USAGE = "URL||USER||PASS";

    public static void main(String[] args) throws Exception {
        if(args.length != 3) {
            System.out.println(USAGE);
        } else {
            System.out.println(connect(args[0], args[1], args[2]));
        }
    }

    private static int connect(String url, String user, String pass)  {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(url, user, pass);
            connection.close();
            return 0;
        } catch(Throwable t) {
            return 1;
        }
    }
}
