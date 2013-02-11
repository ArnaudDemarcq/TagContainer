/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany
    private Set<ScriptEntity> stockDailyRecords = new HashSet<ScriptEntity>(0);

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

    public Set<ScriptEntity> getStockDailyRecords() {
        return stockDailyRecords;
    }

    public void setStockDailyRecords(Set<ScriptEntity> stockDailyRecords) {
        this.stockDailyRecords = stockDailyRecords;
    }
}
