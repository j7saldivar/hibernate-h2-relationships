package com.saldivar.hibernate;

import java.io.IOException;
import java.sql.SQLException;

import org.h2.tools.Server;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) throws SQLException, IOException {

		SessionFactory factory = null;
		try {

			factory = new Configuration().configure().buildSessionFactory();

		} catch (Throwable e) {
			System.err.println("Failed to create SessionFactory object." + e);
		} finally {
			if (factory != null)
				factory.close();
		}

		startH2Server();

	}

	public static void startH2Server() throws SQLException, IOException {

		Server server = Server.createTcpServer().start();
		System.out.println(
				"\nAccess H2 Console using terminal:\n" + "java -cp h2-1.4.193.jar org.h2.tools.Console -web -browser");

		System.out.println("\nJDBC URL: jdbc:h2:" + server.getURL() + "/~/h2database");

		System.out.println("Press enter to stop.");
		System.in.read();

		System.out.println("Stopping server and closing the connection");
		server.stop();

	}
}
