package ui;

import tl.Gestor;

import java.io.*;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;
    static Gestor gestor=new Gestor();
    public static void main(String[] args) throws IOException {
        int op;


        do{
            mostarMenu();
            op=Integer.parseInt(in.readLine());
            switch (op){
                case 1:
                    out.print("Ingrese un número: ");
                    gestor.insertar(Integer.parseInt(in.readLine()));
                    break;
                case 2:
                    out.println("Recorriendo preorden...");
                    gestor.preorden();
                    break;
                case 3:
                    out.println("Recorriendo inorden...");
                    gestor.inorden();
                    break;
                case 4:
                    out.println("Recorriendo postorden...");
                    gestor.postorden();
                    break;
                case 5:
                    out.println("Ingresando Datos...7, 14, 28, 5, 9, 8, 21, 3, 15, 24, 100 y 1");
                    gestor.insertar(7);
                    gestor.insertar(14);
                    gestor.insertar(28);
                    gestor.insertar(5);
                    gestor.insertar(9);
                    gestor.insertar(8);
                    gestor.insertar(21);
                    gestor.insertar(3);
                    gestor.insertar(15);
                    gestor.insertar(24);
                    gestor.insertar(100);
                    gestor.insertar(1);
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
        out.println("5 Ingresar datos  propuestos");
        out.println("0 Salir");
        out.println("Seleccione una opcion del menú:");


    }

}

