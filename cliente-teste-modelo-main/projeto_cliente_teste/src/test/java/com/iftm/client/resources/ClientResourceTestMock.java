package com.iftm.client.resources;

import java.time.Instant;
import java.util.ArrayList;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.iftm.client.dto.ClientDTO;
import com.iftm.client.entities.Client;
import com.iftm.client.services.ClientService;
import com.iftm.client.services.exceptions.ResourceNotFoundException;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientResourceTestMock {
    @Autowired
    private MockMvc mockMvc;

    //criar o mock/stub da service utilizada pela controller/resources
    @MockBean
    private ClientService service;

    /** Verificar se o Json retornado contém todos os clientes cadastrados, na paginação adequada.
     *  Entrada: quantidade de clientes = 12
     */
    @Test
    public void testarEndPointBuscarTodosClientes(){
        //arrange
        int quantidadeClientes = 3;

        //configurar mockbean
        //exemplo diferente do cenário real, lá há 12 clientes.
        ArrayList<ClientDTO> lista = new ArrayList<>();
        lista.add(new ClientDTO(new Client(7L, "Jose Saramago", "10239254871", 5000.0, Instant.parse("1996-12-23T07:00:00Z"), 0)));
        lista.add(new ClientDTO(new Client(4L, "Carolina Maria", "10419244771", 7500.0, Instant.parse("1996-12-23T07:00:00Z"), 0)));
        lista.add(new ClientDTO(new Client(8L, "Toni Morrison", "10219344681", 10000.0,Instant.parse("1940-02-23T07:00:00Z"), 0)));

        Page<ClientDTO> page = new PageImpl<>(lista);        
        Mockito.when(service.findAllPaged(Mockito.any())).thenReturn(page);

        //act
        ResultActions resultado = assertDoesNotThrow(()->mockMvc.perform(get("/clients/").accept(MediaType.APPLICATION_JSON)));
    
        //assert
        assertDoesNotThrow(()->
            resultado
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").exists())
            .andExpect(jsonPath("$.content").isArray())
            .andExpect(jsonPath("$.content[?(@.id == '%s')]", 4L).exists())
            .andExpect(jsonPath("$.content[?(@.id == '%s')]", 7L).exists())
            .andExpect(jsonPath("$.totalElements").exists())
            .andExpect(jsonPath("$.totalElements").value(quantidadeClientes))
            .andExpect(jsonPath("$.content[0].id", is(7)))
            .andExpect(jsonPath("$.content.*", isA(ArrayList.class)))
            .andExpect(jsonPath("$.content.*", hasSize(quantidadeClientes)))
            .andExpect(jsonPath("$.content[*].id", containsInAnyOrder(4,7,8)))
            .andExpect(jsonPath("$.content[*].id", hasItems(4,7,8)))
            );
    }

    @Test
    public void testarBuscaPorIdExistente(){
        long idExistente = 1L;
        // configurar o mock
        ClientDTO clienteExistente = new ClientDTO(new Client(1L, "Conceição Evaristo", "10619244881", 1500.0,
            Instant.parse("2020-07-13T20:50:00Z"), 2));
        Mockito.when(service.findById(idExistente)).thenReturn(clienteExistente);

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
        Mockito.when(service.findById(idNaoExistente)).thenThrow(new ResourceNotFoundException("Entity not found"));
        
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

