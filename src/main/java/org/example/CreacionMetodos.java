package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;


public class CreacionMetodos {
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

                    while(true) {
                        nombre = scannerString();
                        break;
                    }
                    while(true) {
                        Estadocivil = scannerString();
                        break;
                    }
                    while(true) {
                        edad = scannerString();
                        break;
                    }

                    registro[indiceDisponible][0] = nombre;
                    registro[indiceDisponible][1] = Estadocivil;
                    registro[indiceDisponible][2] = edad;
                    System.out.println("Persona agregada.");
                } else {
                    System.out.println("No hay cupo.");
                }

            } else if(opcion == 2) {
                int mayoresDeEdad = 0;

                for (String [] persona : registro) {
                    if (Integer.parseInt(persona[2]) >= 18) mayoresDeEdad++;
                }

                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
            } else if(opcion == 3) {
                int menoresDeEdad = 0;
                int queSera = obtenerUltimoEspacio(registro);

                for (int i = 0; i < queSera; i++) {
                    if (Integer.parseInt(registro[i][2]) < 18) menoresDeEdad++;
                }

                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
            } else if(opcion == 4) {
                int terceraEdad = 0;

                for (String [] persona : registro) {
                    if (Integer.parseInt(persona[2]) >= 60 && persona[1].equals("casado/a")) {
                        terceraEdad++;
                    } else if(Integer.parseInt(persona[2]) >= 65 && persona[1].equals("soltero/a")) {
                        terceraEdad++;
                    }
                }
                System.out.println("Hay " + terceraEdad + " personas de tercera edad");
            } else if(opcion == 5) {
                int c = 0;
                int d = 0;
                for(String[] persona : registro) {
                    if(persona[1].equals("casado/a")) {
                        c++;
                    } else if(persona[1].equals("soltero/a")) {
                        d++;
                    }
                }
                System.out.println("Hay " + d + " casados/as.");
                System.out.println("Hay " + c + " solteros/as.");
            } else if(opcion == 6) {
                System.out.println("Programa finalizado");
            }
        }while (opcion == 6);
    }




    public static int obtenerUltimoEspacio(String [][] registro) {
        return registro.length - nombreVacio(registro);
    }




    public static boolean hayCupo(String [][] registro) {
        return !(nombreVacio(registro) == 0);
    }

    public static int nombreVacio(String [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0].isEmpty()){
                return registro.length - i;
            }
        }
        return 0;
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
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Opción inválida");
            return -1;
        }
    }
    private static String scannerString(){
        while(true) {
            try {
                return new Scanner(System.in).nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
                continue;
            }
        }
    }
}