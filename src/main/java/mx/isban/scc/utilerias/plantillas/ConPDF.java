package mx.isban.scc.utilerias.plantillas;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

/**
	 * Clase para convertir archivos docx a pdf
	 * principalmente usado para plantillas
	 * Sprint 3
	 * Julio 2019
 * @author Hitss
 *
 */
@Service
public class ConPDF {
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ConPDF.class);
	/**
	 * Metodo para convertir archivos docx a pdf
	 * principalmente usado para plantillas
	 * Sprint 3
	 * Julio 2019
	 * @param plantillaDocx
	 * path de documento con los datos
	 * @return ByteArrayOutputStream
	 * archivo transformado a PDF
	 */
    public ByteArrayOutputStream convertToPDF(ByteArrayOutputStream plantillaDocx) {
    	 InputStream inputStreamDocx = new ByteArrayInputStream(plantillaDocx.toByteArray());
    	 ByteArrayOutputStream documentoPDF= null;
        try {
            XWPFDocument document = new XWPFDocument(inputStreamDocx);            
            PdfOptions options = PdfOptions.create();
    		documentoPDF= new ByteArrayOutputStream();
            PdfConverter.getInstance().convert(document, documentoPDF, options);
        } catch (FileNotFoundException  ex) {
        	LOGGER.error(ex.getMessage(), ex);
        	return null;
        } catch (IOException ex) {
        	LOGGER.error(ex.getMessage(), ex);
        	return null;
        }
        return documentoPDF;
    }

}