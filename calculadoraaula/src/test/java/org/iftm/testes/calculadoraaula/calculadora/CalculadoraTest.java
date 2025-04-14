package org.iftm.testes.calculadoraaula.calculadora;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    private static Calculadora calculadora;

    /**
     * Configurar a execução do teste uma única vez
     */
    @BeforeAll
    public static void configurarTestesGeral(){
        System.out.println("Iniciar Teste");
        calculadora = new Calculadora();
    }

    @AfterAll
    public static void finalizarTestesGeral(){
        System.out.println("Fim do Teste");
    }

    /**
     * Configurar cada execução de teste.
     * Executa ao inicio de cada método de teste com notação @Test
     */
    @BeforeEach
    public void configurarTestes(){
        System.out.println("Começou");
    }


    /**
     * Finalizar a execução de cada teste.
     * Executa ao fim da execução de cada método de teste com notação @Test
     */
    @AfterEach
    public void finalizarTeste(){
        System.out.println("Fechou!!!!!!!!!!!!!!!!");
    }

    /**
     * Testa a soma de dois números inteiros positivos
     * <p><b>Cenário : </b> Somar dois números positivos</p>
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 2</p>
     * <p>- numero2 = 3</p>
     * <p><b>Saída : </b>5 </p>
     */
    @Test
    public void testarSomaDoisNumerosInteirosPositivos() {
        //arrange
        int primeiroNumero = 2;
        int segundoNumero = 3;
        int resultadoEsperado = 5;

        //act
        int resultadoObtido = calculadora.somar(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);     
    }

    /**
     * Testa a soma de dois números inteiros um positivo e outro negativo
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 5</p>
     * <p>- numero2 = -2</p>
     * <p><b>Saída : </b>3 </p>
     */
    @Test
    public void testarSomaDoisNumerosInteirosPositivoENegativo() {
        //arrange
        int primeiroNumero = 5;
        int segundoNumero = -2;
        int resultadoEsperado = 3;

        //act
        int resultadoObtido = calculadora.somar(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }    

/**
     * Testa a subtração de dois números inteiros positivos resultando em resposta positiva
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 5</p>
     * <p>- numero2 = 3</p>
     * <p><b>Saída : </b>2 </p>
     */
    @Test
    public void testarSubtrairDoisNumerosInteirosPositivosRespostaPositiva() {
        //arrange
        int primeiroNumero = 5;
        int segundoNumero = 3;
        int resultadoEsperado = 2;

        //act
        int resultadoObtido = calculadora.subtrair(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }        
/**
     * Testa a subtração de dois números inteiros positivos resultando em resposta negativa
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 5</p>
     * <p>- numero2 = 7</p>
     * <p><b>Saída : </b>-2 </p>
     */
    @Test
    public void testarSubtrairDoisNumerosInteirosPositivosRespostaNegativa() {
        //arrange
        int primeiroNumero = 5;
        int segundoNumero = 7;
        int resultadoEsperado = -2;

        //act
        int resultadoObtido = calculadora.subtrair(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }    

/**
     * Testa a subtração de dois números inteiros distintos(Positivo e negativo) resultando em resposta positiva
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 5</p>
     * <p>- numero2 = -2</p>
     * <p><b>Saída : </b>7 </p>
     */
    @Test
    public void testarSubtrairDoisNumerosInteirosPositivoNegativoRespostaPositiva() {
        //arrange
        int primeiroNumero = 5;
        int segundoNumero = -2;
        int resultadoEsperado = 7;

        //act
        int resultadoObtido = calculadora.subtrair(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }                
    
/**
     * Testa a subtração de dois números inteiros distintos(Positivo e negativo) resultando em resposta positiva
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 5</p>
     * <p>- numero2 = -6</p>
     * <p><b>Saída : </b>-1 </p>
     */
    @Test
    public void testarSubtrairDoisNumerosInteirosPositivoMenorNegativoMaiorRespostaPositiva() {
        //arrange
        int primeiroNumero = 5;
        int segundoNumero = -6;
        int resultadoEsperado = 11;

        //act
        int resultadoObtido = calculadora.subtrair(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    } 

/**
     * Testa a subtração de dois números inteiros distintos(Negativo e positivo) resultando em resposta positivo
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = -5</p>
     * <p>- numero2 = -6</p>
     * <p><b>Saída : </b>1 </p>
     */
    @Test
    public void testarSubtrairDoisNumerosInteirosNegativoPositivoRespostaPositiva() {
        //arrange
        int primeiroNumero = -5;
        int segundoNumero = -6;
        int resultadoEsperado = 1;

        //act
        int resultadoObtido = calculadora.subtrair(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }            
    
/**
     * Testa a subtração de dois números inteiros distintos(Negativo e positivo) resultando em resposta negativo
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = -5</p>
     * <p>- numero2 = -4</p>
     * <p><b>Saída : </b>-1 </p>
     */
    @Test
    public void testarSubtrairDoisNumerosInteirosNegativoPositivoRespostaNegativo() {
        //arrange
        int primeiroNumero = -5;
        int segundoNumero = -4;
        int resultadoEsperado = -1;

        //act
        int resultadoObtido = calculadora.subtrair(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }           

    /**
     * Testa a multiplicação de dois números inteiros positivo
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 2</p>
     * <p>- numero2 = 3</p>
     * <p><b>Saída : </b>6 </p>
     */
    @Test
    public void testarMultiplicarDoisNumerosInteirosPositivos() {
        //arrange
        int primeiroNumero = 2;
        int segundoNumero = 3;
        int resultadoEsperado = 6;

        //act
        int resultadoObtido = calculadora.multiplicar(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }     

    /**
     * Testa a multiplicação de um número positivo e um número negativo resultando em negativo
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 2</p>
     * <p>- numero2 = -3</p>
     * <p><b>Saída : </b>-6 </p>
     */
    @Test
    public void testarMultiplicarInteiroPositivoPorInteiroNegativo() {
        //arrange
        int primeiroNumero = 2;
        int segundoNumero = -3;
        int resultadoEsperado = -6;

        //act
        int resultadoObtido = calculadora.multiplicar(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }     

    /**
     * Testa a multiplicação de um número negativo e um número positivo resultando em negativo
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = -2</p>
     * <p>- numero2 = 3</p>
     * <p><b>Saída : </b>-6 </p>
     */
    @Test
    public void testarMultiplicarInteiroNegativoPorInteiroPositivo() {
        //arrange
        int primeiroNumero = -2;
        int segundoNumero = 3;
        int resultadoEsperado = -6;

        //act
        int resultadoObtido = calculadora.multiplicar(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }         

    /**
     * Testa a multiplicação de dois números negativos resulta positivo
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = -2</p>
     * <p>- numero2 = 3</p>
     * <p><b>Saída : </b>-6 </p>
     */
    @Test
    public void testarMultiplicarDoisInteirosPositivos() {
        //arrange
        int primeiroNumero = -2;
        int segundoNumero = -3;
        int resultadoEsperado = 6;

        //act
        int resultadoObtido = calculadora.multiplicar(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }     

    /**
     * Testa a multiplicação de um positivo por zero.
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 5</p>
     * <p>- numero2 = 0</p>
     * <p><b>Saída : </b>0 </p>
     */
    @Test
    public void testarMultiplicarPorZero() {
        //arrange
        int primeiroNumero = 5;
        int segundoNumero = 0;
        int resultadoEsperado = 0;

        //act
        int resultadoObtido = calculadora.multiplicar(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }   

    /**
     * Testa a Divisão de dois inteiros positivos resultando inteiro exato
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 6</p>
     * <p>- numero2 = 3</p>
     * <p><b>Saída : </b>2 </p>
     */
    @Test
    public void testarDividirDoisInteirosPositivosResultadoExato() {
        //arrange
        int primeiroNumero = 6;
        int segundoNumero = 3;
        int resultadoEsperado = 2;

        //act
        int resultadoObtido = calculadora.dividir(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }   

    /**
     * Testa a Divisão de dois inteiros positivos resultando valor com fração
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 5</p>
     * <p>- numero2 = 2</p>
     * <p><b>Saída : </b>2 </p>
     */
    @Test
    public void testarDividirDoisInteirosPositivosResultadoComFracao() {
        //arrange
        int primeiroNumero = 5;
        int segundoNumero = 2;
        int resultadoEsperado = 2;

        //act
        int resultadoObtido = calculadora.dividir(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }   

    /**
     * Testa a Divisão com um dos números negativos gera resultado negativo
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 5</p>
     * <p>- numero2 = -2</p>
     * <p><b>Saída : </b>-2 </p>
     */
    @Test
    public void testarDividirComNumeroNegativoResultaNegativo() {
        //arrange
        int primeiroNumero = 5;
        int segundoNumero = -2;
        int resultadoEsperado = -2;

        //act
        int resultadoObtido = calculadora.dividir(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    } 

    /**
     * Testa a Divisão de dois inteiros positivos resultando valor com fração
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 5</p>
     * <p>- numero2 = 2</p>
     * <p><b>Saída : </b>2 </p>
     */
    @Test
    public void testarDividirPorZeroGeraErro() {
        //arrange
        int primeiroNumero = 5;
        int segundoNumero = 0;
        int resultadoEsperado =-1;

        //act
        int resultadoObtido = calculadora.dividir(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }   
}
