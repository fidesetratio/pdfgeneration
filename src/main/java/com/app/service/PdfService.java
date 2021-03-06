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
	public class PdfService {

	    private static final String PDF_RESOURCES = "/pdf-resources/";
	    private StudentService studentService;
	    private SpringTemplateEngine templateEngine;

	    @Autowired
	    public PdfService(StudentService studentService, SpringTemplateEngine templateEngine) {
	        this.studentService = studentService;
	        this.templateEngine = templateEngine;
	    }

	    public File generatePdf() throws IOException, DocumentException {
	        Context context = getContext();
	        String html = loadAndFillTemplate(context);
	        return renderPdf(html);
	    }

	    public File generatePdf(String filename) throws IOException, DocumentException{
	    		Context context = getContext();
	            String html = loadAndFillTemplate(filename,context);
		        return renderPdfTwo(filename);
	    }

	    private File renderPdf(String html) throws IOException, DocumentException {
	    	System.out.println("html:"+html);
	    	File file = File.createTempFile("students", ".pdf");
	        OutputStream outputStream = new FileOutputStream(file);
	        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
	        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
	        renderer.layout();
	        renderer.createPDF(outputStream);
	        outputStream.close();
	        file.deleteOnExit();
	        return file;
	    }
	    
	    private File renderPdfTwo(String html) throws IOException, DocumentException {
	    	System.out.println("html:"+html);
	    	File file = File.createTempFile("studentstemp", ".pdf");
	        OutputStream outputStream = new FileOutputStream(file);
	        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
	        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
	        renderer.layout();
	        renderer.createPDF(outputStream);
	        outputStream.close();
	        file.deleteOnExit();
	        return file;
	    }

	    private Context getContext() {
	        Context context = new Context();
	        context.setVariable("students", studentService.getStudents());
	        return context;
	    }

	    private String loadAndFillTemplate(Context context) {
	        return templateEngine.process("helloworld", context);
	    }

  

    private String loadAndFillTemplate(String filename, Context context) {

        return templateEngine.process("helloworld", context);
    }

	}

