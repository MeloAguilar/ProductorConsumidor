package Clases;

public class HiloConsumidor implements Runnable{

    final Contenedor<Integer> cont;
    String miNombre;

    public HiloConsumidor(Contenedor<Integer> cont, String miNombre){
        this.cont = cont;
        this.miNombre = miNombre;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (this.cont){
                while(!this.cont.datoDisponible()){
                    try{
                        this.cont.wait();
                    }catch(InterruptedException e){
                        //No hace nada
                    }
                }
                Integer dato = this.cont.get();
                this.cont.notifyAll();
                System.out.printf("Hilo %s consume %d.\n",
                        this.miNombre, dato);
            }
        }
    }
}
