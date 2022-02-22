package tl;

import bl.ArbolAVL;

public class Gestor {

    private ArbolAVL arbol;

    public Gestor() {
        arbol=new ArbolAVL();
    }

    public void insertar(int dato) {
        arbol.insertar(dato);
    }

    public void preorden() {
        arbol.preorden();
    }

    public void inorden() {
        arbol.inorden();
    }

    public void postorden() {
        arbol.postorden();
    }
}
