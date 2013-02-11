/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.servlet;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Arnaud
 */
public final class Util {

    private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

    public static String getAccountId(HttpServletRequest request) {
        String uriString = request.getRequestURI();
        int baseSize = request.getContextPath().length() + request.getServletPath().length();
        String remainingString = null;
        try {
            remainingString = uriString.substring(baseSize).split("/")[1];
        } catch (Exception ex) {
            LOGGER.warn("unable to get accont id for uri : " + uriString);
        } finally {
            return remainingString;
        }
    }

    public static String getScriptId(HttpServletRequest request) {
        return getAccountId(request);
    }
}
