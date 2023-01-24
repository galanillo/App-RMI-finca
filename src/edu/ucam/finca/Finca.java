package edu.ucam.finca;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Finca extends Remote {
	// Métodos
	public void agregarCultivo(String nombreFinca, String nombreCultivo, int hectareas) throws RemoteException;

	public void eliminarCultivo(String nombreFinca, String nombreCultivo) throws RemoteException;

	public String[] obtenerCultivos(String nombreFinca) throws RemoteException;

	public int obtenerHectareas(String nombreFinca, String nombreCultivo) throws RemoteException;

	public void asignarHectareas(String nombreFinca, String nombreCultivo, int hectareas) throws RemoteException;
}
