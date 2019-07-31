package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/rest/client")
public class LoginController {
	@Autowired
	private RestTemplate restTemplate;

@RequestMapping(value="/callservice",method=RequestMethod.POST)

	public String invokeService(@RequestParam("t1") String  name,@RequestParam("t2") String pwd)
	{
	User usr=new User();
	usr.setName(name);
	usr.setPwd(pwd);
	System.out.println(usr.getName());
	String url="http://MyAuthService:8092/retrieve";
 String status= restTemplate.postForObject(url,usr,String.class);
 System.out.println(status);
	if(status.equals("true"))
	{
		return "hi";
	}
	
	else
		return "login";
}
}
