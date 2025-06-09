package com.iftm.client.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.iftm.client.repositories.ClientRepository;
import com.iftm.client.services.exceptions.ResourceNotFoundException;

@ExtendWith(SpringExtension.class)
public class ClientServiceUnitTest {

    @InjectMocks
    private ClientService servico;

    @Mock
    private ClientRepository repositorio;

    /** Testar o metodo delete da classe service, verificando se o método não retorna nada e exclui o registro quando o id existe.
     * idExistente = 1;
     * resultado esperado = não há retorno de dados ou exceptions.
     */
    @Test
    public void testarApagarClienteQuandoIDExisteNaoRetornandoNada(){
        //assign
        Long idExistente = 1L;
        Mockito.doNothing().when(repositorio).deleteById(idExistente);
        //act e assert
        assertDoesNotThrow(()->{servico.delete(idExistente);});
        Mockito.verify(repositorio, Mockito.times(1)).deleteById(idExistente);
    }

    /** Testar o metodo delete da classe service, verificando se o método retorna exception quando o id não existe.
     * idExistente = 100;
     * resultado esperado = ResourceNotFoundException
     */
    @Test
    public void testarApagarClienteQuandoIDNaoExisteRetornaException(){
        //assign
        Long idNaoExistente = 100L;        
        Mockito.doThrow(EmptyResultDataAccessException.class).when(repositorio).deleteById(idNaoExistente);

        //act e assert
        ResourceNotFoundException e = assertThrows(ResourceNotFoundException.class, ()->{servico.delete(idNaoExistente);});
        assertEquals("Id not found " + idNaoExistente, e.getMessage());
        Mockito.verify(repositorio, Mockito.times(1)).deleteById(idNaoExistente);
    }    
}
