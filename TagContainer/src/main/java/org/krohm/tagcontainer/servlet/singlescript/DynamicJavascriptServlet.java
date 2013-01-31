/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.servlet.singlescript;

import javax.servlet.http.HttpServletRequest;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.krohm.tagcontainer.servlet.AbstractVelocityJavascriptServlet;

/**
 *
 * @author Arnaud
 */
public class DynamicJavascriptServlet extends AbstractVelocityJavascriptServlet {

    @Override
    protected Template getVelocityTemplate(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected VelocityContext getVelocityContext(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
