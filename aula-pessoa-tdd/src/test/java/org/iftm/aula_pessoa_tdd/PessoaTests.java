package org.iftm.aula_pessoa_tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PessoaTests {
/**
* <p><b>Cenário:</b> Testa o construtor com um nome válido minúsculo, no meio dos limites</p>
* <p><b>Entrada:</b> nomeValido = "bruno" </p>
* <p><b>Saída esperada:</b> "BRUNO" </p>
*/
@Test
public void testarConstrutorComNomeValidoDentroDosLimites(){
    //assign
    String nomeValido = "bruno";
    String saidaEsperada = "BRUNO";
    //act
    Pessoa pessoa = new Pessoa(nomeValido);    
    String saidaObtida = pessoa.getNome();
    //assert
    assertEquals(saidaEsperada, saidaObtida);
}

/**
* <p><b>Cenário:</b> Testa o construtor com um nome válido minúsculo, no limite inferior de 2 caracteres</p>
* <p><b>Entrada:</b> nomeValido = "Ed" </p>
* <p><b>Saída esperada:</b> "ED" </p>
*/
@Test
public void testarConstrutorComNomeValidoNoLimiteInferior(){
    //assign
    String nomeValido = "Ed";
    String saidaEsperada = "ED";
    //act
    Pessoa pessoa = new Pessoa(nomeValido);    
    String saidaObtida = pessoa.getNome();
    //assert
    assertEquals(saidaEsperada, saidaObtida);
}

/**
* <p><b>Cenário:</b> Testa o construtor com um nome válido minúsculo, no limite superior de 100 caracteres</p>
* <p><b>Entrada:</b> nomeValido = Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456 </p>
* <p><b>Saída esperada:</b> BRUNO QUEIROZ 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456 </p>
*/
@Test
public void testarConstrutorComNomeValidoNoLimiteSuperior(){
    //assign
    String nomeValido = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
    String saidaEsperada = "BRUNO QUEIROZ 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
    //act
    Pessoa pessoa = new Pessoa(nomeValido);    
    String saidaObtida = pessoa.getNome();
    //assert
    assertEquals(saidaEsperada, saidaObtida);
}

/**
* <p><b>Cenário:</b> Testa o construtor com um nome inválido minúsculo, acima do limite superior de 100 caracteres</p>
* <p><b>Entrada:</b> nomeValido = Bruno Queiroz 012345678901234567890123456789012345678901234567890123456789012345678901234567890123456 </p>
* <p><b>Saída esperada:</b> IllegalArgumentException </p>
* <p><b>Mensagem esperada:</b> "Nome inválido, precisa ter entre 2 e 200 caracteres." </p>
*/
@Test
public void testarConstrutorComNomeInvalidoAcimaLimiteSuperior(){
    //assign
    String nomeInvalido = "Bruno Queiroz 012345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
    String mensagemEsperada = "Nome inválido, precisa ter entre 2 e 200 caracteres.";
    //act
    String mensagemObtida = assertThrows(IllegalArgumentException.class, ()->{new Pessoa(nomeInvalido);}).getMessage();
    //assert
    assertEquals(mensagemEsperada, mensagemObtida);
}
/**
* <p><b>Cenário:</b> Testa o construtor com um nome inválido minúsculo, abaixo do limite inferior de 2 caracteres</p>
* <p><b>Entrada:</b> nomeValido = b </p>
* <p><b>Saída esperada:</b> IllegalArgumentException </p>
* <p><b>Mensagem esperada:</b> "Nome inválido, precisa ter entre 2 e 200 caracteres." </p>
*/
@Test
public void testarConstrutorComNomeInvalidoAbaixoLimiteInferior(){
    //assign
    String nomeInvalido = "b";
    String mensagemEsperada = "Nome inválido, precisa ter entre 2 e 200 caracteres.";
    //act
    String mensagemObtida = assertThrows(IllegalArgumentException.class, ()->{new Pessoa(nomeInvalido);}).getMessage();
    //assert
    assertEquals(mensagemEsperada, mensagemObtida);
}
}
