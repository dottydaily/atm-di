package prob5_atmSpringJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainDatabase {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("atm-config-spring-jdbc-dao.xml");
        ATMSimulator atmSimulator = context.getBean("atmSimulator", ATMSimulator.class);
        atmSimulator.run();
    }
}
