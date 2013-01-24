/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.account;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Arnaud
 */
public class TestGetAccountJavascriptServlet extends AbstractGetAccountJavascriptServlet {

    @Override
    protected List<String> getTestUrlList(HttpServletRequest request) {
        List<String> returnList = new ArrayList<String>();
        returnList.add("http://code.jquery.com/jquery.min.js");
        returnList.add("./GetJavascript/1528795644/script.js");
        returnList.add("./GetJavascript/9876543210/script.js?thisis=aparam&thatis=anotherone");
        returnList.add("http://dummy.not.existing/script.js");
        return returnList;

    }
}
