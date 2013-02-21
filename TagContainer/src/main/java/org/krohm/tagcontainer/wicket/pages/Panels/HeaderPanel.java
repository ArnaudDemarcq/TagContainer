/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.wicket.pages.Panels;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Xavier
 */
public  class HeaderPanel extends Panel {

    private static final Logger LOGGER = LoggerFactory.getLogger(HeaderPanel.class);

    public HeaderPanel(String id, String title) {
        super(id);

        add(new Label("appName", title));
        add(new Link("logout") {
            @Override
            public void onClick() {
                getSession().invalidateNow();
                setResponsePage(this.getApplication().getHomePage());
            }
        });

    }

}