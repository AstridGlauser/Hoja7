
//Astrid Glauser 21299
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;

public class OpA {
    public static void main(String args[]) {

        Arbol arbolbin = new Arbol();
        String nombrearc = "";
        String nombrearc1 = "";
        ArrayList<String> textog = new ArrayList<>();
        ArrayList<String> imprimir = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        ArrayList<ArrayList<String>> dicci = new ArrayList<ArrayList<String>>();
        boolean OpcionesMenu = false;
        String lineas = "";
        String lineas2 = "";

        try {
            System.out.println("Ingrese la direecion del diccionario");
            nombrearc = s.nextLine();
            File infa = new File(nombrearc);
            Scanner readerFromFile = new Scanner(infa);

            while (readerFromFile.hasNextLine()) {
                lineas = readerFromFile.nextLine();
                String[] palabras = lineas.split(",");// separa segun las comas para agregar
                ArrayList<String> arraypalabras = new ArrayList<>();

                // ciclo para agregar las palabras
                for (int i = 0; i < palabras.length; i++) {
                    arraypalabras.add(palabras[i]);
                    String keyIngles = palabras[0];// se toma como key
                    String valueIngles = "Ingles: " + palabras[0] + "\nEspanol: " + palabras[1] + "\nFrances: "
                            + palabras[2];
                    Association<String, String> asociac = new Association<String, String>(keyIngles, valueIngles);
                    System.out.println(asociac);// imprime segun correponde tomando como key la palabra en ingles
                }
                dicci.add(arraypalabras);// agrega las palabras en arrays , separados por palabras en cada idioma
            }
        } catch (Exception e) {
            System.out.println("ERROR");// captura excepcion

        }

        while (OpcionesMenu == false) {// opciones del menu

            for (ArrayList<String> BusquedaPalabras : dicci) {
                arbolbin.insertar(BusquedaPalabras);// inserta cada array al arbol binario
            }

            System.out.println("Ingresa la opcion correspondiente");
            System.out.println("1.Traducir");
            System.out.println("2.Eliminar");
            System.out.println("3.Insertar");
            System.out.println("4.Modificar");
            System.out.println("5.Eliminar");
            System.out.println(dicci);

            int opcion = s.nextInt();

            if (opcion == 1) {

                try {
                    System.out.println("Ingrese el nombre del archivo que deseas traducir");
                    nombrearc1 = s.nextLine();
                    File infa = new File(nombrearc1);
                    Scanner readerFromFile = new Scanner(infa);

                    while (readerFromFile.hasNextLine()) {

                        lineas2 = readerFromFile.nextLine();
                        System.out.println(lineas2);
                        String[] palabras2 = lineas2.split(" ");

                        // se agregan las palabras con separacion
                        for (int i = 0; i < palabras2.length; i++) {
                            textog.add(palabras2[i]);
                        }

                    }
                } catch (Exception e) {
                    System.out.println("ERROR");
                }

                System.out.println("Selecciona el lenguaje");
                System.out.println("1.Ingles");
                System.out.println("2.Espanol");
                System.out.println("3.Frances");
                int lenguajeelegido = s.nextInt();

                switch (lenguajeelegido) {
                    // ingles

                    case 1:
                        imprimir.clear();
                        for (int i = 0; i < dicci.size(); i++) {
                            for (int j = 0; j < textog.size(); j++) {
                                if (dicci.get(i).contains(textog.get(j))) {
                                    textog.set(j, dicci.get(i).get(0));
                                    imprimir.add(dicci.get(i).get(0));
                                }
                            }
                        }
                        break;

                    // espanol
                    case 2:
                        imprimir.clear();
                        for (int i = 0; i < dicci.size(); i++) {
                            for (int j = 0; j < textog.size(); j++) {
                                if (dicci.get(i).contains(textog.get(j))) {
                                    textog.set(j, dicci.get(i).get(1));
                                    imprimir.add(dicci.get(i).get(1));
                                }

                            }
                        }
                        break;

                    // frances
                    case 3:
                        imprimir.clear();// se limpia el array
                        for (int i = 0; i < dicci.size(); i++) {
                            for (int j = 0; j < textog.size(); j++) {
                                if (dicci.get(i).contains(textog.get(j))) {
                                    textog.set(j, dicci.get(i).get(2));
                                    imprimir.add(dicci.get(i).get(2));
                                }

                            }
                        }
                        break;

                    default:
                        System.out.println("ERROR");
                        break;
                }

                // se muestra el texto
                System.out.println("Texto traducido");

                String exp = "";
                textog.set(textog.size() - 1, (textog.get(textog.size() - 1)));

                // agrega o no *
                for (int i = 0; i < textog.size(); i++) {
                    if (imprimir.contains(textog.get(i))) {
                        exp += (textog.get(i) + " ");
                    } else {
                        exp += ("*" + textog.get(i) + "*" + " ");
                    }

                }

                System.out.println(exp);

            }

            // finalizacion
            else {
                OpcionesMenu = true;
                System.out.println("ADIOS");
            }

        }

    }
}