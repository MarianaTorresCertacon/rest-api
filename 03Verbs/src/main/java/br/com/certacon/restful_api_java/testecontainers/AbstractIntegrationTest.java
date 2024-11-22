package br.com.certacon.restful_api_java.testecontainers;

import org.hibernate.service.spi.Startable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(inheritInitializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest {

    public class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

//        static MySQLContainer<?>

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {

        }
    }
}
