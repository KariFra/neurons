package springboot.lymphocyte;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ActiveProfiles("test")
class LymphocyteClientTest {

    private LymphocyteClient lymphocyteClient;

    private MockWebServer mockWebServer;

    @BeforeEach
    void setUp() {
        mockWebServer = new MockWebServer();
        lymphocyteClient = new LymphocyteClient(WebClient.builder().build());
    }

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.close();
    }

    @Test
    void lymphocyteClientSuccessfullyReturnsLymphocyte() throws JsonProcessingException {
        var lymphocyteDto = new LymphocyteDto(1L, "Type B", false);
        mockWebServer.enqueue(
                new MockResponse()
                        .setResponseCode(200)
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setBody(new ObjectMapper().writeValueAsString(lymphocyteDto))
        );
        Mono<LymphocyteDto> monoResult = lymphocyteClient.getLymphocyteIdAsync(1L);

        assertNotNull(monoResult);
        monoResult.map(result -> {
            assertEquals(1L, result.getId());
            assertEquals("Type B", result.getType());
            assertEquals(false, result.isIdentifiedInvader());
            return null;
        });
    }
}