package springboot.lymphocyte;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.client.MockRestServiceServer;
import springboot.neuron.NeuronProperties;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@Import({NeuronProperties.class, String.class})
@RestClientTest(LymphocyteClient.class)
@ActiveProfiles("test")
class LymphocyteClientTest {

    @Autowired
    private LymphocyteClient lymphocyteClient;

    @Autowired
    private NeuronProperties neuronProperties;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;


    @Test
    void lymphocyteClientSuccessfullyReturnsLymphocyte() throws JsonProcessingException {
        var lymphocyteDto = new LymphocyteDto(1L,"Type B",false);
        this.mockRestServiceServer
                .expect(requestTo("/api/v1/lymph/1"))
                .andRespond(withSuccess(objectMapper.writeValueAsString(lymphocyteDto), MediaType.APPLICATION_JSON));

        LymphocyteDto result = lymphocyteClient.getLymphocyteId(1L);

        assertNotNull(result);
    }
}