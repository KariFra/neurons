package springboot.lymphocyte;

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
    private MockRestServiceServer mockRestServiceServer;


    @Test
    void lymphocyteClientSuccessfullyReturnsLymphocyte() {
        String json = """
                    {
                    "id": 1,
                        "type": "Type B",
                        "identifiedInvader": false
                }""";
        this.mockRestServiceServer
                .expect(requestTo("/api/v1/lymph/1"))
                .andRespond(withSuccess(json, MediaType.APPLICATION_JSON));

        LymphocyteDto result = lymphocyteClient.getLymphocyteId(1L);

        assertNotNull(result);
    }
}