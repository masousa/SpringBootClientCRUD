package tech.ada.solucao.banco.cliente.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.solucao.banco.cliente.requisicao.RequisicaoCliente;
import tech.ada.solucao.banco.cliente.requisicao.RequisicaoClientePatch;
import tech.ada.solucao.banco.cliente.resposta.RespostaCliente;
import tech.ada.solucao.banco.cliente.servico.AlterarCliente;
import tech.ada.solucao.banco.cliente.servico.ConsultarClienteServico;
import tech.ada.solucao.banco.cliente.servico.IncluirClienteServico;
import tech.ada.solucao.banco.cliente.servico.ListarClienteServico;
import tech.ada.solucao.banco.cliente.servico.RemoverCliente;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/cliente")
@RequiredArgsConstructor
@Slf4j
public class ClienteController {


    private final IncluirClienteServico incluirClienteServico;
    private final ConsultarClienteServico consultarClienteServico;

    private final ListarClienteServico listarClienteServico;

    private final RemoverCliente removerCliente;

    private final AlterarCliente alterarCliente;

    // http://localhost:8080/v1/cliente
    @PostMapping(path = "", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public RespostaCliente criarCliente(@RequestBody RequisicaoCliente requisicaoCliente){
        log.info("Info {}", requisicaoCliente);
        return incluirClienteServico.executar(requisicaoCliente);
    }
    // http://localhost:8080/v1/cliente/<identificador>
    @GetMapping(path = "/{identificador}")
    public RespostaCliente consultarCliente (@PathVariable("identificador") String identificador){
        return consultarClienteServico.executar(identificador);
    }

    // http://localhost:8080/v1/cliente/<identificador>
    @DeleteMapping(path = "/{identificador}")
    public RespostaCliente removerCliente(@PathVariable("identificador") String identificador){
        return removerCliente.executar(identificador);
    }

    // http://localhost:8080/v1/cliente
    @GetMapping(path = "")
    public List<RespostaCliente> listarClientes(){
        return listarClienteServico.executar();
    }

    // http://localhost:8080/v1/cliente/<identificador>
    @PatchMapping(path = "/{identificador}")
    public RespostaCliente atualizarCliente(@RequestBody RequisicaoClientePatch clientePatch,
                                            @PathVariable("identificador") String identificador){
        return alterarCliente.executar(clientePatch, identificador);
    }

}
