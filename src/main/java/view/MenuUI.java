package view;

import java.io.IOException;
import java.util.Scanner;

public class MenuUI {
    private Scanner sc = new Scanner(System.in);
    private EstudianteView estudianteView = new EstudianteView();

    public MenuUI() {}

    public void menu() throws IOException {
        while (true) {
            System.out.println("Bienvenido al Menu");
            System.out.println("1. Ingresar nuevo estudiante");
            System.out.println("2. Modificar estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Obtener estudiantes");
            System.out.println("5. Salir");
            System.out.print("¿Que desea hacer?: ");
            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> estudianteView.agregarEstudiante();
                case 2 -> estudianteView.modificarEstudiante();
                case 3 -> estudianteView.eliminarEstudiante();
                case 4 -> estudianteView.listarEstudiantes();
            }
        }
    }
}
