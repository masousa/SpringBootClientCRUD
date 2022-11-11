package tech.ada.solucao.banco.cliente.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.solucao.banco.cliente.conversores.ConverteClienteParaRespostaCliente;
import tech.ada.solucao.banco.cliente.entidades.Cliente;
import tech.ada.solucao.banco.cliente.persistencia.ClienteRepositorio;
import tech.ada.solucao.banco.cliente.requisicao.RequisicaoClientePatch;
import tech.ada.solucao.banco.cliente.resposta.RespostaCliente;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AlterarCliente {

    private final ClienteRepositorio clienteRepositorio;
    private final PesquisaCliente pesquisaCliente;

    public RespostaCliente executar(RequisicaoClientePatch clientePatch, String identificador){


        Cliente cliente = pesquisaCliente.executar(identificador);
        if(Objects.nonNull(cliente.getNome())){
            cliente.setNome(clientePatch.getNome());
        }


        clienteRepositorio.save(cliente);

        return ConverteClienteParaRespostaCliente.converte(cliente);
    }
}
