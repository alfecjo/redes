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
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.print("Nome do candidato: ");
                    String nomeCandidato = scanner.nextLine();
                    System.out.print("Número de votos: ");
                    int numeroVotos = scanner.nextInt();
                    scanner.nextLine();
                    
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
            System.out.println("error: " + e.getMessage());
        }
    }
}