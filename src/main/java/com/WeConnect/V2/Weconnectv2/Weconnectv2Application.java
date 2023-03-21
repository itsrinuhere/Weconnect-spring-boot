package com.WeConnect.V2.Weconnectv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SpringBootApplication
public class Weconnectv2Application {

	public static void main(String[] args) {
		SpringApplication.run(Weconnectv2Application.class, args);
	}
	@RequestMapping("/")
	public ModelAndView home()
	{
		System.out.println("HOME PAGE invoked to check out the documentation");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
