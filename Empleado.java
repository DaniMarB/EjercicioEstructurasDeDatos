package TallerClase210723.EmpleadosDptos;

public class Empleado {
    public String nombre;
    public String apellido;
    public int edad;
    public String departamento;

    public Empleado(String nombre, String apellido, int edad, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "Nombre completo: " + nombre+" "+ apellido+" "+
                "Edad: " + edad +" "+
                "Departamento: " + departamento;
    }
}
