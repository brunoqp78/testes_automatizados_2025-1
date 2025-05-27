package org.brsoft.entity;

public class Calculadora {
	/*
	 * uma soma louca... 
	 * se n1 for maior que n2 retorna n1+n2
	 * se n1 for igual a n2 retorna n1
	 * se n2 for maior que n1 retorna n2
	 */
	public double somar(double n1, double n2) {
		if (n1>n2) return n1+n2;
		else if (n1==n2) return n1;
		else return n2;
	}
	public double multiplicar(double n1, double n2){
		return n1*n2;
	}
}
