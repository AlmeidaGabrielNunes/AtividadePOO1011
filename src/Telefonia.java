import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Telefonia {
    private List<PrePago> prePagos;
    private List<PosPago> posPagos;

    public Telefonia() {
        this.prePagos = new ArrayList<>();
        this.posPagos = new ArrayList<>();
    }

    public void cadastrarAssinante() {
        // Exemplo de implementação simplificada para cadastro
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CPF: ");
        long cpf = scanner.nextLong();
        System.out.print("Digite o nome: ");
        String nome = scanner.next();
        System.out.print("Digite o número: ");
        int numero = scanner.nextInt();
        System.out.print("Assinante pré-pago (1) ou pós-pago (2)? ");
        int tipo = scanner.nextInt();

        if (tipo == 1) {
            prePagos.add(new PrePago(cpf, nome, numero));
        } else if (tipo == 2) {
            System.out.print("Digite o valor da assinatura: ");
            float assinatura = scanner.nextFloat();
            posPagos.add(new PosPago(cpf, nome, numero, assinatura));
        }
        System.out.println("Assinante cadastrado com sucesso.");
    }

    public void listarAssinantes() {
        System.out.println("Assinantes Pré-Pagos:");
        for (PrePago prePago : prePagos) {
            System.out.println(prePago);
        }
        System.out.println("\nAssinantes Pós-Pagos:");
        for (PosPago posPago : posPagos) {
            System.out.println(posPago);
        }
    }

    public static void main(String[] args) {
        Telefonia sistema = new Telefonia();
        sistema.cadastrarAssinante();  // Teste de cadastro
        sistema.listarAssinantes();    // Teste de listagem
    }
}