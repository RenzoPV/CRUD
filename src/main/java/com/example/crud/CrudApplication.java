package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		System.out.println("MYSQLHOST: " + System.getenv("MYSQLHOST"));
		System.out.println("MYSQLPORT: " + System.getenv("MYSQLPORT"));
		System.out.println("MYSQLDATABASE: " + System.getenv("MYSQLDATABASE"));
		System.out.println("MYSQLUSER: " + System.getenv("MYSQLUSER"));
		System.out.println("MYSQLPASSWORD: " + System.getenv("MYSQLPASSWORD"));
		SpringApplication.run(CrudApplication.class, args);
	}

}
