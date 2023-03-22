/**
 * @author Audrey Bhor
 *  
 */
public class ArbolBinario {



    Nodo root;  // llamamos a nuestro nodo principal

    public ArbolBinario() {
    	root = null;
    }

    
    
    public void addNodo(String word, Traduccion traduc){
        Nodo newNodo = new Nodo(word, traduc);

        if(root == null){
            root = newNodo;
        }
        else{
            Nodo hijo = root;
            Nodo padre;
            while (true){
                padre = hijo;
                int compare = word.compareTo(hijo.principal);
                if(compare < 0){									
                	hijo = hijo.left;						
                    if(hijo == null){							 							
                        padre.left = newNodo;						
                        return;
                    }
                }
                else{
                	hijo = hijo.right;
                    if(hijo == null){
                        padre.right = newNodo;
                        return;
                    }
                }
            }
        }
    }
    
    public void inOrder(Nodo hijo){
        if(hijo != null){
            inOrder(hijo.left);
            System.out.println(hijo);
            inOrder(hijo.right);
        }
    }

    
    public String findNodo(String word, int to){
        String traducida = "";
    	Nodo auxiliar = root;

        while(!auxiliar.principal.equals(word)){
            int compare = word.compareTo(auxiliar.principal);
            if(compare < 0){
            	auxiliar = auxiliar.left;
            }
            else{
            	auxiliar = auxiliar.right;
            }
            if(auxiliar == null){										
                return null;
            }
        }
        
        switch(to) {
		case 2:
			traducida = auxiliar.traduccion.getSpanish();
			break;
		case 1:
			traducida = auxiliar.traduccion.getEnglish();
			break;
		case 3:
			traducida = auxiliar.traduccion.getFrench();
			break;
		} 
        
        return traducida;
    }


public class Nodo {
    protected String principal; 
    protected Traduccion traduccion;
	protected Nodo left, right; 
	
	//Constructor
	public Nodo (String principal, Traduccion traduc) {
		this.principal = principal;
		this.traduccion = traduc;
		this.left = this.right = null;
	}
	
	public Traduccion getValue(){
	    return traduccion;
	}

	@Override
	public String toString() {
		return " - Nodo =" + principal + "\n - Traducciones según idioma= " + traduccion.getEnglish() + " - " + traduccion.getSpanish() + " - " + traduccion.getFrench()+"\n";
	}

}



    
}


