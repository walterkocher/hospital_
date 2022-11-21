package hospital;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import java.io.IOException;

public class GeneradorPdf {

	public void generarPdf(Doctor doctor) throws IOException {
//Se crea un nuevo documento
	PDDocument documento = new PDDocument();
//Al documento se le crea y agrega una nueva página, en este caso en formato A6
	PDPage pagina = new PDPage(PDRectangle.A6);
	documento.addPage(pagina);
//Se genera un arreglo de líneas que va a tener el archivo PDF
	String[] lineasPdf= this.obtenerLíneasPdf(doctor);
	this.rellenarPDF(documento,pagina,lineasPdf);
//Se guarda el documento en la ubicación descrita
	documento.save(this.generarNombrePdf(doctor));
	documento.close();
}
	public void rellenarPDF(PDDocument documento, PDPage pagina, String[] lineasDoctores){
//Por cada linea del arreglo, se irá agregando texto
		try (PDPageContentStream contenidoPagina = new PDPageContentStream(documento, pagina)) {
			for(int linea=0; linea<lineasDoctores.length; linea++) {
				contenidoPagina.beginText();
//Se define en que posición del documento estará el texto
				contenidoPagina.newLineAtOffset(10, pagina.getMediaBox().getHeight()-(10*linea));
				contenidoPagina.setFont(PDType1Font.HELVETICA_BOLD, 8f);
//Agrega el texto al documento
				contenidoPagina.showText(lineasDoctores[linea]);
				contenidoPagina.endText();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String[] obtenerLíneasPdf(Doctor doctor){
		String[] lineasPdf= new String[7];
		lineasPdf[0]="";
		lineasPdf[1]="Clinica temuco";
		lineasPdf[2]="-------------------------------------------------";
		lineasPdf[3]="";
		lineasPdf[4]="nombre: "+doctor.getNombre();
		lineasPdf[5]="";
		lineasPdf[6]="RUT: "+doctor.getRut();
		return lineasPdf;
	}
	private String generarNombrePdf(Doctor doctor){

		String Archivo= doctor.getNombre();
		Archivo=Archivo.replace(" ","").replace(":","");
		String nombreArchivo="target/"+"doctor "+Archivo+".pdf";
		return nombreArchivo;
	}
}