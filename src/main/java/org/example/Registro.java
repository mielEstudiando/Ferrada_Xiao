package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Registro {
    public static void main(String[] args) {
        String [][] registro = new String[50][3];
        int opcion = -1;

        do {
            menuEleccion();
            do {
                opcion = scannerInt();
            }while (opcion < 0 || opcion > 6);

            if(opcion == 1) {
                if(hayCupo(registro)) {
                    int indiceDisponible = obtenerUltimoEspacio(registro);
                    String nombre;
                    String Estadocivil;
                    String edad;

                        nombre = scannerString();

                        Estadocivil = scannerString();

                        edad = String.valueOf(scannerInt());

                    registro[indiceDisponible][0] = nombre;
                    registro[indiceDisponible][1] = Estadocivil;
                    registro[indiceDisponible][2] = edad;
                    System.out.println("Persona agregada.");
                } else {
                    System.out.println("No hay cupo.");
                }

            } else if(opcion == 2) {
                int mayoresDeEdad = 0;

                if (nombreVacio(registro)!=50){
                    for (String [] persona : registro) {
                        if (persona[2]!=null){
                            if (Integer.parseInt(persona[2]) >= 18) mayoresDeEdad++;
                        }
                    }
                }


                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
            } else if(opcion == 3) {
                int menoresDeEdad = 0;
                int queSera = obtenerUltimoEspacio(registro);

                if (nombreVacio(registro)!=50){
                    for (int i = 0; i < queSera; i++) {
                        if (registro[i][2]!=null){
                            if (Integer.parseInt(registro[i][2]) < 18) menoresDeEdad++;
                        }
                    }
                }

                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
            } else if(opcion == 4) {
                int terceraEdad = 0;

                if (nombreVacio(registro)!=50){
                    for (String [] persona : registro) {
                        if (persona[2]!=null){
                            if (Integer.parseInt(persona[2]) >= 60 && persona[1].equals("casado/a")) {
                                terceraEdad++;
                            } else if(Integer.parseInt(persona[2]) >= 65 && persona[1].equals("soltero/a")) {
                                terceraEdad++;
                            }
                        }
                    }
                }
                System.out.println("Hay " + terceraEdad + " personas de tercera edad");
            } else if(opcion == 5) {
                int casados = 0;
                int solteros = 0;

                if (nombreVacio(registro)!=50){
                    for(String[] persona : registro) {
                        if (persona[2]!=null){
                            if(persona[1].equals("casado/a")) {
                                casados++;
                            } else if(persona[1].equals("soltero/a")) {
                                solteros++;
                            }
                        }
                    }
                }
                System.out.println("Hay " + casados + " casados/as.");
                System.out.println("Hay " + solteros + " solteros/as.");
            } else if(opcion == 6) {
                System.out.println("Programa finalizado");
            }
        }while (opcion != 6);
    }




    public static int obtenerUltimoEspacio(String [][] registro) {

        return registro.length - nombreVacio(registro);
    }




    public static boolean hayCupo(String [][] registro) {
        return (nombreVacio(registro) == 50);
    }

    public static int nombreVacio(String [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0]==null){
                return registro.length - i;
            }
        }
        return 50;
    }

    private static void menuEleccion(){
        System.out.println("""
                Menú
                1) Agregar persona.
                2) Mostrar la cantidad de personas mayores de edad.
                3) Mostrar la cantidad de personas menores de edad.
                4) Mostrar la cantidad de personas de tercera edad.
                5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                6)Salir.
                """);
    }
    private static int scannerInt(){
        while(true){
            try {
                int numero = new Scanner(System.in).nextInt();
                if (numero>=0) return numero;
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }
        }
    }
    private static String scannerString(){
        while(true) {
            try {
                return new Scanner(System.in).nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }
        }
    }
}