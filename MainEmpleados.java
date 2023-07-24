package TallerClase210723.EmpleadosDptos;

import java.util.*;

public class MainEmpleados {
    public static void main(String[] args) {

        List<Empleado> empleados = new ArrayList<>();
        Map<String,List<Empleado>> empleadosPorDepartamento = new HashMap<>();
        empleados.add(new Empleado("Daniel","Marquez",25,"Calidad"));
        empleados.add(new Empleado("Diego","Marquez",22,"Compras"));
        empleados.add(new Empleado("Pedro","Rodriguez",23,"Inventarios"));
        empleados.add(new Empleado("Eliana","Camargo",25,"Contabilidad"));
        empleados.add(new Empleado("Cristian","Robayo",20,"Inventarios"));

        Scanner sc = new Scanner(System.in);
        System.out.println("¡Bienvenido!\n");
        int opcion = 0;
        while(opcion != 6){
            System.out.println("Menú principal\n");
            System.out.println("1. Agregar nuevo empleado");
            System.out.println("2. Mostrar todos los empleados");
            System.out.println("3. Mostrar empleados organizados por departamento");
            System.out.println("4. Buscar empleado por nombre y apellido");
            System.out.println("5. Eliminar empleado");
            System.out.println("6. Salir del programa");
            System.out.println("\nSeleccione la accion que desea realizar por el número en el menú");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    agregarEmpleado(empleados);
                    break;
                case 2:
                    mostrarEmpleados(empleados);
                    break;
                case 3:
                    mostrarEmpleadosPorDepartamentos(empleadosPorDepartamento, empleados);
                    break;
                case 4:
                    buscarEmpleado(empleados);
                    break;
                case 5:
                    eliminarEmpleado(empleados);
                    break;
                case 6:
                    System.out.println("¡Saliendo del programa!");
                    break;
                default:
                    System.out.println("Por favor ingresa una opcion valida");
            }
        }

    }

    public static void agregarEmpleado(List<Empleado> empleados){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa los datos del empleado");
        System.out.println("Nombre:");
        String nombre = sc.next();
        System.out.println("Apellido:");
        String apellido = sc.next();
        System.out.println("Edad:");
        Integer edad = sc.nextInt();
        System.out.println("Departamento:");
        String departamento = sc.next();
        empleados.add(new Empleado(nombre,apellido,edad,departamento));
        System.out.println("El empleado ha sido agregado");
    }

    public static void mostrarEmpleados(List<Empleado> empleados){
        System.out.println("Lista completa de empleados: ");
        for(Empleado empl: empleados){
            System.out.println(empl.toString());

        }
        System.out.println("\n");
        System.out.println("--------------------------------");
    }

    public static void mostrarEmpleadosPorDepartamentos (Map<String,List<Empleado>> empleadosPorDepartamento, List<Empleado> empleados){
        for(Empleado emp: empleados){
            List<Empleado> arrayDepartamento;
            if(empleadosPorDepartamento.containsKey(emp.getDepartamento())){
                arrayDepartamento = empleadosPorDepartamento.get(emp.getDepartamento());
            }else{
                arrayDepartamento = new ArrayList<>();
            }
            arrayDepartamento.add(emp);
            empleadosPorDepartamento.put(emp.getDepartamento(),arrayDepartamento);
        }

        System.out.println("Lista de empleados por departamento:");
        for(String dpto: empleadosPorDepartamento.keySet()){
            System.out.println(dpto);
            List<Empleado> arrayDepartamento = empleadosPorDepartamento.get(dpto);
            for(Empleado emp: arrayDepartamento){
                System.out.println(emp.toString());
            }
            System.out.println("\n");
        }

    }

    public static void buscarEmpleado(List<Empleado> empleados){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa los datos del empleado a buscar");
        System.out.println("Nombre:");
        String nombre = sc.next();
        System.out.println("Apellido:");
        String apellido = sc.next();
        boolean empleadoEncontrado = false;
        for(Empleado emp: empleados){
            if(nombre.equals(emp.getNombre()) && apellido.equals(emp.getApellido())){
                System.out.println("Los datos del empleado que buscas son los siguientes");
                System.out.println(emp.toString()+"\n");
                empleadoEncontrado = true;

            }
        }
       if(empleadoEncontrado==false){
            System.out.println("El empleado no fue encontrado en la base de datos");
       }
    }

    public static void eliminarEmpleado(List<Empleado> empleados) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa los datos del empleado a buscar");
        System.out.println("Nombre:");
        String nombre = sc.next();
        System.out.println("Apellido:");
        String apellido = sc.next();
        int cont = 0;
        boolean empleadoEncontrado = false;
        for (Empleado emp : empleados) {
            if (nombre.equals(emp.getNombre()) && apellido.equals(emp.getApellido())) {
                empleados.remove(cont);
                System.out.println("Empleado eliminado de la base de datos");
                empleadoEncontrado = true;
                break;
            }
            cont++;
        }
        if (empleadoEncontrado == false) {
            System.out.println("El empleado no fue encontrado en la base de datos");
        }
    }



}
