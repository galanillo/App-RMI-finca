package edu.ucam.finca;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class FincaImplementacion extends UnicastRemoteObject implements Finca {
	private static final long serialVersionUID = 1L;
	// Mapa que almacena las fincas y sus cultivos
	private Map<String, Map<String, Integer>> fincas;

	public FincaImplementacion() throws RemoteException {
		fincas = new HashMap<>(); // Inicializa el mapa "fincas"
	}

	@Override
	public void agregarCultivo(String nombreFinca, String nombreCultivo, int hectareas) throws RemoteException {
		Map<String, Integer> cultivos = fincas.get(nombreFinca); // Obtiene la lista de cultivos de la finca
																	// especificada
		if (cultivos == null) { // Si la finca no existe en el mapa "fincas"
			cultivos = new HashMap<>(); // Crea una nueva lista de cultivos
			fincas.put(nombreFinca, cultivos); // Añade la finca al mapa "fincas"
		}
		cultivos.put(nombreCultivo, hectareas); // Añade el cultivo a la lista de cultivos de la finca
	}

	@Override
	public void eliminarCultivo(String nombreFinca, String nombreCultivo) throws RemoteException {
		Map<String, Integer> cultivos = fincas.get(nombreFinca); // Obtiene la lista de cultivos de la finca
																	// especificada
		if (cultivos != null) { // Si la finca existe en el mapa "fincas"
			cultivos.remove(nombreCultivo); // Elimina el cultivo de la lista de cultivos
		}
	}

	@Override
	public String[] obtenerCultivos(String nombreFinca) throws RemoteException {
		Map<String, Integer> cultivos = fincas.get(nombreFinca); // Obtiene la lista de cultivos de la finca
																	// especificada
		if (cultivos == null) { // Si la finca no existe en el mapa "fincas"
			return new String[0]; // Devuelve una lista vacía
		}
		return cultivos.keySet().toArray(new String[cultivos.size()]); // Devuelve la lista de nombres de cultivos como
																		// un arreglo
	}

	@Override
	public int obtenerHectareas(String nombreFinca, String nombreCultivo) throws RemoteException {
		Map<String, Integer> cultivos = fincas.get(nombreFinca); // Obtiene la lista de cultivos de la fin
		if (cultivos == null) { // Si la finca no existe en el mapa "fincas"
			return 0; // Devuelve 0 hectáreas
		}
		Integer hectareas = cultivos.get(nombreCultivo); // Obtiene el número de hectáreas del cultivo especificado
		if (hectareas == null) { // Si el cultivo no existe en la lista de cultivos
			return 0; // Devuelve 0 hectáreas
		}
		return hectareas; // Devuelve el número de hectáreas
	}

	@Override
	public void asignarHectareas(String nombreFinca, String nombreCultivo, int hectareas) throws RemoteException {
		Map<String, Integer> cultivos = fincas.get(nombreFinca); // Obtiene la lista de cultivos de la finca
																	// especificada
		if (cultivos != null) { // Si la finca existe en el mapa "fincas"
			cultivos.put(nombreCultivo, hectareas); // Asigna las hectáreas al cultivo especificado
		}
	}
}