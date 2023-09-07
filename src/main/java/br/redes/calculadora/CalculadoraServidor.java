package br.redes.calculadora;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraServidor implements Calculadora{

    public CalculadoraServidor() {}

    @Override
    public long add(long a, long b) throws RemoteException {
        return a + b;
    }

    @Override
    public long sub(long a, long b) throws RemoteException {
        return a - b;
    }

    @Override
    public long mul(long a, long b) throws RemoteException {
        return a * b;
    }

    @Override
    public long div(long a, long b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Divisão por zero não é permitida.");
        }
        return a / b;
    }
    
    public static void main(String[] args) {
        try {
            CalculadoraServidor servidor = new CalculadoraServidor();
            Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(servidor, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Calculadora", stub);

            System.out.println("Servidor pronto...");
        } catch (AlreadyBoundException | RemoteException e) {
            System.err.println("Erro no servidor: " + e.toString());
        }
    }
}