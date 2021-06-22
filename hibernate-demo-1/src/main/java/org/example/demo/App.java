package org.example.demo;

import java.util.Properties;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.example.demo.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	static Logger logger = Logger.getLogger("org.example.demo.App.class");

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		try {
			Properties prop = new Properties();
			prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hr");

			// prop.setProperty("dialect", "org.hibernate.dialect.PostgresSQL");

			prop.setProperty("hibernate.connection.username", "user1");
			prop.setProperty("hibernate.connection.password", "pass1");
			// prop.setProperty("hibernate.connection.driver_class",
			// "org.postgresql.Driver");

			// SessionFactory factory=new
			// Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
			logger.info("session factory created");
			SessionFactory factory = new Configuration().addProperties(prop).addAnnotatedClass(Employee.class)
					.buildSessionFactory();
			Session session = factory.openSession();
			logger.info("session open");
			session.getTransaction().begin();
			session.save(new Employee(new Random().nextInt(100000), "Daniel", "Mark", "daniel@email.com"));
			session.getTransaction().commit();
			System.out.println("one item saved");
			logger.info("done");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
