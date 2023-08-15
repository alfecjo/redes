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
                    System.out.print("Nome do candidato: ");
                    String nomeCandidato = scanner.nextLine();
                    System.out.print("Número de votos: ");
                    int numeroVotos = scanner.nextInt();
                    scanner.nextLine();

                    servico.enviarVoto(nomeCandidato, numeroVotos);

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

                    System.out.println("Voto enviado!");

                    System.out.print("Deseja continuar a fornecer votos? (S)im ou (N)ão... ");
                    String continuar = scanner.nextLine();
                    if (!continuar.equalsIgnoreCase("s")) {
                        break;
                    }
                }
            }
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
