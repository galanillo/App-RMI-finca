package edu.ucam.finca;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 8080);
			Finca finca = (Finca) registry.lookup("Finca");

			Scanner scanner = new Scanner(System.in);
			boolean exit = false;
			while (!exit) {
				// Muestra el men� con los distintos m�todos implementados
				System.out.println("--- MEN� ---");
				System.out.println("1. Agregar cultivo");
				System.out.println("2. Eliminar cultivo");
				System.out.println("3. Ver cultivos");
				System.out.println("4. Ver hect�reas de un cultivo");
				System.out.println("5. Asignar hect�reas a un cultivo");
				System.out.println("6. Salir");
				System.out.print("Selecciona una opci�n: ");
				int opcion = scanner.nextInt();
				scanner.nextLine();

				switch (opcion) {
				case 1:
					System.out.print("Ingresa el nombre de la finca: ");
					String nombreFinca = scanner.nextLine();
					System.out.print("Ingresa el nombre del cultivo: ");
					String nombreCultivo = scanner.nextLine();
					System.out.print("Ingresa las hect�reas: ");
					int hectareas = scanner.nextInt();
					scanner.nextLine();
					finca.agregarCultivo(nombreFinca, nombreCultivo, hectareas);
					break;
				case 2:
					System.out.print("Ingresa el nombre de la finca: ");
					nombreFinca = scanner.nextLine();
					System.out.print("Ingresa el nombre del cultivo: ");
					nombreCultivo = scanner.nextLine();
					finca.eliminarCultivo(nombreFinca, nombreCultivo);
					break;
				case 3:
					System.out.print("Ingresa el nombre de la finca: ");
					nombreFinca = scanner.nextLine();
					String[] cultivos = finca.obtenerCultivos(nombreFinca);
					for (String cultivo : cultivos) {
						System.out.println(cultivo);
					}
					break;
				case 4:
					System.out.print("Ingresa el nombre de la finca: ");
					nombreFinca = scanner.nextLine();
					System.out.print("Ingresa el nombre del cultivo: ");
					nombreCultivo = scanner.nextLine();
					int h = finca.obtenerHectareas(nombreFinca, nombreCultivo);
					System.out.println(h);
					break;
				case 5:
					System.out.print("Ingresa el nombre de la finca: ");
					nombreFinca = scanner.nextLine();
					System.out.print("Ingresa el nombre del cultivo: ");
					nombreCultivo = scanner.nextLine();
					System.out.print("Ingresa las hect�reas: ");
					hectareas = scanner.nextInt();
					scanner.nextLine();
					finca.asignarHectareas(nombreFinca, nombreCultivo, hectareas);
					break;
				case 6:
					exit = true;
					System.out.println("ADI�S!");
					break;
				default:
					System.out.println("ERROR");
					break;
				}
			}
			scanner.close();
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}