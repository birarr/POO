
public class Cidadao {
    int anoDeNascimento;
    int renda;
    int idade;

    public Cidadao(int anoDeNascimento, int renda, int anoAtual) {
        this.anoDeNascimento = anoDeNascimento;
        this.renda = renda;
        this.idade = anoAtual - anoDeNascimento;
    }

    public int getAnoDeNascimento() {
        return anoDeNascimento;
    }
    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public int getRenda() {
        return renda;
    }
    public void setRenda(int renda) {
        this.renda = renda;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Cidadao{" +
                "anoDeNascimento="+anoDeNascimento+", renda="+renda+", idade="+idade+'}';
    }
}
