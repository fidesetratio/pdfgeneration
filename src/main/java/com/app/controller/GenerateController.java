package com.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.PdfGeneratorServices;
import com.lowagie.text.DocumentException;

@Controller
public class GenerateController {
	@Autowired
    private  PdfGeneratorServices pdfService;
	
	 @GetMapping("/generate-pdf")
	    public void generateWithDinamicPdfResource(@RequestParam("filename") String filename,HttpServletResponse response) {
		 try {
	            Path file = Paths.get(pdfService.generatePdf(filename).getAbsolutePath());
	            if (Files.exists(file)) {
	            	
	                response.setContentType("application/pdf");
	       /**         response.addHeader("Content-Disposition",
	                        "attachment; filename=" + file.getFileName()); **/
	                response.addHeader("Content-Disposition",
	                        "inline; filename=" + file.getFileName());
	           
	                Files.copy(file, response.getOutputStream());
	                response.getOutputStream().flush();
	            }
	        } catch (DocumentException | IOException ex) {
	            ex.printStackTrace();
	        }
	 		}
	   
}
