package tech.ada.solucao.banco.cliente.entidades;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
@Data
public class Endereco {

    /***
     * CREATE TABLE endereco (
     *  id int IDENTITY NOT NULL PRIMARY KEY,
     *  numero int NOT NULL,
     *  logradouro varchar[200] NOT NULL,
     *  cpf_cliente varchar[11] NOT NULL,
     *  cep varchar[8] NOT NULL,
     *  Foreign key (cpf_cliente) references clientes(cpf)
     *
     * );
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numero;

    private String logradouro;

    @ManyToOne
    @JoinColumn(name = "cpf_cliente")
    private Cliente cliente;

    private String cep;


}
