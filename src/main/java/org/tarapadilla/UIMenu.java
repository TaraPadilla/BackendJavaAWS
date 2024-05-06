package org.tarapadilla;

import org.tarapadilla.Repository.EmployeeRepository;
import org.tarapadilla.Repository.IRepository;
import org.tarapadilla.model.Employee;
import org.tarapadilla.utils.DatabaseConnection;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLException;
import java.util.Scanner;

public class UIMenu {
    static Scanner sc = new Scanner(System.in);
    static Employee emp = new Employee();
    static IRepository<Employee> repository = new EmployeeRepository();

    public static void showMenu() throws SQLException {
        System.out.println("Bienvenido a Mi Empresa");
        System.out.println("Selecciona la opción del menu");

        int response = 1;
        do {
            switch (showPrincipal()){
                case 1:
                    System.out.println("Ingrese los datos del empleado");
                    repository.save(capturaDatos());
                    break;
                case 2:
                    System.out.println("Ingrese el Id del empleado a actualizar");
                    Integer id = sc.nextInt();
                    emp = repository.getById(id);
                    System.out.println(emp.toString());
                    break;
                case 3:
                    System.out.println("Ingrese el Id del empleado a eliminar");
                    id = Integer.valueOf(sc.next());
                    emp = repository.getById(id);
                    repository.delete(emp);
                    break;
                case 4:
                    System.out.println("Ingrese el Id del empleado a buscar");
                    id = Integer.valueOf(sc.next());
                    emp = repository.getById(id);
                    System.out.println(emp.toString());
                    break;
                case 5:
                    repository.getAll().forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("Guardando cambios");
                    System.out.println("_______");
                    DatabaseConnection.saveTransactions();
                    System.out.println("Transacciones guardadas");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + showPrincipal());
            }

            System.out.println("¿Desea realizar otra operacion? Si/No");
            String cont = sc.next();

            switch (cont){
                case "Si":
                    response = 1;
                    break;
                case "No":
                    response = 0;
                    System.out.println();
            }
        }while (response != 0);
    }

    private static Integer showPrincipal() {
        Integer Opcion;
        System.out.println("1. Insertar Empleado");
        System.out.println("2. Actualizar Empleado");
        System.out.println("3. Eliminar Empleado");
        System.out.println("4. Buscar Empleado");
        System.out.println("5. Listar Empleados");
        System.out.println("0. Enviar Procesos");
        Opcion = sc.nextInt();
        return Opcion;
    }

    public static Employee capturaDatos(){
        System.out.println("Digita primer nombre: ");
        emp.setFirst_name(sc.nextLine());
        System.out.println("Digita primer apellido: ");
        emp.setPa_surname(sc.nextLine());
        System.out.println("Digita segundo apellido: ");
        emp.setMa_surname(sc.nextLine());
        System.out.println("Digite el mail: ");
        emp.setEmail(sc.nextLine());
        System.out.println("Digite el salario: ");
        emp.setSalary(sc.nextFloat());
        return emp;
    }
}
