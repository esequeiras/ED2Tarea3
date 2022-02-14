public class ArbolAVL {
    private NodoAVL raiz;

    public ArbolAVL(){
        this.raiz=null;
    }
    public int obtenerFE(NodoAVL nodo){
        if (nodo!=null){
            return -1;
        }else{
            return nodo.factorE;
        }

    }
    private NodoAVL insertarAVL(NodoAVL nuevo, NodoAVL subArbol){
        NodoAVL nuevoPadre=subArbol;
        if (nuevo.getDato()<subArbol.getDato()) {
            if (subArbol.getIzquierda() == null) {
                subArbol.setIzquierda(nuevo);
            } else {
                subArbol.setIzquierda(insertarAVL(nuevo, subArbol.getIzquierda()));
                //si esta desbalanceado
                if ((obtenerFE(subArbol.getIzquierda()) - obtenerFE(subArbol.getDerecha())) == 2) {
                    if (nuevo.getDato() < subArbol.getIzquierda().getDato()) {
                        nuevoPadre = rotacionIzquierda(subArbol);
                    }else{
                        nuevoPadre=rotacionDobleIzquierda(subArbol);
                    }
                }
            }

        }else if(nuevo.getDato()>subArbol.getDato()){
            if (subArbol.getDerecha() == null) {
                subArbol.setDerecha(nuevo);
            }else{
                subArbol.setIzquierda(insertarAVL(nuevo,subArbol.getDerecha()));
                if ((obtenerFE(subArbol.getDerecha()) - obtenerFE(subArbol.getIzquierda())) == 2){
                    if (nuevo.getDato() > subArbol.getDerecha().getDato()) {
                        nuevoPadre = rotacionderecha(subArbol);
                    }else{
                        nuevoPadre=rotacionDobleDerecha(subArbol);
                    }
                }
            }

        }
        //actualizar el FE
        if ((subArbol.getIzquierda()==null) && (subArbol.getDerecha()!=null)){
            subArbol.setFactorE(obtenerFE(subArbol.getDerecha())+1);
        }else if((subArbol.getDerecha()==null)&& (subArbol.getIzquierda()!=null)){
            subArbol.setFactorE(obtenerFE(subArbol.getIzquierda())+1);
        }else{
            subArbol.setFactorE(Math.max(obtenerFE(subArbol.getIzquierda()),obtenerFE(subArbol.getDerecha()))+1);
        }
        return nuevoPadre;
    }
    public void insertar(int dato){
        NodoAVL nuevo= new NodoAVL(dato);
        if (this.raiz==null){
            this.raiz=nuevo;
        }else{
            this.raiz=insertarAVL(nuevo,raiz);
        }
    }

    private void preorden(NodoAVL n) {
        if (n != null) {
            imprimirDato(n);
            preorden(n.getIzquierda());
            preorden(n.getDerecha());
        }
    }

    private void inorden(NodoAVL n) {
        if (n != null) {
            inorden(n.getIzquierda());
            imprimirDato(n);
            inorden(n.getDerecha());
        }
    }

    private void postorden(NodoAVL n) {
        if (n != null) {
            postorden(n.getIzquierda());
            postorden(n.getDerecha());
            imprimirDato(n);
        }
    }
    public void imprimirDato(NodoAVL n) {
        System.out.print(n.getDato()+", ");
    }
    public void preorden() {
        this.preorden(this.raiz);
    }

    public void inorden() {
        this.inorden(this.raiz);
    }

    public void postorden() {
        this.postorden(this.raiz);
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
       nodo.setFactorE(Math.max(obtenerFE(nodo.getIzquierda()),obtenerFE(nodo.getDerecha()))+1);
       aux.setFactorE(Math.max(obtenerFE(aux.getIzquierda()),obtenerFE(aux.getDerecha()))+1);
       return aux;
    }
    public NodoAVL rotacionderecha(NodoAVL nodo){
        NodoAVL aux=nodo.getDerecha();
        nodo.setDerecha(aux.getIzquierda());
        aux.setIzquierda(nodo);
        nodo.setFactorE(Math.max(obtenerFE(nodo.getIzquierda()),obtenerFE(nodo.getDerecha()))+1);
        aux.setFactorE(Math.max(obtenerFE(aux.getIzquierda()),obtenerFE(aux.getDerecha()))+1);
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
