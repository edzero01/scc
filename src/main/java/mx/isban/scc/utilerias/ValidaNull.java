/**
 * 
 */
package mx.isban.scc.utilerias;


/**
 * Clase de Utilería para validación 
 * Se usa para atrapar los valores nulos
 * y pasar defaults evitando que se muestren
 * al usuario en el front end
 * 
 * @author Lwb
 * Global Hitss
 * 
 * Septiembre 2019
 * Sprint 
 *
 */
public class ValidaNull {

	/**
	 * Recibe un objeto, lo convierte a string y lo pasa a Double
	 * @param valor es el objeto que recibe
	 * @return Double que es 0 o bien el valor en sí obtenido del query
	 */
	public Double validaNullDouble(Object valor) {
		Double valorR =0.0;
		if(valor == null) {
			return valorR;
		}else {
			valorR = Double.parseDouble(valor.toString());
		}
		
		return valorR;
	}

	/**
	 * Recibe un objeto, lo convierte a string y lo pasa tal cual
	 * @param valor es el objeto que recibe
	 * @return String para que lo cache en front end
	 */
	public String validaNullString(Object valor) {
		String valorR = "";
		if(valor == null) {
			return valorR;
		}else {
			valorR = valor.toString();
		}
		
		return valorR;
	}
	/**
	 * Evalua los tipos de perifil para filtrar la oferta promocional de campana y mercado abierto
	 * @param perfil se manda como parametro el tipo de perfil por el cual fue logeado
	 * @return un tipo de dato string
	 */

	public String armaQueryOfertasPromPerfil (Long perfil) {
		String query = "";
		switch (perfil.intValue()) {
		    case 1 :
		    	query = " and (codVtaRedIn = 1 or  codVtaRedOut = 1)";
		    break;
		    case 2 :
		    	query = " and (codVtaCcsIn = 1 or codVtaCcsOut = 1) ";
		    break;
		    case 4 :
		    	query = " and (codVtaAsn = 1 or codVtaFve = 1)"; 
		    break;
		    default: 
		    	query = " ";
		    	break;
		
		}
		return query;
	}

}
