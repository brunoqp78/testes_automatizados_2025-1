package org.brsoft.test.service;

import org.brsoft.entity.Calculadora;
import org.brsoft.service.CalculadoraService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CalculadoraServiceUnitTest {
    private double n1;
    private double n2;
    private double resultadoEsperado;
    
    @InjectMocks
    private CalculadoraService servico;

    @Mock
    private Calculadora calculadora;

    /** utilizar o beforeEach para configurar o Mock
     * 
     */
    @BeforeEach
    public void configurarMock(){
        //configurar o Mock
        Mockito.when(calculadora.somar(5.0, 3.0)).thenReturn(8.0);        
        Mockito.when(calculadora.somar(5.0, 5.0)).thenReturn(5.0);        
        Mockito.when(calculadora.somar(3.0, 8.0)).thenReturn(8.0);        
    }

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
        Mockito.verify(calculadora, Mockito.times(1)).somar(n1, n2);        
        Mockito.verify(calculadora, Mockito.times(0)).multiplicar(n1, n2);        
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
        Mockito.verify(calculadora, Mockito.times(1)).somar(n1, n2);        
        Mockito.verify(calculadora, Mockito.times(0)).multiplicar(n1, n2);        
    }    
}
