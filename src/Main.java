import java.io.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    //static Gestor gestor=new Gestor();
    public static void main(String[] args) throws IOException {
        int op=0;
        ArbolAVL arbol=new ArbolAVL();
        arbol.insertar(3);
        arbol.insertar(2);
        arbol.insertar(1);
        out.println("Recorriendo intorden...");
        arbol.inorden();
        out.println("Recorriendo preorden...");
        arbol.preorden();
        out.println("Recorriendo postorden...");
        arbol.postorden();


        do{
            mostarMenu();
            op=Integer.parseInt(in.readLine());
            switch (op){
                case 1:
                    out.print("Ingrese un número: ");
                    //gestor.insertar(Integer.parseInt(in.readLine()));
                    break;
                case 2:
                    out.println("Recorriendo preorden...");
                    //gestor.preorden();
                    break;
                case 3:
                    out.println("Recorriendo inorden...");
                    //gestor.inorden();
                    break;
                case 4:
                    out.println("Recorriendo postorden...");
                   // gestor.postorden();
                    break;
                default:
                    out.println("Opcion invalida intente de nuevo");
                    break;
            }

        }while (op!=0);

    }
    public static void mostarMenu(){
        out.println("---------");
        out.println("   Menú  ");
        out.println("---------");

        out.println("1 Ingresar dato");
        out.println("2 Mostrar Pre-Orden");
        out.println("3 Mostrar In-Orden");
        out.println("4 Mostrar Post-Orden");
        out.println("0 Salir");
        out.println("Seleccione una opcion del menú:");


    }

}

