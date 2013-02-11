/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.servlet;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.krohm.tagcontainer.servlet.AbstractJavascriptServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Arnaud
 */
public abstract class AbstractVelocityJavascriptServlet extends AbstractJavascriptServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractVelocityJavascriptServlet.class);

    abstract protected Template getVelocityTemplate(HttpServletRequest request) throws Exception;

    @Override
    protected StringWriter getResponseWriter(HttpServletRequest request) throws Exception {
        VelocityContext context = getVelocityContext(request);
        StringWriter writer = new StringWriter();
        getVelocityTemplate(request).merge(context, writer);
        return writer;
    }

    protected VelocityContext getVelocityContext(HttpServletRequest request) {
        VelocityContext context = new VelocityContext();
        return context;
    }
}
