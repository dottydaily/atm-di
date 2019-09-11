package prob3_atmJavaConfigDI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import prob3_atmJavaConfigDI.ATM;
import prob3_atmJavaConfigDI.ATMSimulator;
import prob3_atmJavaConfigDI.Bank;
import prob3_atmJavaConfigDI.DataSource;

@Configuration  // put this annotation on java class that you need to set bean
public class ATMSimulatorConfig {
    @Bean   // set this on each beans, then write a constructor of each beans
    public ATMSimulator atmSimulator() {
        return new ATMSimulator(atm());
    }

    @Bean
    public ATM atm() {
        return new ATM(bank());
    }

    @Bean
    public Bank bank() {
        return new Bank(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        return new DataSource("customers.txt");
    }

}
