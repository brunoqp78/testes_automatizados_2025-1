package org.iftm.testes.calculadoraaula.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    
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
        Calculadora calculadora = new Calculadora();
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
     * <p><b>Cenário : </b> Somar dois números distintos</p>
     * <p><b>Entrada : </b></p>
     * <p>- numero1 = 5</p>
     * <p>- numero2 = -2</p>
     * <p><b>Saída : </b>3 </p>
     */
    @Test
    public void testarSomaDoisNumerosInteirosPositivoENegativo() {
        //arrange
        Calculadora calculadora = new Calculadora();
        int primeiroNumero = 5;
        int segundoNumero = -2;
        int resultadoEsperado = 3;

        //act
        int resultadoObtido = calculadora.somar(primeiroNumero, segundoNumero);

        //assign
        assertEquals(resultadoEsperado, resultadoObtido);        
    }    
}
