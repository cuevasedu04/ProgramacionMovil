package tarea07.sinInterfaces;

public class Prueba {

    public static void main(String[] args) {
        Granja g = new Granja();
        Perro snopy = new Perro();
        Gato garfield = new Gato();
        Pato donald = new Pato();
        g.hacerSonido(snopy);
        g.hacerSonido(garfield);
        g.hacerSonido(donald);

        Grillo pepe = new Grillo();
        g.hacerSonido(pepe);
    }

}