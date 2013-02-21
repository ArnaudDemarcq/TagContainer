/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.wicket.pages;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Xavier
 */
@AuthorizeInstantiation("IS_LOGGED")
public class MainPage extends ParentPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainPage.class);

    public MainPage() {
    }
}
