/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Arnaud
 */
@Entity
public class AccountEntity {

    public enum AccountStatus {

        IS_ENABLED,
        IS_DISABLED;
    }
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String accountName;
    private AccountStatus accountStatus = AccountStatus.IS_ENABLED;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date accountCreationDate = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Date getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(Date accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }
}
