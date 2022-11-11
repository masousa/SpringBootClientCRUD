package tech.ada.solucao.banco.cliente.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.solucao.banco.cliente.conversores.ConverteClienteParaRespostaCliente;
import tech.ada.solucao.banco.cliente.entidades.Cliente;
import tech.ada.solucao.banco.cliente.persistencia.ClienteRepositorio;
import tech.ada.solucao.banco.cliente.resposta.RespostaCliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ListarClienteServico {

    private final ClienteRepositorio clienteRepositorio;
    public List<RespostaCliente> executar() {

        /*
        List<RespostaCliente> respostaClienteList = new ArrayList<>();
        for(Cliente cliente: clienteRepositorio.findAll()){
            respostaClienteList.add(ConverteClienteParaRespostaCliente.converte(cliente));
        }
        return respostaClienteList;
        */

        return clienteRepositorio.findAll().stream()
                .map(ConverteClienteParaRespostaCliente::converte).collect(Collectors.toList());

    }
}
