/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Arnaud
 */
public abstract class AbstractJavascriptServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractJavascriptServlet.class);

    abstract protected StringWriter getResponseWriter(HttpServletRequest request) throws Exception;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setResponseHeaders(response);
        PrintWriter out = response.getWriter();
        try {
            StringWriter writer = getResponseWriter(request);
            out.println(writer.toString());
        } catch (Exception ex) {
            LOGGER.warn("An error occured during javascript rendering : " + ex);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("" + ex, ex);
            }
        } finally {
            out.close();
        }
    }

    @Override
    final protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void setResponseHeaders(HttpServletResponse response) {
        response.setContentType("text/javascript;charset=UTF-8");
        response.setHeader("Cache-Control", "max-age=" + Integer.MAX_VALUE);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
