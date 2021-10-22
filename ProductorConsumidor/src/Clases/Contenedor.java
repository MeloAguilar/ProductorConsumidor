package Clases;

public class Contenedor<T> {
    private T dato;

    synchronized public T get(){
        T resultado = this.dato;
        this.dato = null;
        return resultado;
    }

    synchronized public void put(T valor){
        this.dato = valor;
    }

    synchronized boolean datoDisponible(){
        return (this.dato != null);
    }
}
