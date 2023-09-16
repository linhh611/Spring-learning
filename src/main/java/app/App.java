package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        //SpringApplication.run(App.class, args);

        SpringApplication application = new SpringApplication((App.class));
        ConfigurableEnvironment environment = new StandardEnvironment();

        environment.setActiveProfiles("local");
        application.setEnvironment(environment);
        ApplicationContext context = application.run(args);
        LocalDatasource localDatasource = context.getBean(LocalDatasource.class);
        System.out.println(localDatasource);
    }
}
