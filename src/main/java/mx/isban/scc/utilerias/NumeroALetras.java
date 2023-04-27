package mx.isban.scc.utilerias;

import java.math.BigInteger;
import java.util.regex.Pattern;
/**
 * Transforma los dígitos de un numero en palabras
 * 
 * @author José Luis Garcia Noyola
 * 
 * 2022
 * NTT DATA
 */
public class NumeroALetras {

	private final String[] UNIDADES = { "", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ",
			"nueve " };
	private final String[] DECENAS = { "diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
			"diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ", "cincuenta ", "sesenta ",
			"setenta ", "ochenta ", "noventa " };
	private final String[] CENTENAS = { "", "ciento ", "doscientos ", "trescientos ", "cuatrocientos ", "quinientos ",
			"seiscientos ", "setecientos ", "ochocientos ", "novecientos " };

	public NumeroALetras() {
		
	}

	public String convertir(String numero, String etiquetaEnteroSingular, String etiquetaEnteroPlural,
			String etiquetaFlotanteSingular, String etiquetaFlotantePlural, String etiquetaConector,
			boolean mayusculas) {
	    
		String literal = "";
	    String parteDecimal = "";
	    
	    // Si el numero utiliza (.) en lugar de (,) -> se reemplaza
	    numero = numero.replace(".", ",");
	    
	    // Si el numero no tiene parte decimal, se le agrega ,00
	    if (numero.indexOf(",") == -1) {
	        numero = numero + ",00";
	    }
	    
	    // Se valida formato de entrada -> 0,00 y 999 999 999 999,00
	    if (Pattern.matches("\\d{1,12},\\d{1,2}", numero)) {
	        // Se divide el numero 0000000,00 -> entero y decimal
	        String num[] = numero.split(",");
	        String entero = num[0];
	        String decimal = num[1];
	        
	        // Se da formato al numero decimal
	        if (decimal.length() == 1) {
	        	decimal += "0";
	        }              
	        
	        String dec = getDecenas(decimal);
	        if (!"".equals(dec)) {
	        	if (!"".equals(etiquetaEnteroSingular)) {
	        		parteDecimal += " ";
	        	}
	        	if (Integer.parseInt(decimal)==1) {
	        		parteDecimal += etiquetaConector + " " + dec + etiquetaFlotanteSingular;
	        	} else {
	        		parteDecimal += etiquetaConector + " " + dec + etiquetaFlotantePlural;
	        	}
	        }
	        
	        // Se convierte el numero a literal                       
			BigInteger parteEntera = new BigInteger(entero);
	       
	        if (parteEntera.compareTo(new BigInteger("0")) == 0) {//si el valor es cero
	            literal = "cero ";
	        } else if (parteEntera.compareTo(new BigInteger("999999999")) == 1 ) {//si es billon
	            literal = getBillones(entero);
	        } else if (parteEntera.compareTo(new BigInteger("999999")) == 1 ) {//si es millon
	            literal = getMillones(entero);
	        } else if (parteEntera.compareTo(new BigInteger("999")) == 1 ) {//si es miles
	            literal = getMiles(entero);
	        } else if (parteEntera.compareTo(new BigInteger("99")) == 1 ) {//si es centena
	            literal = getCentenas(entero);
	        } else if (parteEntera.compareTo(new BigInteger("9")) == 1 ) {//si es decena
	            literal = getDecenas(entero);
	        } else {//sino unidades -> 9
	            literal = getUnidades(entero);
	        }
	        // Devuelve el resultado en mayusculas o minusculas
	        
	        if (parteEntera.compareTo(new BigInteger("1")) == 0) {
	        	literal += etiquetaEnteroSingular;            	
	        } else {
	        	literal += etiquetaEnteroPlural;
	        }            
	        
	        if (mayusculas) {
	            return (literal + parteDecimal).toUpperCase().trim();
	        } else {
	            return (literal + parteDecimal).trim();
	        }
	    } else {//error, no se puede convertir
	        return null;
	    }
	}

	/* funciones para convertir los numeros a literales */
	private String getUnidades(String numero) {// 1 - 9
	    //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
	    String num = numero.substring(numero.length() - 1);
	    return UNIDADES[Integer.parseInt(num)];
	}

	private String getDecenas(String num) {// 99 
		int n = Integer.parseInt(num); 
		if (n < 10) {//para casos como -> 01 - 09 
			return getUnidades(num); 
		} else if (n > 19) {//para 20...99 
			String u = getUnidades(num); 
			if (u.equals("")) { //para 20,30,40,50,60,70,80,90 
				return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8]; 
			} else { 
				if(n == 21) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 22) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 23) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 24) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 25) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 26) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 27) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 28) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;} 
				if(n == 29) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;} 
				return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u; 
			} 
		} else {//numeros entre 11 y 19 
			return DECENAS[n - 10];
		} 
	}

	private String getCentenas(String num) {// 999 o 099
	    if (Integer.parseInt(num) > 99) {//es centena
	        if (Integer.parseInt(num) == 100) {//caso especial
	            return " cien ";
	        } else {
	            return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
	        }
	    } else {//por Ej. 099 
	        //se quita el 0 antes de convertir a decenas
	        return getDecenas(Integer.parseInt(num) + "");
	    }
	}

	private String getMiles(String numero) {// 999 999
	    //obtiene las centenas
	    String c = numero.substring(numero.length() - 3);
	    //obtiene los miles
	    String m = numero.substring(0, numero.length() - 3);
	    String n = "";
	    //se comprueba que miles tenga valor entero
	    if (Integer.parseInt(m) > 0) {
	        n = getCentenas(m);
	        return n + "mil " + getCentenas(c);
	    } else {
	        return "" + getCentenas(c);
	    }

	}

	private String getMillones(String numero) { //000 000 000        
	    //se obtiene los miles
	    String miles = numero.substring(numero.length() - 6);
	    //se obtiene los millones
	    String millon = numero.substring(0, numero.length() - 6);
	    String n = "";
	    if (Integer.parseInt(millon) > 0) {
	    	if (Integer.parseInt(millon) == 1) {
	    		n = getUnidades(millon) + "millon ";
	    	} else {
	    		n = getCentenas(millon) + "millones ";
	    	}
	    }
	    
	    return n + getMiles(miles);
	}

	private String getBillones(String numero) { //000 000 000 000        
	    //se obtiene los miles
	    String miles = numero.substring(numero.length() - 9);
	    //se obtiene los millones
	    String millon = numero.substring(0, numero.length() - 9);
	    String n = "";
	    if (Integer.parseInt(millon) == 1) {
	    	n = getUnidades(millon) + "billon ";
	    } else {
	    	n = getCentenas(millon) + "billones ";
	    }
	    
	    return n + getMillones(miles);
	}
}
