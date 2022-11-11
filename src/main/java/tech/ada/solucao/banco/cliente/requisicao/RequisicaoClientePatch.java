package tech.ada.solucao.banco.cliente.requisicao;

import lombok.Data;

@Data
public class RequisicaoClientePatch {
    private String nome;
    private EnderecoRequisicao enderecoRequisicao;
}
