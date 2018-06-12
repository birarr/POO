import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class GeradorDePopulacao {
    Random random = new Random();

    public Cidadao[] gerar(int qtd, int menorAnoDeNascimento, int rendaMinima, int anoAtual){
        random = new Random();
        Cidadao[] cidadaos = new Cidadao[qtd];
        System.out.println("A renda mínima neste município é de $ "+rendaMinima);
        for (int i=0; i<cidadaos.length; i++){
            cidadaos[i] = new Cidadao(menorAnoDeNascimento + random.nextInt(70), random.nextInt(230)*10, anoAtual);
            ArrayList<Cidadao> cidadaosList = new ArrayList<>(Arrays.asList(cidadaos));
            if(cidadaos[i].getIdade()<=0){
                System.out.println("Cidadão não nascido ainda!");
            } else {
                //System.out.println(cidadaos[i].toString());
                System.out.printf("Cidadão nº %d criado! Possui %d anos, nascido em %s e renda de $%s\n", i+1, cidadaos[i].getIdade(), cidadaos[i].getAnoDeNascimento(), cidadaos[i].renda);
            }
        }
        return cidadaos;
    }



}
