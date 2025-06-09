package org.brsoft.service;

import org.brsoft.entity.Calculadora;

public class CalculadoraService {
	private Calculadora calc = new Calculadora();
	
	public double calculo(double n1, double n2) {
		if (n1==10.0)	{
			return calc.multiplicar(n1, n2);
		}				
		else{
			return calc.somar(n1, n2)*10;
		}
	}


}
