/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.servlet.singlescript;

import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import org.krohm.tagcontainer.entities.ScriptEntity;
import org.krohm.tagcontainer.servlet.AbstractJavascriptServlet;

/**
 *
 * @author Arnaud
 */
public class StaticJavascriptServlet extends AbstractJavascriptServlet {

    private static ScriptEntity testScript;

    public ScriptEntity getTestScript() {
        return testScript;
    }

    public void setTestScript(ScriptEntity testScript) {
        StaticJavascriptServlet.testScript = testScript;
    }

    @Override
    protected StringWriter getResponseWriter(HttpServletRequest request) throws Exception {
        StringWriter returnStringWriter = new StringWriter();
        returnStringWriter.append(testScript.getContent());
        return returnStringWriter;
    }
}
