/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.dao;

import org.krohm.tagcontainer.entities.ScriptEntity;

/**
 *
 * @author Arnaud
 */
public class ScriptEntityDao extends GenericDao< ScriptEntity,Long> {

    public ScriptEntityDao() {
        super( ScriptEntity.class,Long.class);
    }
    
}
