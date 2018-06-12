import java.util.Scanner;

public class Prefeitura {
    Cidadao[] cidadaos;
    GeradorDePopulacao geradorDePopulacao;
    Scanner s;

    public Prefeitura(int qtd, int menorAnoDeNascimento, int rendaMinima, int anoAtual){
        s = new Scanner(System.in);
        geradorDePopulacao = new GeradorDePopulacao();
        cidadaos = geradorDePopulacao.gerar(qtd, menorAnoDeNascimento, rendaMinima, anoAtual);
        System.out.println("\nO orçamento para a implementação de uma renda mínima no município custará: "+calculeOrcamentoRendaMinima(rendaMinima));
        System.out.println("A renda média neste município é de: $"+calculeRendaMedia()+". Isto é, $"+(calculeRendaMedia()-(1.0f*rendaMinima))+" diferente da renda mínima.");
        System.out.println("Calculando a renda média entre duas idades: (40 e 70 anos) $"+calculeRendaMediaEntreFaixa(30,70));
        System.out.println("O número de idoso no município é de: "+quantosIdosos(70));
        Cidadao[] rq = encontreCidadaosComRendaAPartirDe(1400);
        for(Cidadao c : rq){
            System.out.printf("O cidadão nascido no ano de %d, e detentor de uma renda de $%d, tem renda acima de $1400. \n",c.getAnoDeNascimento(), c.getRenda());
        }
        //System.out.println("Os cidadaos com renda acima de $1400 são: ");
    }

    public int getNumCidadaos(){
        return cidadaos.length;
    }

    public int calculeOrcamentoRendaMinima(int rendaMinima){
        int orcamento = 0;
        for (Cidadao c : cidadaos){
            if(c.getRenda()<rendaMinima){
                int diferenca = rendaMinima-c.getRenda();
                orcamento += diferenca;
            }
        }
        return orcamento;
    }

    public double calculeRendaMedia(){
        int  soma = 0;
        for (Cidadao c : cidadaos){
            soma += c.getRenda();
        }
        return soma/(1.0f * getNumCidadaos());
    }

    public double calculeRendaMediaEntreFaixa(int menorIdade, int maiorIdade){
        int soma = 0;
        int cidadaosNaFaixa = 0;
        for (Cidadao c : cidadaos){
            if (c.getIdade()>= menorIdade && c.getIdade()<=maiorIdade){
                cidadaosNaFaixa++;
                soma += c.getRenda();
            }
        }
        return soma/(1.0f * cidadaosNaFaixa);
    }

    public int quantosIdosos(int terceiraIdade){
        int idosos = 0;
        for (Cidadao c : cidadaos){
            if(c.getIdade()>terceiraIdade){
                idosos++;
            }
        }
        return  idosos;
    }

    public Cidadao[] encontreCidadaosComRendaAPartirDe(int renda){
        Cidadao[] playboys;
        Cidadao[] temporario = new Cidadao[getNumCidadaos()];
        int qtd = 0;
        for (Cidadao c : cidadaos){
            if (c.getRenda()>=renda){
                temporario[qtd++] = c;
            }
        }
        if(qtd == getNumCidadaos()){
            playboys = temporario;
        } else {
            playboys = new Cidadao[qtd];
            for (Cidadao c : cidadaos){
                for (int i=0; i<qtd; i++){
                    playboys[i] = temporario[i];
                }
            }
        }
        return playboys;
    }

    public static void main(String[] args){
        Prefeitura prefeitura = new Prefeitura(8, 1940, 900, 2018);
    }

}
