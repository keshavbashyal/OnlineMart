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
public interface ReportStreamWriter {
        public void write(ByteArrayInputStream byteArrayInputStream, HttpServletResponse response) throws Exception;

}
