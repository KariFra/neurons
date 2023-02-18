package springboot.neuron;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;



@ConfigurationProperties("neuron")
public record NeuronProperties(
        String url,
        String lymphocyteUrl) {}
