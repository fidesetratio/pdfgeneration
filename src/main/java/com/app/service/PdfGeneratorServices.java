package com.app.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

@Service
public class PdfGeneratorServices {
	   private static final String PDF_RESOURCES_SERVICES = "/pdf-resources/";
	   private SpringTemplateEngine templateEngine;
	   
	   @Autowired
	    public PdfGeneratorServices(SpringTemplateEngine templateEngine) {
	       this.templateEngine = templateEngine;
	    }
	   public File generatePdf(String fileName) throws IOException, DocumentException {
	        Context context = getContext();
	        String html = loadAndFillTemplate(fileName,context);
	        return renderPdf(html);
	    }
	   
	   private Context getContext() {
	        Context context = new Context();
	        return context;
	    }
	   
	   private File renderPdf(String html) throws IOException, DocumentException {
	    	System.out.println("html:"+html);
	    	File file = File.createTempFile("tstudents", ".pdf");
	        OutputStream outputStream = new FileOutputStream(file);
	        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
	        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES_SERVICES).getURL().toExternalForm());
	        renderer.layout();
	        renderer.createPDF(outputStream);
	        outputStream.close();
	        file.deleteOnExit();
	        return file;
	    }
	   private String loadAndFillTemplate(String filename,Context context) {
	        return templateEngine.process("helloworld", context);
	    }

}
