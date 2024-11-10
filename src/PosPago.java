import java.util.Date;

public class PosPago extends Assinante {
    private float assinatura;

    public PosPago(long cpf, String nome, int numero, float assinatura) {
        super(cpf, nome, numero);
        this.assinatura = assinatura;
    }

    public void fazerChamada(Date data, int duracao) {
        float custoChamada = 1.04f * duracao;
        Chamada chamada = new Chamada(data, duracao);
        adicionarChamada(chamada);
    }

    public void imprimirFatura(int mes) {
        System.out.println("Fatura do assinante pós-pago: " + nome);
        System.out.println("CPF: " + cpf + ", Número: " + numero);
        float totalChamadas = 0;
        for (Chamada chamada : chamadas) {
            totalChamadas += chamada.getDuracao() * 1.04f;
            System.out.println(chamada);
        }
        float totalFatura = assinatura + totalChamadas;
        System.out.println("Total da fatura: R$" + totalFatura);
    }
    }
