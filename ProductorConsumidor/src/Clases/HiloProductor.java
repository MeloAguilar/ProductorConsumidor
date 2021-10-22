package Clases;

import java.sql.SQLOutput;

public class HiloProductor implements Runnable{

    final Contenedor<Integer> cont;
    String miNombre;

    public HiloProductor(Contenedor<Integer> cont, String nombre) {
        this.cont = cont;
        this.miNombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 0; ; i++) {
            synchronized (this.cont){
                while(this.cont.datoDisponible()){
                    try{
                        this.cont.wait();
                    }catch(InterruptedException e){
                        //Se cerraria el programa
                    }
                }
                System.out.printf("Hilo %s produce valor %s.\n",
                        this.miNombre,i);
                this.cont.put(i);
                this.cont.notifyAll();
            }
        }
    }
}
