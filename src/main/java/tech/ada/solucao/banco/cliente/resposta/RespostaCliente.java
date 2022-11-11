package tech.ada.solucao.banco.cliente.resposta;

import lombok.Data;
import tech.ada.solucao.banco.cliente.requisicao.RequisicaoCliente;

@Data
public class RespostaCliente extends RequisicaoCliente {
    private String identificador;
}
