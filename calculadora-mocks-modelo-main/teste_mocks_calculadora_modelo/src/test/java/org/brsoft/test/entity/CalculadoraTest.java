package org.brsoft.test.entity;

import org.brsoft.entity.Calculadora;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	private Calculadora calc;
	
	@BeforeEach
	public void setup() {
		calc = new Calculadora();
	}	
	
	@Test
	public void testarSomaN1MaiorN2() {
		Assertions.assertEquals(5, calc.somar(3, 2));
	}
	
	@Test
	public void testarSomaN1IgualN2() {
		Assertions.assertEquals(3, calc.somar(3, 3));
	}
	
	@Test
	public void testarSomaN1MenorN2() {
		Assertions.assertEquals(3, calc.somar(2, 3));
	}

}
