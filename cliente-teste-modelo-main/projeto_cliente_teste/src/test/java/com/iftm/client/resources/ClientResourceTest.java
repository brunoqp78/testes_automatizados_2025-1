package com.iftm.client.resources;

import java.util.ArrayList;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientResourceTest {
    @Autowired
    private MockMvc mockMvc;

    /** Verificar se o Json retornado contém todos os clientes cadastrados, na paginação adequada.
     *  Entrada: quantidade de clientes = 12
     * @throws Exception 
     */
    @Test
    public void testarEndPointBuscarTodosClientes(){
        //arrange
        int quantidadeClientes = 12;
        int quantidadeClientesPagina = 12;

        //act
        ResultActions resultado = assertDoesNotThrow(()->mockMvc.perform(get("/clients/").accept(MediaType.APPLICATION_JSON)));
    
        //assert
        assertDoesNotThrow(()->
            resultado
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").exists())
            .andExpect(jsonPath("$.content").isArray())
            .andExpect(jsonPath("$.content[?(@.id == '%s')]", 1L).exists())
            .andExpect(jsonPath("$.content[?(@.id == '%s')]", 1L).exists())
            .andExpect(jsonPath("$.totalElements").exists())
            .andExpect(jsonPath("$.totalElements").value(quantidadeClientes))
            .andExpect(jsonPath("$.content[0].id", is(4)))
            .andExpect(jsonPath("$.content.*", isA(ArrayList.class)))
            .andExpect(jsonPath("$.content.*", hasSize(quantidadeClientes)))
            .andExpect(jsonPath("$.content[*].id", containsInAnyOrder(1,2,3,4,5,6,7,8,9,10,11,12)))
            .andExpect(jsonPath("$.content[*].id", hasItems(4,7,8)))
            );
    }

    @Test
    public void testarBuscaPorIdExistente(){
        long idExistente = 1L;
        //act
        ResultActions resultado = assertDoesNotThrow(()->
            mockMvc.perform(get("/clients/{id}", idExistente).accept(MediaType.APPLICATION_JSON)));
        
        //assert
        assertDoesNotThrow(()->
            resultado
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").exists())
            .andExpect(jsonPath("$.name").value("Conceição Evaristo"))
        );
    }

    @Test
    public void testarBuscaPorIdNaoExistente(){
        long idNaoExistente = 111L;
        //act
        ResultActions resultado = assertDoesNotThrow(()->
            mockMvc.perform(get("/clients/{id}", idNaoExistente).accept(MediaType.APPLICATION_JSON)));
        
        //assert
        assertDoesNotThrow(()->
            resultado
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.error").exists())
            .andExpect(jsonPath("$.error").value("Resource not found"))
            .andExpect(jsonPath("$.message").exists())
            .andExpect(jsonPath("$.message").value("Entity not found"))
        );
    }    
}

