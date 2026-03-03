package tarea05;

import java.util.Scanner; // ¡Faltaba esta línea!

public class Calculadora2 {

    public static void main(String[] args) {
        double num1, num2;

        Operaciones sumar = (n1, n2) -> (n1 + n2);
        Operaciones restar = (n1, n2) -> (n1 - n2);

        Scanner sc = new Scanner(System.in);
        System.out.println("Dame n1:");
        num1 = sc.nextDouble();
        System.out.println("Dame n2:");
        num2 = sc.nextDouble();

        System.out.println("La suma es: " + sumar.calcular(num1, num2));
        System.out.println("La resta es: " + restar.calcular(num1, num2));

        restar.metDefault();
        Operaciones.metEstatico();

        sc.close();
    }
}