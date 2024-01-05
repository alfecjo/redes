/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.redes.calculadora;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {
    long add(long a, long b) throws RemoteException;
    long sub(long a, long b) throws RemoteException;
    long mul(long a, long b) throws RemoteException;
    long div(long a, long b) throws RemoteException;
}