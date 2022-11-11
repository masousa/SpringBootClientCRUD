package tech.ada.solucao.banco.cliente.cliente;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import tech.ada.solucao.banco.cliente.resposta.EnderecoResposta;

@Component
@Slf4j
public class ConsultaCEPCliente {

    public EnderecoResposta getCep(String cep){
        WebClient webClient = WebClient.create();
        return
                webClient.get().uri("https://viacep.com.br/ws/{cep}/json/",cep).retrieve()
                        .bodyToMono(EnderecoResposta.class).block();

    }
}
