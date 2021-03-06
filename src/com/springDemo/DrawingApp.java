package com.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DrawingApp {

    public static void main(String[] args) {
        //BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
        //Big brother of BeanFactory with extra feature like eventNotification and AOP,
        // there is no diff in cost and performance, use BF only if there is resource scarcity
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        applicationContext.registerShutdownHook();
        Shape shape = (Shape) applicationContext.getBean("circle");
        shape.draw();

        System.out.println(applicationContext.getMessage("greeting", null, "Default greeting", null));
    }
}
