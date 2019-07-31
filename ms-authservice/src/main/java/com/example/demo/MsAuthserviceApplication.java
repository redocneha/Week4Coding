package com.example.demo;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class MsAuthserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAuthserviceApplication.class, args);
	}
	@PostMapping("/retrieve")
	 public String demoMethod(@RequestBody User usr)
	 {
		String name=usr.getName();
		String pwd=usr.getPwd();
		System.out.println(name);
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","Sapient123");
		Statement stmt1=con.createStatement();
		PrintWriter pw=new PrintWriter(System.out);
		ResultSet rs=stmt1.executeQuery("select * from user");
		while(rs.next())
		{
		String nam1=rs.getString(1);
		String nam2=rs.getString(2);
		if(nam1.equals(name)&&nam2.equals(pwd)) {
			
		return "true";
		
			
		}
		}
		
		}
		
		catch(Exception e)
		{
		System.out.println(e);
		}
		return "false";
	 }
	
}
