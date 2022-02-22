package bl;

public class NodoAVL {
    /**
     * Dato contenido en el nodo.
     */
    private int dato;

    /**
     * Nodo hijo izquierda.
     */
    private NodoAVL izquierda;

    /**
     * Nodo hijo derecha.
     */
    private NodoAVL derecha;

    /**
     * Factor de equilibrio del nodo.
     */
    public int factorE;

    /**
     * constructor por defecto.
     */
    public NodoAVL(){
        dato = 0;
        izquierda = null;
        derecha = null;
        factorE = 0;
    }

    /**
     * Constructor con un parametro.
     * @param dato que contendra el nodo.
     */
    public NodoAVL(int dato){
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
        this.factorE = 0;
    }

    /**
     * Devuelve el nodo a la izquierda del actual.
     * @return nodo hijo izquierdo.
     */
    public NodoAVL getIzquierda(){
        return izquierda;
    }
    /**
     * Devuelve el nodo a la derecha del actual.
     * @return nodo hijo derecho.
     */
    public NodoAVL getDerecha(){
        return derecha;
    }

    /**
     * Devuelve el dato contenido en el nodo.
     * @return dato contenido en el nodo.
     */
    public int getDato(){
        return dato;
    }

    /**
     * Asigna un nodo al hijo derecho del nodo.
     * @param derecha dato a insertar.
     */
    public void setDerecha(NodoAVL derecha){
        this.derecha = derecha;
    }

    /**
     * Asigna un nodo al hijo izquierdo del nodo.
     * @param izquierda dato a insertar.
     */
    public void setIzquierda(NodoAVL izquierda){
        this.izquierda = izquierda;
    }

    /**
     * Asigna un dato al nodo.
     * @param dato dato a insertar en el nodo.
     */
    public void setDato(int dato){
        this.dato = dato;
    }

    /**
     * Obtiene el factor de equilibrio del nodo.
     * @return factor de equilibrio del nodo.
     */
    public int getFactorE(){
        int altDer = 0;
        int altIzq = 0;
        if(this.getDerecha()!=null){
            altDer = this.getDerecha().getAltura();
        }
        if(this.getIzquierda()!=null){
            altIzq = this.getIzquierda().getAltura();
        }
        return (altDer - altIzq);

    }


    /**
     * Asigna un valor al factor de equilibrio.
     * @param fe factor de equilibro para asignar al nodo.
     */
    public void setFactorE(int fe){
        this.factorE = fe;
    }

    /**
     * Devuelve la altura del nodo.
     * @return altura del nodo.
     */
    public int getAltura(){
        int hIzq = 0;
        int hDer = 0;

        if(this.getDato()==0){
            return 0;
        }


        if(this.getIzquierda()!=null){
            hIzq = this.getIzquierda().getAltura();
        }else{
            hIzq = 0;
        }

        if(this.getDerecha()!=null){
            hDer = this.getDerecha().getAltura();
        }else{
            hDer = 0;
        }
        return Math.max(hIzq, hDer) + 1;
    }
}

