package tarea05;

public class Calculadora {

    // Métodos de instancia
    public double sumar(double n1, double n2) {
        return n1 + n2;
    }

    public double restar(double n1, double n2) {
        return n1 - n2;
    }

    // Métodos estáticos
    public static double multiplicar(double n1, double n2) {
        return n1 * n2;
    }

    public static double dividir(double n1, double n2) {
        if (n2 == 0) {
            System.out.println("Error: No se puede dividir entre cero");
            return 0;
        }
        return n1 / n2;
    }

    public static void main(String[] args) {
        Calculadora c = new Calculadora();

        System.out.println("Suma: " + c.sumar(5.5, 3));
        System.out.println("Resta: " + c.restar(5, 2));
        System.out.println("Multiplicación: " + Calculadora.multiplicar(2, 3.5));
        System.out.println("División: " + Calculadora.dividir(10, 2));
    }
}