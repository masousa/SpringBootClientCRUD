package tech.ada.solucao.banco.cliente.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class SemConteudoExcecao extends RuntimeException{
    public SemConteudoExcecao(){
        super();
    }
}
