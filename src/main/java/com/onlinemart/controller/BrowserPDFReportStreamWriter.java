/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlinemart.controller;

import java.io.ByteArrayInputStream;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author acer
 */
public class BrowserPDFReportStreamWriter extends PDFReportStreamWriter{

    
    public BrowserPDFReportStreamWriter() {
        
    }

    @Override
    public void write(ByteArrayInputStream byteArrayInputStream, HttpServletResponse response) throws Exception {
        int totalByteRead = 0;
        byte[] outputBuffer = new byte[byteArrayInputStream.available()];
		
		
		
        // reset  httpResponse for writing report 
		response.reset();
                response.setContentType(getMime());
		response.setHeader("Content-disposition", "inline;filename=" + getExpertFileName());
		
		
		
		while((totalByteRead = byteArrayInputStream.read(outputBuffer)) != -1) {
			response.getOutputStream().write(outputBuffer, 0, totalByteRead);	
		}
		
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
    }

   
    
}
