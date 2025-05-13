package org.iftm.gerenciadorveterinarios.repositories;

import java.util.Optional;

import org.iftm.gerenciadorveterinarios.entities.Veterinario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// cenário de teste inclui o registros presentes no arquivo resources/import.sql
@DataJpaTest
public class VeterinarioRepositoryTest {

    @Autowired
    private VeterinarioRepository repositorio;

    /** 
     * <p><b>Cenário:</b> Testa a busca de um veterinário por ID existente no BD.</p>
     * <p><b>Entrada:</b> idExistente: 1</p>
     * <p><b>Saída esperada:</b> objeto retornado com nome = Conceição Evaristo e email = conceicao@gmail.com </p>
     */
    @Test
    public void testarBuscaVeterinarioPorIDExistenteRetornaObjetoCorreto()
    {
        //assign
        Integer idExistente = 1;
        String nomeEsperado = "Conceição Evaristo";
        String emailEsperado = "conceicao@gmail.com";
        //act
        Veterinario veterinarioObtido = repositorio.getById(idExistente);
        //assert
        assertNotNull(veterinarioObtido);
        assertEquals(nomeEsperado, veterinarioObtido.getNome());
        assertEquals(emailEsperado, veterinarioObtido.getEmail());
    }

    @Test
    public void testarBuscaVeterinarioPorIDExistenteRetornaObjetoEncapsuladoCorreto()
    {
        //assign
        Integer idExistente = 1;
        String nomeEsperado = "Conceição Evaristo";
        String emailEsperado = "conceicao@gmail.com";
        //act
        Optional<Veterinario> veterinarioObtido = repositorio.findById(idExistente);
        //assert
        assertTrue(veterinarioObtido.isPresent());
        assertEquals(nomeEsperado, veterinarioObtido.get().getNome());
        assertEquals(emailEsperado, veterinarioObtido.get().getEmail());
    }
}
