package br.redes.servidorredes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private static Socket socket;
    private static ServerSocket serverSocket;

    private static ObjectInputStream entrada;
    private static ObjectOutputStream saida;

    public static void main(String[] args) {
        try {
            System.out.println("Server na port: 51000!!!");
            serverSocket = new ServerSocket(51000);

            System.out.println("Server em Standby Mode!!!");
            socket = serverSocket.accept();

            entrada = new ObjectInputStream(socket.getInputStream());
            saida = new ObjectOutputStream(socket.getOutputStream());

            Pessoa pessoa = (Pessoa) entrada.readObject();

            System.out.println("\nDados do Cliente!!!\n");
            System.out.println("Nome: " + pessoa.getNome() + "\nIdade: " + pessoa.getIdade());

            String dados = "Enviado do ServerSide!!!\nDados recebidos corretamente!!!\nProcesso Encerrado!!!";
            saida.writeObject(dados);

            System.out.println("\nFechando conexão!!!");
            saida.close();
            entrada.close();
            socket.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("ServerSide err!!!\n" + e.getMessage());
        }
    }
}
