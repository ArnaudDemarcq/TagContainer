/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.servlet;

import java.io.StringWriter;
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

    abstract protected Template getVelocityTemplate(HttpServletRequest request);

    abstract protected VelocityContext getVelocityContect(HttpServletRequest request);

    @Override
    protected StringWriter getResponseWriter(HttpServletRequest request) throws Exception {
        VelocityContext context = getVelocityContect(request);
        StringWriter writer = new StringWriter();
        getVelocityTemplate(request).merge(context, writer);
        return writer;
    }
}
