package br.redes.atv06.ativ06urnaeletronica;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author ACFA
 */
public class ServidorEleicao extends UnicastRemoteObject implements ServicoEleicao {

    private static final long serialVersionUID = 1L;

    private static void exit(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private final Map<String, Integer> votos = new HashMap<>();

    public ServidorEleicao() throws RemoteException {
        super();
        Timer timer = new Timer();
        timer.schedule(new ApuracaoTask(), 0, 5000);
    }

    @Override
    public synchronized void enviarVoto(String nomeCandidato, int numeroVotos) throws RemoteException {
        if (nomeCandidato.isEmpty()) {
            nomeCandidato = "Votos em branco";
        } else if (nomeCandidato.equalsIgnoreCase("@")) {
            nomeCandidato = "Votos nulos";
        }

        if (numeroVotos < 0) {
            numeroVotos = 0;
        }
        votos.put(nomeCandidato, votos.getOrDefault(nomeCandidato, 0) + numeroVotos);
    }

    @Override
    public synchronized String apuracaoVotos() throws RemoteException {
        StringBuilder apuracao = new StringBuilder("Apuração de Votos:\n");
        for (Map.Entry<String, Integer> entry : votos.entrySet()) {
            apuracao.append(entry.getKey()).append(": ").append(entry.getValue()).append(" votos\n");
        }

        if (votos.isEmpty()) {
            return "\nAinda não há votos contabilizados!";
        }

        return apuracao.toString();
    }

    private class ApuracaoTask extends TimerTask {

        @Override
        public void run() {
            try {
                System.out.println(apuracaoVotos());
            } catch (RemoteException e) {
                System.out.println("error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try {
            ServidorEleicao servidor = new ServidorEleicao();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("//localhost/eleicao", servidor);
            System.out.println("Servidor pronto para receber votos.");
        } catch (MalformedURLException | RemoteException e) {
            System.out.println("error: " + e.getMessage());
            System.out.println("Não prossiga com as entradas. Servidor já está em uso em outra janela.");
        }
    }
}
