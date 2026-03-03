package tarea02;

public class Persona {
    String nombre;
    int edad;

    public Persona() {
        nombre = "brenda";
        edad = 18;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }
}
