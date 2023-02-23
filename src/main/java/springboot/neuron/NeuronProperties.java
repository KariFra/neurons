package springboot.neuron;

import org.springframework.boot.context.properties.ConfigurationProperties;




@ConfigurationProperties("neuron")
public record NeuronProperties(
        String url,
        String lymphocyteUrl,
        int webClientTimeout) {}
