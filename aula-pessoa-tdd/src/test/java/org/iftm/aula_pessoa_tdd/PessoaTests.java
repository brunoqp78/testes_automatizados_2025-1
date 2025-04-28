package org.iftm.aula_pessoa_tdd;

public class PessoaTests {
/**
* <p><b>Cenário:</b> Testa o construtor com um nome válido minúsculo, no meio dos limites</p>
* <p><b>Entrada:</b> nomeValido = "bruno" </p>
* <p><b>Saída esperada:</b> "BRUNO" </p>
*/

/**
* <p><b>Cenário:</b> Testa o construtor com um nome válido minúsculo, no limite inferior de 2 caracteres</p>
* <p><b>Entrada:</b> nomeValido = "Ed" </p>
* <p><b>Saída esperada:</b> "ED" </p>
*/

/**
* <p><b>Cenário:</b> Testa o construtor com um nome válido minúsculo, no limite superior de 100 caracteres</p>
* <p><b>Entrada:</b> nomeValido = Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456" </p>
* <p><b>Saída esperada:</b> BRUNO QUEIROZ 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456" </p>
*/

/**
* <p><b>Cenário:</b> Testa o construtor com um nome inválido minúsculo, acima do limite superior de 100 caracteres</p>
* <p><b>Entrada:</b> nomeValido = Bruno Queiroz 012345678901234567890123456789012345678901234567890123456789012345678901234567890123456" </p>
* <p><b>Saída esperada:</b> IllegalArgumentException </p>
* <p><b>Mensagem esperada:</b> "Nome inválido, precisa ter entre 2 e 200 caracteres." </p>
*/

/**
* <p><b>Cenário:</b> Testa o construtor com um nome inválido minúsculo, abaixo do limite inferior de 2 caracteres</p>
* <p><b>Entrada:</b> nomeValido = b </p>
* <p><b>Saída esperada:</b> IllegalArgumentException </p>
* <p><b>Mensagem esperada:</b> "Nome inválido, precisa ter entre 2 e 200 caracteres." </p>
*/

}
