package br.redes.atv06.ativ06urnaeletronica;

/**
 *
 * @author ACFA
 */
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class UrnaEletronica {

    public static void main(String[] args) {
        try {
            ServicoEleicao servico = (ServicoEleicao) Naming.lookup("//localhost/eleicao");
            try ( Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.print("\nPara votos em branco, apenas tecle <Enter> no campo: \"Nome do candidato: \", digite o número de votos e tecle <Enter>!");
                    System.out.print("\nPara votos nulos, apenas tecle \"@\" no campo: \"Nome do candidato: \", tecle <Enter> e digite o número de votos e tecle <Enter>!");
                    System.out.print("\nPara encerrar a aplicação, digite \"EXIT\" em \"Nome do candidato: \", tecle <Enter>, e digite 0(zero) para número de votos e tecle <Enter>!");
                    System.out.print("\nNome do candidato: ");
                    String nomeCandidato = scanner.nextLine();

                    var numeroVotos = 0;
                    System.out.print("Número de votos: ");
                    try {
                        numeroVotos = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido para número de votos. Voto desconsiderado!");
                        continue;
                    }

                    ilustra();

                    servico.enviarVoto(nomeCandidato, numeroVotos);
                    
                    System.out.println("Voto enviado!");

                    System.out.print("Deseja continuar a fornecer votos? (S)im ou (N)ão... ");
                    String continuar = scanner.nextLine();
                    if (!continuar.equalsIgnoreCase("s")) {
                        break;
                    }
                }
            }
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println("Servidor sendo encerrado!!!");
        }
    }

    public static void ilustra() {
        for (int i = 1; i <= 13; i++) {
            StringBuilder dots = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                dots.append(".");
            }
            System.out.print(dots.toString());
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            
            System.out.print("\r");
        }
    }
}
