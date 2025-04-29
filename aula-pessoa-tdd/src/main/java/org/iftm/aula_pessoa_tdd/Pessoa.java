package org.iftm.aula_pessoa_tdd;

public class Pessoa {
    private String nome;
    private double salario;

    public Pessoa(){}

    public Pessoa(String nome) {
        this.nome = validaNome(nome);
    }

    public String getNome() {
        return nome;
    }
    public double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = validaNome(nome);
    }

    private String validaNome(String nome){
        if (nome.length()>=2 && nome.length()<=100){
            return nome.toUpperCase();
        }else{
            throw new IllegalArgumentException("Nome inválido, precisa ter entre 2 e 200 caracteres.");
        }
    }

    public void setSalario(double salario) {
        this.salario = validaSalario(salario);
    }

    public double validaSalario(double salario){
        if (salario >= 1518 && salario <=1000000)
           return salario;
        else{
            throw new IllegalArgumentException("Salário inválido, precisa ter um valor entre 1518.00 e 1000000.00");
        }
    }

    public void reajustarSalario(double porcentagem) {
        if (porcentagem >= 1 && porcentagem <= 100){
            salario += validaReajuste(porcentagem);
        }else{
            throw new IllegalArgumentException("Porcentagem de reajuste inválida, valores válidos entre 1 e 100.");
        }
    }

    public double validaReajuste(double porcentagem){
            double aumento = salario * porcentagem/100;
            if (salario+aumento > 1000000){
                throw new IllegalArgumentException("Reajuste ultrapassa limite de salário de R$ 1000000.00.");
            }else{
                return aumento;
            }
    }


}
