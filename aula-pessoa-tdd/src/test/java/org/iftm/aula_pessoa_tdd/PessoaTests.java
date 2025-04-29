package org.iftm.aula_pessoa_tdd;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaTests {
    private Pessoa pessoa;

    @BeforeEach
    public void instanciarObjetos() {
        pessoa = new Pessoa();
    }

    // etapa 1 : Criar cenários de teste

    /**
     * <p><b>Cenário:</b> Testa o construtor com um nome válido minúsculo, no meio dos limites</p>
     * <p><b>Entrada:</b> entradaValida = "bruno" </p>
     * <p><b>Saída esperada:</b> "BRUNO" </p>
     */
    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarConstrutorComNomeMinusculoValidoForaLimite() {
        // Arrange
        String entradaValida = "bruno";
        String resultadoEsperado = "BRUNO";

        // act
        pessoa = new Pessoa(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * <p><b>Cenário:</b> Testa o construtor com um nome válido maiúsculo, no meio dos limites</p>
     * <p><b>Entrada:</b> entradaValida = "BRUNO" </p>
     * <p><b>Saída esperada:</b> "BRUNO" </p>
     */
    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarConstrutorComNomeMaiusculoValidoForaLimite() {
        // Arrange
        String entradaValida = "BRUNO";
        String resultadoEsperado = "BRUNO";

        // act
        pessoa = new Pessoa(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * <p><b>Cenário:</b> Testa o construtor com um nome válido minúsculo, no limite inferior de 2 caracteres</p>
     * <p><b>Entrada:</b> entradaValida = "Ed" </p>
     * <p><b>Saída esperada:</b> "ED" </p>
     */
    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarConstrutorComNomeValidoNoLimiteInferior() {
        // Arrange
        String entradaValida = "Ed";
        String resultadoEsperado = "ED";

        // act
        pessoa = new Pessoa(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * <p><b>Cenário:</b> Testa o construtor com um nome válido minúsculo, no limite superior de 200 caracteres</p>
     * <p><b>Entrada:</b> entradaValida = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456" </p>
     * <p><b>Saída esperada:</b> "BRUNO QUEIROZ 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456" </p>
     */    
    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarConstrutorComNomeValidoNoLimiteSuperior() {
        // Arrange
        String entradaValida = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
        String resultadoEsperado = "BRUNO QUEIROZ 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";

        // act
        pessoa = new Pessoa(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * <p><b>Cenário:</b> Testa o construtor com um nome inválido, abaixo do limite inferior de 1 caractere</p>
     * <p><b>Entrada:</b> entradaValida = "a" </p>
     * <p><b>Saída esperada:</b> "IllegalArgumentException" </p>
     * <p><b>Mensagem esperada:</b> "Nome inválido, precisa ter entre 2 e 200 caracteres." </p>
     */    
    @Test    
    public void testarConstrutorComNomeiNValidoAbaixoLimiteInferior() {
        // Arrange
        String entradaInvalida = "a";
        String mensagemEsperada = "Nome inválido, precisa ter entre 2 e 200 caracteres.";

        //act and assign
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa = new Pessoa(entradaInvalida);
                });
        assertEquals(mensagemEsperada, e.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa o construtor com um nome inválido, acima do limite superior de 200 caracteres</p>
     * <p><b>Entrada:</b> entradaValida = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456453" </p>
     * <p><b>Saída esperada:</b> "IllegalArgumentException" </p>
     * <p><b>Mensagem esperada:</b> "Nome inválido, precisa ter entre 2 e 200 caracteres." </p>
     */        
    @Test    
    public void testarConstrutorComNomeiNValidoAcimaLimiteSuperior() {
        // Arrange
        String entradaInvalida = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456453";
        String mensagemEsperada = "Nome inválido, precisa ter entre 2 e 200 caracteres.";

        //act and assign
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa = new Pessoa(entradaInvalida);
                });
        assertEquals(mensagemEsperada, e.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa modificar um nome válido minúsculo, no meio dos limites</p>
     * <p><b>Entrada:</b> entradaValida = "bruno" </p>
     * <p><b>Saída esperada:</b> "BRUNO" </p>
     */
    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarModificarNomeMinusculoValidoForaLimite() {
        // Arrange
        String entradaValida = "bruno";
        String resultadoEsperado = "BRUNO";

        // act
        pessoa.setNome(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * <p><b>Cenário:</b> Testa modificar um nome válido maiúsculo, no meio dos limites</p>
     * <p><b>Entrada:</b> entradaValida = "BRUNO" </p>
     * <p><b>Saída esperada:</b> "BRUNO" </p>
     */
    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarModificarNomeMaiusculoValidoForaLimite() {
        // Arrange
        String entradaValida = "BRUNO";
        String resultadoEsperado = "BRUNO";

        // act
        pessoa.setNome(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * <p><b>Cenário:</b> Testa modificar um nome válido minúsculo, no limite inferior de 2 caracteres</p>
     * <p><b>Entrada:</b> entradaValida = "Ed" </p>
     * <p><b>Saída esperada:</b> "ED" </p>
     */
    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarModificarNomeValidoNoLimiteInferior() {
        // Arrange
        String entradaValida = "Ed";
        String resultadoEsperado = "ED";

        // act
        pessoa.setNome(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * <p><b>Cenário:</b> Testa modificar um nome válido minúsculo, no limite superior de 200 caracteres</p>
     * <p><b>Entrada:</b> entradaValida = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456" </p>
     * <p><b>Saída esperada:</b> "BRUNO QUEIROZ 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456" </p>
     */    
    @Test
    @DisplayName("Caso de teste que verifica o nome válido e que não esteja nos limites de 2 e 200 caracteres.")
    public void testarModificarNomeValidoNoLimiteSuperior() {
        // Arrange
        String entradaValida = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";
        String resultadoEsperado = "BRUNO QUEIROZ 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456";

        // act
        pessoa.setNome(entradaValida);
        String resultadoObtido = pessoa.getNome();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * <p><b>Cenário:</b> Testa modificar um nome inválido, abaixo do limite inferior de 1 caractere</p>
     * <p><b>Entrada:</b> entradaValida = "a" </p>
     * <p><b>Saída esperada:</b> "IllegalArgumentException" </p>
     * <p><b>Mensagem esperada:</b> "Nome inválido, precisa ter entre 2 e 200 caracteres." </p>
     */    
    @Test    
    public void testarModificarNomeiNValidoAbaixoLimiteInferior() {
        // Arrange
        String entradaInvalida = "a";
        String mensagemEsperada = "Nome inválido, precisa ter entre 2 e 200 caracteres.";

        //act and assign
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.setNome(entradaInvalida);
                });
        assertEquals(mensagemEsperada, e.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa modificar um nome inválido, acima do limite superior de 200 caracteres</p>
     * <p><b>Entrada:</b> entradaValida = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456453" </p>
     * <p><b>Saída esperada:</b> "IllegalArgumentException" </p>
     * <p><b>Mensagem esperada:</b> "Nome inválido, precisa ter entre 2 e 200 caracteres." </p>
     */        
    @Test    
    public void testarModificarNomeiNValidoAcimaLimiteSuperior() {
        // Arrange
        String entradaInvalida = "Bruno Queiroz 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456453";
        String mensagemEsperada = "Nome inválido, precisa ter entre 2 e 200 caracteres.";

        //act and assign
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.setNome(entradaInvalida);
                });
        assertEquals(mensagemEsperada, e.getMessage());
    }

    /**
     * <p><b>Cenário:</b> Testa modificar o salário válido, no limite inferior de R$ 1518</p>
     * <p><b>Entrada:</b> entradaValida = 1518 </p>
     * <p><b>Saída esperada:</b> 1518 </p>
     */
    @Test
    @DisplayName("Caso de teste que verifica o salário válido e que tenha o valor do limite inferior, ou seja, 1518.")
    public void testarModificarSalarioNoLimiteInferior() {
        // Arrange
        double entradaValida = 1518.00;
        double resultadoEsperado = 1518.00;

        // act
        pessoa.setSalario(entradaValida);
        double resultadoObtido = pessoa.getSalario();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * <p><b>Cenário:</b> Testa modificar o salário válido, no limite superior de R$ 1000000</p>
     * <p><b>Entrada:</b> entradaValida = 1000000 </p>
     * <p><b>Saída esperada:</b> 1000000 </p>
     */
    @Test
    @DisplayName("Caso de teste que verifica o salário válido e que tenha o valor do limite inferior, ou seja, 1000000.")
    public void testarModificarSalarioNoLimiteSuperior() {
        // Arrange
        double entradaValida = 1000000.00;
        double resultadoEsperado = 1000000.00;

        // act
        pessoa.setSalario(entradaValida);
        double resultadoObtido = pessoa.getSalario();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * <p><b>Cenário:</b> Testa modificar o salário inválido, acima do limite superior de 1000000.00</p>
     * <p><b>Entrada:</b> entradaValida = 1000001.00 </p>
     * <p><b>Saída esperada:</b> "IllegalArgumentException" </p>
     * <p><b>Mensagem esperada:</b> "Salário inválido, precisa ter um valor entre 1518.00 e 1000000.00" </p>
     */    
    @Test    
    @DisplayName("Caso de teste que verifica o salário inválido e que tenha o valor acima do limite superior, ou seja, >1000000.")
    public void testarModificarSalarioiNValidoAcimaLimiteSuperior() {
        // Arrange
        double entradaInvalida = 1000001.00;
        String mensagemEsperada = "Salário inválido, precisa ter um valor entre 1518.00 e 1000000.00";

        //act and assign
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.setSalario(entradaInvalida);
                });
        assertEquals(mensagemEsperada, e.getMessage());

    }

    /**
     * <p><b>Cenário:</b> Testa modificar o salário inválido, abaixo do limite inferior de 1518</p>
     * <p><b>Entrada:</b> entradaValida = 1517 </p>
     * <p><b>Saída esperada:</b> "IllegalArgumentException" </p>
     * <p><b>Mensagem esperada:</b> "Salário inválido, precisa ter um valor entre 1518.00 e 1000000.00" </p>
     */    
    @Test    
    @DisplayName("Caso de teste que verifica o salário inválido e que tenha o valor abaixo do limite inferior, ou seja, <1518.")
    public void testarModificarSalarioiNValidoAbaixoLimiteSuperior() {
        // Arrange
        double entradaInvalida = 1517.00;
        String mensagemEsperada = "Salário inválido, precisa ter um valor entre 1518.00 e 1000000.00";

        //act and assign
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.setSalario(entradaInvalida);
                });
        assertEquals(mensagemEsperada, e.getMessage());


    }

    /** 
     * <p><b>Cenário:</b> Testa o reajuse do salário, no limite inferior de 1%</p>
     * <p><b>Entrada:</b> entradaValida = 1.0 , salarioInicia = 2000.00</p>
     * <p><b>Saída esperada:</b> 2020.00 </p>
     */
    @Test
    @DisplayName("Caso de teste que verifica se o reajuste é valido, com o valor limite inferior 1.")
    public void testarReajusteSalarioValidoNoLimiteInferior() {
        // Arrange
        double entradaValida = 1.00;
        double salarioInicial = 2000.00;
        double resultadoEsperado = 2020.00;

        // act
        pessoa.setSalario(salarioInicial);
        pessoa.reajustarSalario(entradaValida);
        double resultadoObtido = pessoa.getSalario();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    /** 
     * <p><b>Cenário:</b> Testa o reajuse do salário, no limite superior de 100%</p>
     * <p><b>Entrada:</b> entradaValida = 100.00 , salarioInicia = 2000.00</p>
     * <p><b>Saída esperada:</b> 4000.00 </p>
     */
    @Test
    @DisplayName("Caso de teste que verifica se o reajuste é valido, com o valor limite superior 100.")
    public void testarReajusteSalarioValidoNoLimiteSuperior() {
        // Arrange
        double entradaValida = 100.00;
        double salarioInicial = 2000.00;
        double resultadoEsperado = 4000.00;

        // act
        pessoa.setSalario(salarioInicial);
        pessoa.reajustarSalario(entradaValida);
        double resultadoObtido = pessoa.getSalario();

        // assign
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * <p><b>Cenário:</b> Testa reajuste inválido do salário, abaixo do limite inferior de 1%</p>
     * <p><b>Entrada:</b> entradaInvalida = 0.0, salarioInicial = 2000.00 </p>
     * <p><b>Saída esperada:</b> "IllegalArgumentException" </p>
     * <p><b>Mensagem esperada:</b> "Porcentagem de reajuste inválida, valores válidos entre 1 e 100." </p>
     */    
    @Test    
    @DisplayName("Caso de teste que verifica um reajuste inválido que tenha o valor abaixo do limite inferior, ou seja, <1.")
    public void testarReajusteInvalidoSalarioAbaixoLimiteInferior() {
        // Arrange
        double entradaInvalida = 0;
        double salarioInicial = 2000.00;
        String mensagemEsperada = "Porcentagem de reajuste inválida, valores válidos entre 1 e 100.";

        //act and assign
        assertDoesNotThrow(() -> {
            pessoa.setSalario(salarioInicial);
        });
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.reajustarSalario(entradaInvalida);
                });
        assertEquals(mensagemEsperada, e.getMessage());

    }

    /**
     * <p><b>Cenário:</b> Testa reajuste inválido do salário, acima do limite superior de 100%</p>
     * <p><b>Entrada:</b> entradaInvalida = 101.0, salarioInicial = 2000.00 </p>
     * <p><b>Saída esperada:</b> "IllegalArgumentException" </p>
     * <p><b>Mensagem esperada:</b> "Porcentagem de reajuste inválida, valores válidos entre 1 e 100." </p>
     */    
    @Test    
    @DisplayName("Caso de teste que verifica um reajuste inválido que tenha o valor acima do limite superior, ou seja, >100.")
    public void testarReajusteInvalidoSalarioAcimaLimiteSuperior() {
        // Arrange
        double entradaInvalida = 101;
        double salarioInicial = 2000.00;
        String mensagemEsperada = "Porcentagem de reajuste inválida, valores válidos entre 1 e 100.";

        //act and assign
        assertDoesNotThrow(() -> {
            pessoa.setSalario(salarioInicial);
        });
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.reajustarSalario(entradaInvalida);
                });
        assertEquals(mensagemEsperada, e.getMessage());

    }

    /**
     * <p><b>Cenário:</b> Testa reajuste do salário, que torna ele superior ao limite de R$ 1000000.00. Necessário 3 reajustes de 100
     * <p><b>Entrada:</b> reajuste = 100.0, salarioInicial = 500001.00 </p>
     * <p><b>Saída esperada:</b> "IllegalArgumentException" </p>
     * <p><b>Mensagem esperada:</b> "Reajuste ultrapassa limite de salário de R$ 1000000.00." </p>
     */    
    @Test    
    @DisplayName("Caso de teste que verifica o salário inválido após vários reajustes.")
    public void testarReajusteInvalidoSalarioSuperandoLimiteSuperiorDoSalario() {
        // Arrange
        double reajuste = 100;
        double salarioInicial = 500001.00;
        String mensagemEsperada = "Reajuste ultrapassa limite de salário de R$ 1000000.00.";

        //act and assign
        assertDoesNotThrow(() -> {
            pessoa.setSalario(salarioInicial);
        });
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    pessoa.reajustarSalario(reajuste);
                });
        assertEquals(mensagemEsperada, e.getMessage());

    }

}
