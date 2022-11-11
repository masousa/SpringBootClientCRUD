package tech.ada.solucao.banco.cliente.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.solucao.banco.cliente.entidades.Cliente;
import tech.ada.solucao.banco.cliente.excecao.SemConteudoExcecao;
import tech.ada.solucao.banco.cliente.persistencia.ClienteRepositorio;

@Service
public class PesquisaCliente {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Cliente executar(String identificador){
        return  clienteRepositorio
                .findIdentificador(identificador).orElseThrow(SemConteudoExcecao::new);
    }
}
