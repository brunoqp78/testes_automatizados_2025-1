package org.iftm.aula_pessoa_tdd;

public class Pessoa {
    private String nome;
    private double salario;

    public Pessoa(String nome) {
        this.nome = validaNome(nome);
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = validaNome(nome);
        
    }


    public String validaNome(String nome){
        if (nome.length()>=2 && nome.length()<=100){
            return nome.toUpperCase();
        }else{
            throw new IllegalArgumentException("Nome inválido, precisa ter entre 2 e 200 caracteres.");
        }
    }

}
