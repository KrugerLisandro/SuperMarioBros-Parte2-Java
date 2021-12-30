package supermariobros;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int aletL = (int) (Math.random() * (50 - (-50) + 1) + (-50));
        int aletP = (int) (Math.random() * (50 - (-50) + 1) + (-50));

        System.out.println("aletL: " + aletL + ", aletP: " + aletP); //Para prueba 

        Aldeano Mario = new Aldeano("Mario", "rojo", "azul", "rojo", 'M');
        Aldeano Luigi = new Aldeano("Luigi", "verde", "azul", "verde", 'L',aletL, 0, "Derecha");
        Aldeano Peach = new Aldeano("Princesa Peach", "violeta", "amarillo", "violeta", ' ',aletP, 0, "Derecha");
        Oraculo Whallum = new Oraculo("Whallum");

        //Nivel 1. Mario y Luigi tienen que encontrarse.
        elEncuentro(Mario, Luigi);
        System.out.println();

        //Nivel 2 - Etapa1. Hablar con el Oraculo.
        boolean result = dondeEstaPrincesaPeach(Mario, Luigi, Whallum, Peach);
        System.out.println();

        //Nivel 2 - Etapa 2. Mario y Luigi van a rescatar a la Princesa Peach.1
        if (result == false) {
            System.out.println("No. GAME OVER !");
        } else {
            System.out.println("Si." + "\n");
            carreraDePretendientes(Mario, Luigi, Peach);
        }
    }

    public static void elEncuentro(Aldeano Mario, Aldeano Luigi) {
        System.out.println(Mario.mostrarUbicacion());
        System.out.println(Luigi.mostrarUbicacion());

        if (Mario.getEjeX() > Luigi.getEjeX()) { 
            Mario.girar();
            System.out.println(Mario.mostrarUbicacion());
        }else if (Mario.getEjeX() <= Luigi.getEjeX()) { 
            Luigi.girar();
            System.out.println(Luigi.mostrarUbicacion());
        }
        while (Mario.getEjeX() != Luigi.getEjeX()) {
            Mario.moverse();
            System.out.println(Mario.mostrarUbicacion());
            if (Mario.getEjeX() != Luigi.getEjeX()) {
                Luigi.moverse();
                System.out.println(Luigi.mostrarUbicacion());
            }
        }

        System.out.println(Mario.getNombre() + " y " + Luigi.getNombre() + " se encontraron !");
        System.out.println(Mario.saludar());
        System.out.println(Luigi.saludar());
    }

    public static boolean dondeEstaPrincesaPeach(Aldeano Mario, Aldeano Luigi, Oraculo Whallum, Aldeano Peach) {
        Scanner leer = new Scanner(System.in);
        int elegir, opc, num;
        boolean fin = false, resp = false, salir = true;
        do {
            System.out.println("Jugar (1)Mario - (2)Luigi");
            elegir = leer.nextInt();
            switch (elegir) {
                case 1:
                    System.out.println(Mario.toString() + "\n");
                    fin = true;
                    break;
                case 2:
                    System.out.println(Luigi.toString() + "\n");
                    fin = true;
                    break;
                default:
                    System.out.println("Error: Elija de nuevo");
                    break;
            }
        } while (fin != true);

        do {
            System.out.println("Oraculo Whallum, te tengo que hacer una pregunta "
                    + "sobre la ubicacion de la Princesa Peach:");
            System.out.println("1.- Posicion de Princesa Peach mayor que ... \n"
                    + "2.- Posicion de Princesa Peach menor que ... \n"
                    + "3.- Te arriegas al valor ...");

            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.print("... ");
                    num = leer.nextByte();
                    System.out.println(Whallum.responder(Peach, opc, num));
                    break;
                case 2:
                    System.out.print("... ");
                    num = leer.nextInt();
                    System.out.println(Whallum.responder(Peach, opc, num));
                    break;
                case 3:
                    System.out.print("... ");
                    num = leer.nextInt();
                    if ("No".equals(Whallum.responder(Peach, opc, num))) {
                        salir = false;
                    }
                    resp = true;
                    break;
                default:
                    System.out.println("Opcion no valida !");
                    break;
            }
        } while (resp != true);
        return salir;
    }

    public static void carreraDePretendientes(Aldeano Mario, Aldeano Luigi, Aldeano Peach) {
        int florM = 0, florL = 0, absM, absL;
        System.out.println(Mario.mostrarUbicacion());
        System.out.println(Luigi.mostrarUbicacion());
        System.out.println(Peach.mostrarUbicacion());

        if (Peach.getEjeX() > Mario.getEjeX() && "Izquierda".equals(Mario.getOrientacion())) {
            Peach.girar();
            Mario.girar();
        } else if (Peach.getEjeX() > Luigi.getEjeX() && "Izquierda".equals(Luigi.getOrientacion())) {
            Peach.girar();
            Luigi.girar();
        } else if (Peach.getEjeX() < Mario.getEjeX() && "Derecha".equals(Mario.getOrientacion())) {
            Mario.girar();
        } else if (Peach.getEjeX() < Luigi.getEjeX() && "Derecha".equals(Luigi.getOrientacion())) {
            Luigi.girar();
        }

        System.out.println(Mario.mostrarUbicacion());
        System.out.println(Luigi.mostrarUbicacion());
        System.out.println(Peach.mostrarUbicacion());

        while (Mario.getEjeX() != Peach.getEjeX() && Luigi.getEjeX() != Peach.getEjeX()) {
            Mario.moverse();
            Luigi.moverse();
            absM = Math.abs(Mario.getEjeX());
            absL = Math.abs(Luigi.getEjeX());
            if ((absM % 2 == 0) && (absM % 7 == 0)) {
                florM++;
            } else if ((absL % 3 == 0) && (absL % 5 == 0)) {
                florL++;
            }
            System.out.println(Mario.mostrarUbicacion());
            System.out.println(Luigi.mostrarUbicacion());

        }
        System.out.println(Peach.mostrarUbicacion());

        System.out.println("Flores de Mario: " + florM + " - Flores de Luigi: " + florL);
        if (florM == florL) {
            System.out.println("La princesa lanzara un Moneda para decidir a quien elegira" + "\n");
            if ("Cruz".equals(Peach.lanzarMoneda())) {
                System.out.println("Cruz! La princesa Peach elige a Mario.");
            } else {
                System.out.println("Cara! La princesa Peach elige a Luigi.");
            }
        } else if (florM > florL) {
            System.out.println("La princesa Peach elige a Mario !");
        } else if (florM < florL) {
            System.out.println("La princesa Peach elige a Luigi !");
        }
    }
}
