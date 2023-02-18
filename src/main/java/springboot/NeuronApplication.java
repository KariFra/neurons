package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class NeuronApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeuronApplication.class, args);
	}

}
