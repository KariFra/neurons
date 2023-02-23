package springboot.lymphocyte;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
public class LymphocyteClient {
    private final WebClient webClient;

    public LymphocyteClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<LymphocyteDto> getLymphocyteIdAsync(Long lymphocyteId) {
        return webClient.get().uri("/" + lymphocyteId)
                .retrieve().bodyToMono(LymphocyteDto.class);
    }

    public void createLymphocyteAsync() {
        webClient.post().retrieve();
    }
}
