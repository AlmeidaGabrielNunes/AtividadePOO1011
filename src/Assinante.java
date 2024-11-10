import java.util.ArrayList;
import java.util.List;

public abstract class Assinante {
 protected long cpf;
 protected String nome;
 protected int numero;
 protected List<Chamada> chamadas;
 protected int numChamadas;

 public Assinante(long cpf, String nome, int numero){
     this.cpf = cpf;
     this.nome = nome;
     this.numero = numero;
     this.chamadas = new ArrayList<>();
     this.numChamadas = 0;
 }

public float getCpf(){
     return  cpf;
}

    public void adicionarChamada(Chamada chamada) {
        if (numChamadas < chamadas.size()) {
            chamadas.add(chamada);
            numChamadas++;
        } else {
            System.out.println("Não há espaço para mais chamadas.");
        }
    }

@Override
    public String toString(){
     return "Assinante{" +
             "cpf= " + cpf +
             ", nome='" + nome + '\'' +
             ", numero = " + numero +
             '}';
}

}

