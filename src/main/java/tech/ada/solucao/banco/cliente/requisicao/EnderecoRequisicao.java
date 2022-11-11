package tech.ada.solucao.banco.cliente.requisicao;

import lombok.Data;

@Data
public class EnderecoRequisicao {
    private Integer numero;
    private String logradouro;
    private String cep;
}
