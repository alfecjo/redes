package br.redes.calculadora;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculadoraCliente {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Calculadora calculadora = (Calculadora) registry.lookup("Calculadora");

            long a = 10;
            long b = 5;

            long soma = calculadora.add(a, b);
            long subtracao = calculadora.sub(a, b);
            long multiplicacao = calculadora.mul(a, b);
            long divisao = calculadora.div(a, b);

            System.out.println("Resultado da Soma: " + soma);
            System.out.println("Resultado da Subtração: " + subtracao);
            System.out.println("Resultado da Multiplicação: " + multiplicacao);
            System.out.println("Resultado da Divisão: " + divisao);
        } catch (NotBoundException | RemoteException e) {
            System.err.println("Erro no cliente: " + e.toString());
        }
    }
}