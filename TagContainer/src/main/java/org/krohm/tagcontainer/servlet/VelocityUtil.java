/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.servlet;

import java.io.StringReader;
import org.apache.velocity.Template;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.ParseException;
import org.apache.velocity.runtime.parser.node.SimpleNode;

/**
 *
 * @author Arnaud
 */
public final class VelocityUtil {

    public static Template createVelocityTemplate(String templateString) throws ParseException {
        // Disables logs for AIX : mandatory for WAS
        // runtime.log.logsystem.class=org.apache.velocity.runtime.log.NullLogSystem
        RuntimeSingleton.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
        //
        RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();
        StringReader reader = new StringReader(templateString);
        SimpleNode node = runtimeServices.parse(reader, "Template name");
        Template template = new Template();
        template.setRuntimeServices(runtimeServices);
        template.setData(node);
        template.initDocument();
        return template;
    }
}
