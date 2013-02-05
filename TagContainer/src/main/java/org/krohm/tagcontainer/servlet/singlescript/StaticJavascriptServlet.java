/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.servlet.singlescript;

import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import org.krohm.tagcontainer.dao.GenericDao;
import org.krohm.tagcontainer.dao.ScriptEntityDao;
import org.krohm.tagcontainer.entities.ScriptEntity;
import org.krohm.tagcontainer.servlet.AbstractJavascriptServlet;
import org.krohm.tagcontainer.servlet.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Arnaud
 */
public class StaticJavascriptServlet extends AbstractJavascriptServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericDao.class);
    private static ScriptEntityDao scriptEntityDao;
    private static ScriptEntity testScript;

    public void setScriptEntityDao(ScriptEntityDao scriptEntityDao) {
        this.scriptEntityDao = scriptEntityDao;
    }

    public ScriptEntity getTestScript() {
        return testScript;
    }

    public void setTestScript(ScriptEntity testScript) {
        StaticJavascriptServlet.testScript = testScript;
    }

    @Override
    protected StringWriter getResponseWriter(HttpServletRequest request) throws Exception {
        StringWriter returnStringWriter = new StringWriter();
        String scriptIdString = Util.getScriptId(request);
        LOGGER.info("Getting Static Script for Id :<" + scriptIdString + ">");
        Long scriptId = Long.MIN_VALUE;
        try {
            scriptId = Long.parseLong(scriptIdString);
        } catch (Exception ex) {
            LOGGER.warn("Requested script for non numeric id :<" + scriptIdString + ">, defaulting to Long.MIN_VALUE");
        }
        ScriptEntity testScriptEntity = scriptEntityDao.findById(scriptId);
        if (testScriptEntity != null) {
            returnStringWriter.append(testScriptEntity.getContent());
        } else {
            LOGGER.warn("Requested script for unknown id :<" + scriptId + ">, returning empty script");
        }
        return returnStringWriter;
    }
}
