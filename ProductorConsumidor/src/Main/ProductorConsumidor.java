package Main;

import Clases.Contenedor;
import Clases.HiloConsumidor;
import Clases.HiloProductor;

public class ProductorConsumidor {
    public static void main(String[] args) {
        Contenedor<Integer> almacen = new Contenedor<Integer>();
        Thread hiloProd = new Thread(new HiloProductor(almacen, "P"));
        Thread hiloCons = new Thread(new HiloConsumidor(almacen, "C"));
        Thread hiloProd2 = new Thread(new HiloProductor(almacen, "P2"));
        Thread hiloCons2 = new Thread(new HiloConsumidor(almacen, "C2"));

        hiloProd.start();
        hiloProd2.start();
        hiloCons.start();
        hiloCons2.start();

    }
}
