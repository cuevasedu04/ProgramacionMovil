package tarea07;

public class Prueba {

    public static void main(String[] args) {
        Granja g = new Granja();
        Perro snopy = new Perro();
        Gato garfield = new Gato();
        Pato donald = new Pato();
        g.hacerLadrar(snopy);
        g.hacerMaullar(garfield);
        g.hacerGraznear(donald);
    }

}