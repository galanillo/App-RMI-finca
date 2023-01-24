package edu.ucam.finca;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
	public static void main(String[] args) {
		try {
			// Establecer el código base para poder cargar las clases del objeto remoto
			System.setProperty("java.rmi.server.codebase", "file:/C:/49273120J/src/edu/ucam/finca/");
			Finca finca = new FincaImplementacion();

			// Crear un registro en el puerto 8080
			Registry registry = LocateRegistry.createRegistry(8080);
			// Asociar el objeto remoto al registro
			registry.rebind("Finca", finca);

			System.out.println("Servidor iniciado");
		} catch (RemoteException e) {
			System.out.println("Trouble: " + e);
		}
	}
}
