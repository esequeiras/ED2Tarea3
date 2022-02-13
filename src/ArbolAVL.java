public class ArbolAVL {
    private NodoAVL raiz;

    public ArbolAVL(){
        this.raiz=null;
    }

    public NodoAVL insertar(NodoAVL nuevo, NodoAVL subArbol){
        NodoAVL nuevoPadre=subArbol;
        if (nuevo.getDato()<subArbol.getDato()) {
            if (subArbol.getIzquierda() == null) {
                subArbol.setIzquierda(nuevo);
            } else {
                subArbol.setIzquierda(insertar(nuevo, subArbol.getIzquierda()));
                //si esta desbalanceado
                if ((subArbol.getIzquierda().getFactorE() - subArbol.getDerecha().getFactorE()) == 2) {
                    if (nuevo.getDato() < subArbol.getIzquierda().getDato()) {
                        nuevoPadre = rotacionDobleIzquierda(subArbol);
                    }else{
                        nuevoPadre=rotacionDobleDerecha(subArbol);
                    }
                }
            }//minuto 6   https://www.youtube.com/watch?v=HFp7zBVgrKA

        }
    }
    /**
     *
     * @param nodo
     * @return
     */
    public NodoAVL rotacionIzquierda(NodoAVL nodo){
       NodoAVL aux=nodo.getIzquierda();
      nodo.setIzquierda(aux.getDerecha());
      aux.setDerecha(nodo);
       nodo.setFactorE(Math.max(nodo.getIzquierda().getFactorE(),nodo.getDerecha().getFactorE())+1);
       aux.setFactorE(Math.max(aux.getIzquierda().getFactorE(),aux.getDerecha().getFactorE())+1);
       return aux;
    }
    public NodoAVL rotacionderecha(NodoAVL nodo){
        NodoAVL aux=nodo.getDerecha();
        nodo.setDerecha(aux.getIzquierda());
        aux.setIzquierda(nodo);
        nodo.setFactorE(Math.max(nodo.getIzquierda().getFactorE(),nodo.getDerecha().getFactorE())+1);
        aux.setFactorE(Math.max(aux.getIzquierda().getFactorE(),aux.getDerecha().getFactorE())+1);
        return aux;
    }
    public NodoAVL rotacionDobleDerecha(NodoAVL nodo){
        NodoAVL aux;
        nodo.setIzquierda(rotacionderecha(nodo.getIzquierda()));
        aux=rotacionIzquierda(nodo);
        return aux;
    }
    public NodoAVL rotacionDobleIzquierda(NodoAVL nodo){
        NodoAVL aux;
        nodo.setDerecha(rotacionIzquierda(nodo.getIzquierda()));
        aux=rotacionderecha(nodo);
        return aux;
    }
}
