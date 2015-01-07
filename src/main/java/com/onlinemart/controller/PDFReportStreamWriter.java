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
abstract class PDFReportStreamWriter implements ReportStreamWriter {

    private String mime;
    private String expertFileName;

    public String getExpertFileName() {
        return expertFileName;
    }

    public void setExpertFileName(String filename) {
        expertFileName = filename;
    }

    public PDFReportStreamWriter() {
        this.mime = "application/pd";

    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mimeType) {
        mime = mimeType;
    }

    @Override
    public abstract void write(ByteArrayInputStream byteArrayInputStream, HttpServletResponse response) throws Exception;
}
