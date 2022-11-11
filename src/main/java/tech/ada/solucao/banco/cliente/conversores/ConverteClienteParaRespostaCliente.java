package tech.ada.solucao.banco.cliente.conversores;

import tech.ada.solucao.banco.cliente.entidades.Cliente;
import tech.ada.solucao.banco.cliente.entidades.Endereco;
import tech.ada.solucao.banco.cliente.requisicao.EnderecoRequisicao;
import tech.ada.solucao.banco.cliente.resposta.RespostaCliente;

import java.util.Objects;

public class ConverteClienteParaRespostaCliente {

    public static RespostaCliente converte(Cliente cliente){
        RespostaCliente respostaCliente = new RespostaCliente();
        respostaCliente.setIdentificador(cliente.getIdentificador());
        respostaCliente.setNome(cliente.getNome());
        respostaCliente.setCpf(cliente.getCpf());
        if(!cliente.getEnderecoList().isEmpty()){
            Endereco endereco = cliente.getEnderecoList().iterator().next();
            EnderecoRequisicao enderecoRequisicao = new EnderecoRequisicao();
            enderecoRequisicao.setCep(endereco.getCep());
            enderecoRequisicao.setLogradouro(endereco.getLogradouro());
            enderecoRequisicao.setNumero(endereco.getNumero().intValue());
            respostaCliente.setEnderecoRequisicao(enderecoRequisicao);
        }


        return respostaCliente;
    }
}
