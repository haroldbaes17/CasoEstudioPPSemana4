package view;

import controller.CursoController;
import model.Curso;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CursoView {
    private CursoController controller = new CursoController();
    private Scanner scanner = new Scanner(System.in);

    public CursoView() {}

    public void agregarCurso() {
        try {
            System.out.print("Ingrese el nombre del curso: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el descripcion del curso: ");
            String descripcion = scanner.nextLine();
            controller.agregarCurso(nombre, descripcion, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void modificarCurso() throws SQLException {
        boolean estado = false;
        Curso cursoEncontrado = null;
        List<Curso> listaCursos = controller.devolverCursos();

        try {
            System.out.print("Ingrese el ID del curso a modificar: ");
            int id = Integer.parseInt(scanner.nextLine());

            for (Curso item : listaCursos) {
                if (item.getId() == id) cursoEncontrado = item;
            }

            if (cursoEncontrado != null) {
                System.out.print("Ingrese el nuevo nombre del curso: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese la nueva descripcion del curso: ");
                String descripcion = scanner.nextLine();
                System.out.print("Ingrese el nuevo estado del curso (Activo / Inactivo): ");
                String estadoStr = scanner.nextLine();
                if (estadoStr.trim().equalsIgnoreCase("Activo")) estado = true;

                controller.modificarCurso(id, nombre, descripcion, estado);
            }else {
                System.out.println("Curso no encontrado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarCurso() {
        try {
            System.out.print("Ingrese el ID del curso a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());
            controller.eliminarCurso(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void listarCursos() {
        controller.obtenerCursos();
    }
}
