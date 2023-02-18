package springboot.lymphocyte;

import springboot.neuron.NeuronProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class LymphocyteClient {
    private final String PATH = "/api/v1/lymph";
    private final NeuronProperties neuronProperties;
    private final RestTemplate restTemplate;

    public LymphocyteClient(NeuronProperties neuronProperties, RestTemplateBuilder restTemplateBuilder) {
        this.neuronProperties = neuronProperties;
        this.restTemplate = restTemplateBuilder.build();
    }

    public LymphocyteDto getLymphocyteId(Long lymphocyteId) {
        return restTemplate.getForObject(neuronProperties.lymphocyteUrl() + PATH + "/" + lymphocyteId, LymphocyteDto.class);
    }

    public void createLymphocyte() {
        restTemplate.postForEntity(neuronProperties.lymphocyteUrl() + PATH, null, Void.class);
    }
}
