import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrePago extends Assinante{
    private float creditos;
    private  List<Recarga> recargas;
    private int numRecargas;

    public PrePago(long cpf, String nome, int numero) {
        super(cpf, nome, numero);
        this.creditos = 0.0f;
        this.recargas = new ArrayList<>();
        this.numRecargas = 0;
    }

    public void recarregar(Date data, float valor){
        Recarga recarga = new Recarga(data, valor);
        this.recargas.add(recarga);
        this.numRecargas++;
        this.creditos += valor;
    }

    public void fazerChamada(Date data, int duracao) {
        float custoChamada = 1.45f * duracao;
        if (creditos >= custoChamada) {
            Chamada chamada = new Chamada(data, duracao);
            adicionarChamada(chamada);
            creditos -= custoChamada;
        } else {
            System.out.println("Créditos insuficientes para realizar a chamada.");
        }
    }

    public void imprimirFatura(int mes) {
        System.out.println("Fatura do assinante pré-pago: " + nome);
        System.out.println("CPF: " + cpf + ", Número: " + numero);
        float totalChamadas = 0;
        for (Chamada chamada : chamadas) {

            totalChamadas += chamada.getDuracao() * 1.45f;
            System.out.println(chamada);
        }
        System.out.println("Total das chamadas: R$" + totalChamadas);
        System.out.println("Créditos restantes: R$" + creditos);
    }

}
