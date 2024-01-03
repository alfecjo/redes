package br.redes.atv06.ativ06urnaeletronica;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ACFA
 */
public interface ServicoEleicao extends Remote {

    void enviarVoto(String nomeCandidato, int numeroVotos) throws RemoteException;

    String apuracaoVotos() throws RemoteException;
}