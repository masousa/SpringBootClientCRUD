package tech.ada.solucao.banco.cliente.resposta;

import lombok.Data;
import tech.ada.solucao.banco.cliente.requisicao.EnderecoRequisicao;

@Data
public class EnderecoResposta extends EnderecoRequisicao {

    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siaf;

}
