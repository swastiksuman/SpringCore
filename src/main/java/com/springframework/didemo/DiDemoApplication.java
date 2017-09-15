package com.springframework.didemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.springframework.didemo.controllers.ConstructorInjectedController;
import com.springframework.didemo.controllers.GetterInjectedController;
import com.springframework.didemo.controllers.MyController;
import com.springframework.didemo.controllers.PropertyInjectedController;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springframework.didemo.services", "com.springframework.didemo.controllers"
		, "com.springframework.didemo"})
public class DiDemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		controller.hello();

		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(GetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
	}
}
