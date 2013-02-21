/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.wicket.security;

import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Arnaud
 */
public class WicketWebSession extends AbstractAuthenticatedWebSession {

    private String userId;
    private String password;
    private Boolean isLogged = null;
    private static final Logger LOGGER = LoggerFactory.getLogger(WicketWebSession.class);

    public WicketWebSession(Request request) {
        super(request);
    }
    //private static UserEntityDao userEntityDao = StaticUserDao.getUserEntityDao();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        this.isLogged = null;
    }

    public void setPassword(String password) {
        this.password = password;
        this.isLogged = null;
    }

    @Override
    public Roles getRoles() {
        Roles currentRoles = new Roles();
        if (isSignedIn()) {
            currentRoles.add("IS_LOGGED");
            isLogged = true;
        }
        return currentRoles;
    }

    @Override
    public boolean isSignedIn() {
        LOGGER.error("TEST !");
        /*
        // skip chef if already logged 
        if (isLogged == true) {
            return true;
        }/**/
        // TODO : implement real auth
        return password != null;
    }

    public static WicketWebSession get() {
        return (WicketWebSession) Session.get();
    }
}
