package tarea05;

public interface Operaciones {
    double calcular(double n1, double n2);

    default void metDefault() {
        System.out.println("Soy un método default");
        metPrivado();
    }

    static void metEstatico() {
        System.out.println("Soy un método estático");
    }

    private void metPrivado() {
        System.out.println("Soy un método privado");
    }
}