package tech.ada.solucao.banco.cliente.entidades;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    /***
     * CREATE TABLE clientes (
     *  cpf varchar[11] NOT NULL PRIMARY KEY,
     *  nome_cliente varchar[200] NOT NULL,
     *  identificador varchar[200] not null
     * );
     *
     */
    @Id
    private String cpf;
    @Column(name = "nome_cliente")
    private String nome;
    private String identificador;
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecoList;


}
