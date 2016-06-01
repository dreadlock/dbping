package com.main;

import java.io.Console;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    private static final String USAGE = 
	"java -jar dbping.jar <jdbc:oracle:thin:@myhost:1521:orcl> <USER>";

    public static void main(String[] args) throws Exception {
        if(args.length != 2) {
            System.out.println(USAGE);
        } else {
            System.exit(connect(args[0], args[1], password()));
        }
    }

    private static int connect(String url, String user, String pass)  {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(url, user, pass);
            connection.close();
            System.out.println("OK");
            return 0;
        } catch(Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
    public static String password() {
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);

        }

        String pw1 = new String(console.readPassword("Enter your secret password: "));
        String pw2 = new String(console.readPassword("Enter your secret password again: "));
	
	if (!pw1.equals(pw2)) {
            System.out.println("Passwords did not match. Exit.");
            System.exit(1);
	}
        //console.printf("Password entered was: %s%n", new String(passwordArray));
        return pw1;
    }
}
