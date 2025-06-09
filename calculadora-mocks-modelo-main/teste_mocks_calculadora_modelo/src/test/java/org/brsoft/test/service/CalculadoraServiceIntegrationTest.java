package org.brsoft.test.service;

import org.brsoft.service.CalculadoraService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculadoraServiceIntegrationTest {
    private double n1;
    private double n2;
    private double resultadoEsperado;
    
    private CalculadoraService servico = new CalculadoraService();

    /**
     * Testar o calculo de dois números N1 e N2, onde N1 > N2
     * Cenário:
     * N1 = 5
     * N2 = 3
     * R = 80
     */
    @Test
    public void testarCalculoN1MaiorN2(){
        //assign (cenário de teste)
        n1 = 5.0;
        n2 = 3.0;
        resultadoEsperado = 80.0;
        
        //act
        double resultadoObtido = servico.calculo(n1, n2);

        //assert
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    /**
     * Testar o calculo de dois números N1 e N2, onde N1 igual N2
     * Cenário:
     * N1 = 5
     * N2 = 5
     * R = 50
     */
    @Test
    public void testarCalculoN1IgualN2(){
        //assign (cenário de teste)
        n1 = 5;
        n2 = 5;
        resultadoEsperado = 50;

        //act
        double resultadoObtido = servico.calculo(n1, n2);

        //assert
        assertEquals(resultadoEsperado, resultadoObtido);
    }    
}
