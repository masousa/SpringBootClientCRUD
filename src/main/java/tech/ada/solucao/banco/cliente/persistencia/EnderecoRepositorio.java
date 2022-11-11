package tech.ada.solucao.banco.cliente.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.solucao.banco.cliente.entidades.Cliente;
import tech.ada.solucao.banco.cliente.entidades.Endereco;

@Repository
public interface EnderecoRepositorio extends JpaRepository<Endereco,Long> {
    Long deleteByCliente(Cliente cliente);

    Endereco findByCliente(Cliente cliente);
}
