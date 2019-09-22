package prob3_atmJavaConfigDI;

import prob3_atmJavaConfigDI.config.ATMSimulatorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MainJavaConfig {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ATMSimulatorConfig.class);
        ATMSimulator atmSimulator = context.getBean("atmSimulator", ATMSimulator.class);
        atmSimulator.run();
    }
}
