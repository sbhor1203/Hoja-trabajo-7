/**
 * @author Audrey Bhor
 *  
 */
public class Nodos {


    // nodo principal e hijos 
    // padre - hijo

    protected String principal;
    protected Traduccion traduccion;
	protected Nodos left, right;
	
	//Constructor
	public Nodos (String principal, Traduccion traduc) {
		this.principal = principal;
		this.traduccion = traduc;
		this.left = this.right = null;
	}
    
    public Traduccion getValue(){
	    return traduccion;
	}

	@Override
	public String toString() {
		return "Palabra=" + principal + ", Traducciones= " + traduccion.getEnglish() + " - " + traduccion.getSpanish() + " - " + traduccion.getFrench();
	}

    
}
