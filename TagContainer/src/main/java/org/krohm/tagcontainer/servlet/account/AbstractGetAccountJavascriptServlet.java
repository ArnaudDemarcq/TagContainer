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
import org.krohm.tagcontainer.servlet.AbstractJavascriptServlet;
import org.krohm.tagcontainer.servlet.AbstractVelocityJavascriptServlet;
import org.krohm.tagcontainer.servlet.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Arnaud
 */
public abstract class AbstractGetAccountJavascriptServlet extends AbstractVelocityJavascriptServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractGetAccountJavascriptServlet.class);
    private static final Template accountJavascriptTemplate = getVelocityTemplate();

    abstract protected List<String> getUrlList(HttpServletRequest request);

    private static final Template getVelocityTemplate() {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        Template template = ve.getTemplate("getAccountJavascript.tpl");
        return template;
    }

    @Override
    protected final VelocityContext getVelocityContext(HttpServletRequest request) {
        VelocityContext context = new VelocityContext();
        List<String> urlsToInclude = new ArrayList<String>();
        urlsToInclude.addAll(getUrlList(request));
        context.put("urlsToInclude", urlsToInclude);
        context.put("ACCOUNT_ID", Util.getAccountId(request));
        return context;
    }

    @Override
    protected final Template getVelocityTemplate(HttpServletRequest request) {
        return accountJavascriptTemplate;
    }
}
