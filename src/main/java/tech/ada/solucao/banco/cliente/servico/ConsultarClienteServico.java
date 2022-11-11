package tech.ada.solucao.banco.cliente.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.solucao.banco.cliente.cliente.ConsultaCEPCliente;
import tech.ada.solucao.banco.cliente.conversores.ConverteClienteParaRespostaCliente;
import tech.ada.solucao.banco.cliente.entidades.Cliente;
import tech.ada.solucao.banco.cliente.entidades.Endereco;
import tech.ada.solucao.banco.cliente.excecao.SemConteudoExcecao;
import tech.ada.solucao.banco.cliente.persistencia.ClienteRepositorio;
import tech.ada.solucao.banco.cliente.persistencia.EnderecoRepositorio;
import tech.ada.solucao.banco.cliente.resposta.EnderecoResposta;
import tech.ada.solucao.banco.cliente.resposta.RespostaCliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultarClienteServico {

    @Autowired
    private PesquisaCliente pesquisaCliente;
    @Autowired
    private EnderecoRepositorio enderecoRepositorio;
    @Autowired
    private ConsultaCEPCliente consultaCEPCliente;
    public RespostaCliente executar(String identificador) {
        Cliente cliente = pesquisaCliente.executar(identificador);
        //Endereco endereco = enderecoRepositorio.findByCliente(cliente);
        //cliente.setEnderecoList(List.of(endereco));
        final Endereco enderecoBanco = cliente.getEnderecoList().iterator().next();
        EnderecoResposta enderecoResposta =  consultaCEPCliente
                   .getCep(enderecoBanco.getCep());
        enderecoResposta.setNumero(enderecoBanco.getNumero().intValue());
        final RespostaCliente respostaCliente = ConverteClienteParaRespostaCliente.converte(cliente);
        respostaCliente.setEnderecoRequisicao(enderecoResposta);
        return respostaCliente;

    }
}
