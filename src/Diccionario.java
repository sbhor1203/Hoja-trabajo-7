import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Audrey Bhor
 *  
 */

public class Diccionario {

    ArbolBinario arboling = new ArbolBinario();
	ArbolBinario arbolespan = new ArbolBinario();
	ArbolBinario arbolfran = new ArbolBinario();
	
	//Constructor
	public Diccionario() {
		createBinaryTree();
	}

	
	
	public void createBinaryTree() {
		

		String texto = new String();

		try {
			FileReader fr = new FileReader("./documentos/words.txt");
			BufferedReader entrada = new BufferedReader(fr); 
			String s;

			while((s = entrada.readLine()) != null) {
				s= s.toLowerCase();
				crearNodo(s, "español");
				crearNodo(s, "ingles");
				crearNodo(s, "frances");
			}
		}
		catch(java.io.FileNotFoundException fnfex) {
			System.out.println("Archivo no encontrado: " + fnfex);}
		catch(java.io.IOException ioex) {}
	}

	
	public void crearNodo(String s, String language) {
		String[] temp = s.split(",");
		Traduccion t = new Traduccion();
		
		t.setEnglish(temp[0]);
		t.setSpanish(temp[1]);
		t.setFrench(temp[2]);
		switch(language) {
		case "español":
			arbolespan.addNodo(temp[1], t);
			break;
		case "ingles":
			arboling.addNodo(temp[0], t);
			break;
		case "frances":
			arbolfran.addNodo(temp[2], t);
			break;
		}
	}
	
	
	public void viewTree(int language) {
		
		switch(language) {
		case 2:
			arbolespan.inOrder(arbolespan.root);
			break;
		case 1:
			arboling.inOrder(arboling.root);
			break;
		case 3:
			arbolfran.inOrder(arbolfran.root);
			break;
		}
	}
	

	
    /** 
     * @param word
     * @param from
     * @param to
     * @return String
     */
    public String traducir(String word, int from, int to) {
		String traducida = "";
		if(from != to) {
			switch(from) {
			case 2:
				traducida = arbolespan.findNodo(word, to);
				break;
			case 1:
				traducida = arboling.findNodo(word, to);
				break;
			case 3:
				traducida = arbolfran.findNodo(word, to);
				break;
			}  
		}else {
			traducida = "Error de selección";
		}
		return traducida;
	}
	
	
	public String traducirArchivo(int from, int to) {
		String traducida = "";
		if(from!= to) {
			try {
				FileReader fr = new FileReader("./docs/archivo.txt");
				BufferedReader entrada = new BufferedReader(fr); 
				String s, tempTra;

				while((s = entrada.readLine()) != null) {
					String[] temp = s.split(" ");
					for(int i = 0; i< temp.length; i++) {
						tempTra = traducir(temp[i], from, to);
						if(tempTra != null) {
							traducida = traducida + tempTra + " ";
						}else {
							traducida = traducida + "*" + temp[i] + "* ";
						}
						
					}
				}

			}
			catch(java.io.FileNotFoundException fnfex) {
				System.out.println("Archivo no encontrado: " + fnfex);}
			catch(java.io.IOException ioex) {}
		}else {
			traducida = "Intentalo de nuevo, parece que seleccionaste la misma opcion en ambas.";
		}
		return traducida;
	}
    
}
