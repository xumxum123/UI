package atvdia11do10;

public class Cliente {
    private String nome;
    private int idade;
    private String sexo;

    public Cliente(String nome, int idade, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public String getResumo() {
        return "Nome: " + nome + ", Idade: " + idade + ", Sexo: " + sexo;
    }
}