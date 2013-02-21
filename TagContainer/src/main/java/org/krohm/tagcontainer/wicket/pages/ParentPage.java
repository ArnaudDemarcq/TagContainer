/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.wicket.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.krohm.tagcontainer.wicket.pages.Panels.FooterPanel;
import org.krohm.tagcontainer.wicket.pages.Panels.HeaderPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Valentin
 */
public class ParentPage extends WebPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainPage.class);

    public ParentPage() {
         add(new FeedbackPanel("feedback"));
        HeaderPanel headerPanel = new HeaderPanel("HeaderPanel", "Tag Container Poc") ;
        add(headerPanel);
        add(new FooterPanel("FooterPanel"));
       
    }
    
    
}
