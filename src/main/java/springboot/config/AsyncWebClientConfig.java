package springboot.config;


import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;
import springboot.neuron.NeuronProperties;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Configuration
public class AsyncWebClientConfig  {
    private final NeuronProperties neuronProperties;

    @Bean
    public WebClient webClientWithTimeout() {
        final var tcpClient = TcpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, neuronProperties.webClientTimeout())
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(neuronProperties.webClientTimeout(), TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(neuronProperties.webClientTimeout(), TimeUnit.MILLISECONDS));
                });

        return WebClient.builder()
                .baseUrl(neuronProperties.lymphocyteUrl())
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .build();
    }
}
