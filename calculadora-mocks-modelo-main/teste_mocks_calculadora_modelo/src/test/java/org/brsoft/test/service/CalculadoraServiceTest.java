package org.brsoft.test.service;

import org.brsoft.entity.Calculadora;
import org.brsoft.service.CalculadoraService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class CalculadoraServiceTest {

    @InjectMocks
    private CalculadoraService servico;

    @Mock
    private Calculadora calculadora;

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
        double n1 = 5.0;
        double n2 = 3.0;
        double resultadoEsperado = 80.0;
        Mockito.when(calculadora.somar(n1, n2)).thenReturn(8.0);
        
        //act
        double resultadoObtido = servico.calculo(n1, n2);

        //assert
        assertEquals(resultadoEsperado, resultadoObtido);
        Mockito.verify(calculadora, Mockito.times(1)).somar(n1, n2);        
        Mockito.verify(calculadora, Mockito.times(0)).multiplicar(n1, n2);        
    }
}
