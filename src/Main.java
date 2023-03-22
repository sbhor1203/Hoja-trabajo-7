import java.util.Scanner;
/**
 * @author Audrey Bhor
 *  
 */

public class Main {

	
    /** 
     * @param args
     */
    public static void main(String[] args) {

		Diccionario dic = new Diccionario();

        Scanner teclado = new Scanner(System.in);

        Scanner entry = new Scanner(System.in);

        System.out.println("Bienvenido al programa diccionario, en el cual podrá leer palabras y traducirlas a otro idioma con ayuda de un diccionario de las mismas en un archivo de texto");
        String menu = "\n--------------------------------------------------------\n| Seleccione alguna de las siguientes opciones:        |\n| (1) Ordenamiento Arboles                             |\n| (2) Traducir una palabra                             |\n| (3) Traducción de un archivo                         |\n| (4) Salir                                            |\n|-------------------------------------------------------\nOpcion a elegir: ";
        System.out.println(menu);
        int op = teclado.nextInt();
        teclado.nextLine();
       

        while(op != 4){

            switch(op){
                case 1:{
                    System.out.print("\nLenguajes disponibles en el diccionario:\n1. Inglés\n2. Español\n3. Frances\n");
                    int language = verificacion("Seleccione el numero del diccionario que desea que se depliegue (ordenado por idioma): ", 1, 3);
                    System.out.print("\nDiccionario ordenado: \n");
                    System.out.print("");
                    
	                dic.viewTree(language);
                    break;
                }
                case 2:{
                    System.out.println("Bienvenido a traducción de palabras ");
                    System.out.println("Por favor ingrese la palabra que desea traducir: ");
                    String word = entry.nextLine();
                    int lengubase = verificacion("Seleccione el número del idioma en el que escribió la palabra:\nOpciones:\n1. English\n2. Spanish\n3. French\n", 1, 3);
                    int to = verificacion("Seleccione a que lenguaje la quiere traducir:\nOpciones:\n1. English\n2. Spanish\n3. French\n", 1, 3);
                    String traduc = dic.traducir(word.toLowerCase(), lengubase, to); 
                    if(traduc != null) {
                        System.out.println("\n La palabra "+word+" traducida es : " + traduc + "\n");
                    }else {
                        System.out.println("\nLa palabra no se encuentra en el diccionario \n");
                    }
                    
                    break;
                }
                case 3:{

                    System.out.print("Bienvenido a traducción de archivos");
                    int from = verificacion("Seleccione el numero del lenguaje en que se encuentra escrito el archivo:\nOpciones:\n1. English\n2. Spanish\n3. French\n", 1, 3);
                    int to = verificacion("Seleccione a que lenguaje al que se requiere traducir:\nOpciones:\n1. English\n2. Spanish\n3. French\n", 1, 3);
                    String lenguabase = dic.traducirArchivo(from, to); 
                    if(lenguabase != null) {
                        System.out.println("\n El contenido del archivo traducido es: " + lenguabase + "\n");
                    }else {
                        System.out.println("\n Error de escritura\n");
                    }

                    break;
                }
                case 4:{
                    System.out.print("Gracias por utilizar este programa!");
                    break;
                
                }

                    
            }
            System.out.println(menu);
            op = teclado.nextInt();
            teclado.nextLine();
        }

    }

    private static int verificacion(String texto, int min, int max){
        Scanner teclado = new Scanner(System.in);
        String entrada="";
        boolean bandera = true;
        int num = 0;
        
        do{
        	System.out.print(texto);
            entrada = teclado.nextLine();
            try{
                num = Integer.parseInt(entrada);
                if(num < min || num > max) {
                	System.out.println("Error, por favor ingrese un número que esté dentro del menú");
                    bandera = false;
                }else {
                    bandera = true;
                }
            }
            catch(Exception e){
                System.out.println(entrada + "Error de escritura, solo se aceptan números");
                bandera = false;
            }
        }while (!bandera); 
        
        return num;
    }
}
