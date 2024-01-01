package br.redes.atv04;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorRedesAtv04 {

    private static ServerSocket serverSocket;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10); // Número máximo de threads concorrentes

    public static void main(String[] args) {
        try {
            System.out.println("Server on port: 52000!!!");
            serverSocket = new ServerSocket(52000);

            while (true) {
                System.out.println("Waiting for connection from a client...");
                Socket socket = serverSocket.accept();
                System.out.println("Connected client!");

                threadPool.submit(() -> handleClient(socket));
            }
        } catch (IOException e) {
            System.out.println("ServerSide err!!!\n" + e.getMessage());
        }
    }

    private static void handleClient(Socket socket) {
        try {
            var entrada = new ObjectInputStream(socket.getInputStream());
            var saida = new ObjectOutputStream(socket.getOutputStream());

            Pessoa pessoa = (Pessoa) entrada.readObject();

            synchronized (System.out) {
                System.out.println("\nClient's data!!!\n");
                System.out.println("Name: " + pessoa.getNome() + "\nAge: " + pessoa.getIdade());
            }

            String dados = "Sent from ServerSide!!!\nData received correctly!!!\n";

            saida.writeObject(dados);

            entrada.close();
            saida.close();
            socket.close();

            synchronized (System.out) {
                System.out.println("\nClose server!!!");
                System.out.print("---------------");
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during client processing: " + e.getMessage());
        }
    }
}