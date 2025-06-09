package com.iftm.client.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.iftm.client.services.exceptions.ResourceNotFoundException;

@SpringBootTest
public class ClientServiceIntegrationTest {

    @Autowired
    private ClientService servico;

    /** Testar o metodo delete da classe service, verificando se o método não retorna nada e exclui o registro quando o id existe.
     * idExistente = 1;
     * resultado esperado = não há retorno de dados ou exceptions.
     */
    @Test
    public void testarApagarClienteQuandoIDExisteNaoRetornandoNada(){
        //assign
        Long idExistente = 1L;
        //act e assert
        assertDoesNotThrow(()->{servico.delete(idExistente);});
    }

    /** Testar o metodo delete da classe service, verificando se o método retorna exception quando o id não existe.
     * idExistente = 100;
     * resultado esperado = ResourceNotFoundException
     */
    @Test
    public void testarApagarClienteQuandoIDNaoExisteRetornaException(){
        //assign
        Long idNaoExistente = 100L;        

        //act e assert
        ResourceNotFoundException e = assertThrows(ResourceNotFoundException.class, ()->{servico.delete(idNaoExistente);});
        assertEquals("Id not found " + idNaoExistente, e.getMessage());
    }    
}
