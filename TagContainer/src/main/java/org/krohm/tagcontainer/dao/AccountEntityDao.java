/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.dao;

import org.krohm.tagcontainer.entities.AccountEntity;

/**
 *
 * @author Arnaud
 */
public class AccountEntityDao extends GenericDao<Long, AccountEntity> {

    public AccountEntityDao() {
        super(Long.class, AccountEntity.class);
    }
}
