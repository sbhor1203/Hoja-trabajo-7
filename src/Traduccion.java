/**
 * @author Audrey Bhor
 *  
 */
public class Traduccion {
 
    private String ing = "";
	private String fran = "";
    private String span = "";
	
	public Traduccion() {}


    
    /** 
     * @return String
     */
    @Override
	public String toString() {
		return "Traduccion: \n Al Inglés=" + ing + ", Al Español=" + span + ", Al Francés=" + fran + "]";
	}

	public String getEnglish() {
		return ing;
	}

	public String getSpanish() {
		return span;
	}

	public String getFrench() {
		return fran;
	}

	public void setEnglish(String ingles) {
		this.ing = ingles;
	}

	public void setSpanish(String español) {
		this.span = español;
	}

	public void setFrench(String frances) {
		this.fran = frances;
	}
    
}
