package Generador;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Yonathan Román
 */
public class PDFcrear {
    public static String IMG = "";
    public static String archivopdf="";
    
    class ImageEvent implements PdfPCellEvent {
        
        
        
        protected Image img;
        public ImageEvent(Image img) {
            this.img = img;
        }
        public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvases) {
            img.scaleToFit(position.getWidth(), position.getHeight());
            img.setAbsolutePosition(position.getLeft() + (position.getWidth() - img.getScaledWidth()) / 2,
                    position.getBottom() + (position.getHeight() - img.getScaledHeight()) / 2);
            PdfContentByte canvas = canvases[PdfPTable.BACKGROUNDCANVAS];
            try {
                canvas.addImage(img);
            } catch (DocumentException ex) {
                // do nothing
            }
        }
    }
    
    
    public void guard() throws IOException, DocumentException{
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF de Código de Barras");
        FileFilter filter = new FileNameExtensionFilter("Documento PDF", "PDF");
        fileChooser.addChoosableFileFilter(filter);
        int userSelection = fileChooser.showSaveDialog(new Generador());
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File guardarBarras = fileChooser.getSelectedFile();
            if (!guardarBarras.toString().endsWith(".pdf")) {
                guardarBarras = new File(fileChooser.getSelectedFile() + ".pdf");
            }
            try {
                ImageIO.write(Generador.imagen, "pdf", guardarBarras);
                archivopdf=guardarBarras.toString();
            } catch (IOException ex) {
                Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            new PDFcrear().imagen();
            
        }else{
            JOptionPane.showMessageDialog(null, "Cancelo el PDF", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
//        new PDFcrear().imagen();
    }
    
    public void imagen() throws IOException, DocumentException {
        File file2 = new File("theimage.png");
        try {
            ImageIO.write(Generador.imagen, "png", file2);
            IMG = "theimage.png";
            File file = new File(archivopdf);
            file.getParentFile().mkdirs();
            new PDFcrear().createPdf(archivopdf);
        } catch (IOException ex) {
            Logger.getLogger(Guardar.class.getName()).log(Level.SEVERE, null, ex);
        }
        file2.delete();
        JOptionPane.showMessageDialog(null, "Se creo correctamente el PDF.\n\nSi las imagenes en el PDF no se ven bien\nse recomienda hacerlo manualmente.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    
    
    public void createPdf(String dest) throws IOException, DocumentException {
        // 1. Create a Document which contains a table:
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(4);
        PdfPCell cell1 = new PdfPCell();
        PdfPCell cell2 = new PdfPCell();
        PdfPCell cell3 = new PdfPCell();
        PdfPCell cell4 = new PdfPCell();
        PdfPCell cell5 = new PdfPCell();
        PdfPCell cell6 = new PdfPCell();
        PdfPCell cell7 = new PdfPCell();
        PdfPCell cell8 = new PdfPCell();
        PdfPCell cell9 = new PdfPCell();
        PdfPCell cell10 = new PdfPCell();
        PdfPCell cell11 = new PdfPCell();
        PdfPCell cell12 = new PdfPCell();
        PdfPCell cell13 = new PdfPCell();
        PdfPCell cell14 = new PdfPCell();
        // 2. Inside that table, make each cell with specific height:
        cell1.setFixedHeight(100);
        cell2.setFixedHeight(100);
        cell3.setFixedHeight(100);
        cell4.setFixedHeight(100);
        cell5.setFixedHeight(100);
        cell6.setFixedHeight(100);
        cell7.setFixedHeight(100);
        cell8.setFixedHeight(100);
        cell9.setFixedHeight(100);
        cell10.setFixedHeight(100);
        cell11.setFixedHeight(100);
        cell12.setFixedHeight(100);
        cell13.setFixedHeight(100);
        cell14.setFixedHeight(100);
        // 3. Each cell has the same background image
        ImageEvent imgEvent = new ImageEvent(Image.getInstance(IMG));
        cell1.setCellEvent(imgEvent);
        cell2.setCellEvent(imgEvent);
        cell3.setCellEvent(imgEvent);
        cell4.setCellEvent(imgEvent);
        cell5.setCellEvent(imgEvent);
        cell6.setCellEvent(imgEvent);
        cell7.setCellEvent(imgEvent);
        cell8.setCellEvent(imgEvent);
        cell9.setCellEvent(imgEvent);
        cell10.setCellEvent(imgEvent);
        cell11.setCellEvent(imgEvent);
        cell12.setCellEvent(imgEvent);
        cell13.setCellEvent(imgEvent);
        cell14.setCellEvent(imgEvent);
        // Wrap it all up!
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        table.addCell(cell5);
        table.addCell(cell6);
        table.addCell(cell7);
        table.addCell(cell8);
        table.addCell(cell9);
        table.addCell(cell10);
        table.addCell(cell11);
        table.addCell(cell12);
        table.addCell(cell13);
        table.addCell(cell14);
        document.add(table);
        document.close();
    }
}
