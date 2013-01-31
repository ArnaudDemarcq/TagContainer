/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.servlet.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.krohm.tagcontainer.entities.ScriptEntity;
import org.krohm.tagcontainer.servlet.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Arnaud
 */
public abstract class AbstractGetAccountJavascriptServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractGetAccountJavascriptServlet.class);
    private static final Template accountJavascriptTemplate = getVelocityTemplate();

    abstract protected List<String> getUrlList(HttpServletRequest request);

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        setResponseHeaders(response);
        PrintWriter out = response.getWriter();
        try {

            VelocityContext context = getVelocityContect(request);
            /* now render the template into a StringWriter */
            StringWriter writer = new StringWriter();
            accountJavascriptTemplate.merge(context, writer);
            /* show the World */
            out.println(writer.toString());
            /* TODO output your page here. You may use following sample code. */
            //out.println("alert('test');");
            //  out.println(testScript.getContent());
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    final protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    final protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void setResponseHeaders(HttpServletResponse response) {

        response.setContentType("text/javascript;charset=UTF-8");
        response.setHeader("Cache-Control", "max-age=" + Integer.MAX_VALUE);

    }

    private static Template getVelocityTemplate() {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        Template template = ve.getTemplate("getAccountJavascript.tpl");
        return template;
    }

    private VelocityContext getVelocityContect(HttpServletRequest request) {
        VelocityContext context = new VelocityContext();
        List<String> urlsToInclude = new ArrayList<String>();
        urlsToInclude.addAll(getUrlList(request));
        context.put("urlsToInclude", urlsToInclude);
        context.put("ACCOUNT_ID", Util.getAccountId(request));
        return context;
    }

  
}
