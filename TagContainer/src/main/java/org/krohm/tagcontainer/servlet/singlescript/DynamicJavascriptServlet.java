/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.servlet.singlescript;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.parser.ParseException;
import org.krohm.tagcontainer.dao.ScriptEntityDao;
import org.krohm.tagcontainer.entities.ScriptEntity;
import org.krohm.tagcontainer.servlet.AbstractVelocityJavascriptServlet;
import org.krohm.tagcontainer.servlet.Util;
import org.krohm.tagcontainer.servlet.VelocityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Arnaud
 */
public class DynamicJavascriptServlet extends AbstractVelocityJavascriptServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicJavascriptServlet.class);
    private static ScriptEntityDao scriptEntityDao;
    private static ScriptEntity defaultScript;

    public void setScriptEntityDao(ScriptEntityDao scriptEntityDao) {
        DynamicJavascriptServlet.scriptEntityDao = scriptEntityDao;
    }

    public ScriptEntity getDefaultScript() {
        return defaultScript;
    }

    public void setDefaultScript(ScriptEntity defaultScript) {
        DynamicJavascriptServlet.defaultScript = defaultScript;
    }

    // TODO : duplicated code with StaticJavascriptServlet needs 
    // to be factorized
    @Override
    protected Template getVelocityTemplate(HttpServletRequest request) throws ParseException {
        String scriptIdString = Util.getScriptId(request);
        LOGGER.info("Getting Dynamic Script for Id :<" + scriptIdString + ">");
        Long scriptId = Long.MIN_VALUE;
        Template returnTemplate = null;
        try {
            scriptId = Long.parseLong(scriptIdString);
        } catch (Exception ex) {
            LOGGER.warn("Requested Dynamic script for non numeric id :<" + scriptIdString + ">, defaulting to Long.MIN_VALUE");
        }
        ScriptEntity testScriptEntity = scriptEntityDao.findById(scriptId);
        if (testScriptEntity != null) {
            returnTemplate = VelocityUtil.createVelocityTemplate(testScriptEntity.getContent());
        } else {
            LOGGER.warn("Requested Dynamic script for unknown id :<" + scriptId + ">, returning empty script");
            returnTemplate = VelocityUtil.createVelocityTemplate(defaultScript.getContent());
        }
        return returnTemplate;
    }

    @Override
    protected final VelocityContext getVelocityContext(HttpServletRequest request) {
        VelocityContext context = super.getVelocityContext(request);
        context.put("SCRIPT_ID", Util.getScriptId(request));
        return context;
    }
}
