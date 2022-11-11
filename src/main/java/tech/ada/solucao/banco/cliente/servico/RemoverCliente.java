package tech.ada.solucao.banco.cliente.servico;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.ada.solucao.banco.cliente.conversores.ConverteClienteParaRespostaCliente;
import tech.ada.solucao.banco.cliente.entidades.Cliente;
import tech.ada.solucao.banco.cliente.persistencia.ClienteRepositorio;
import tech.ada.solucao.banco.cliente.persistencia.EnderecoRepositorio;
import tech.ada.solucao.banco.cliente.resposta.RespostaCliente;

@Service
@RequiredArgsConstructor
public class RemoverCliente {

    private final ClienteRepositorio clienteRepositorio;
    // private final ConsultarClienteServico consultarClienteServico;
    private final EnderecoRepositorio enderecoRepositorio;

    private final PesquisaCliente pesquisaCliente;
    @Transactional
    public RespostaCliente executar(String identificador){
        /*RespostaCliente respostaCliente = consultarClienteServico.executar(identificador);
        clienteRepositorio.deleteById(respostaCliente.getCpf());*/
        final Cliente cliente = pesquisaCliente.executar(identificador);
        enderecoRepositorio.deleteByCliente(cliente);
        clienteRepositorio.delete(cliente);
        return ConverteClienteParaRespostaCliente.converte(cliente);
    }
}
