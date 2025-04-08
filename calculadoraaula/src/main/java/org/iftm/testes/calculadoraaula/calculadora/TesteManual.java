package org.iftm.testes.calculadoraaula.calculadora;

public class TesteManual {
    public static void main(String[] args) {
        //arrange
        //instanciar os objetos
        Calculadora calculadora = new Calculadora();
        // definir o cenário de teste: soma de dois números inteiros positivos
        //definir as entradas
        int primeiroNumero = 2;
        int segundoNumero = 3;
        int resultadoEsperado = 5;

        //act
        int resultadoObtido = calculadora.somar(primeiroNumero, segundoNumero);

        //assign
        System.out.println(resultadoObtido);

    }
}
