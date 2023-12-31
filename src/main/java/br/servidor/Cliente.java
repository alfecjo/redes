package br.servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {
    private static Socket socket;
    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {
        try {
            socket = new Socket("127.0.0.1", 50000);

            entrada = new DataInputStream(socket.getInputStream());
            saida = new DataOutputStream(socket.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Digite um CPF para verificação: ");
            String valor = br.readLine();

            saida.writeUTF(valor);

            String resultado = entrada.readUTF();
           
            System.out.println(resultado);

            socket.close();

        } catch (IOException e) {
            System.out.println("Erro de retorno!");
        }
    }
}
