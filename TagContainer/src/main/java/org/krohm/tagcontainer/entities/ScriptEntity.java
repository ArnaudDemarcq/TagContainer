/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author Arnaud
 */
@Entity
/*
 @NamedQueries({
 @NamedQuery(name = "ScriptEntity.findById",
 query = "FROM UserEntity userEntity WHERE scriptEntity.scriptId = :script_id")
 })/**/
public class ScriptEntity implements Serializable {

    public enum ScriptType {

        UNKNOWN,
        EXTERNAL_URL,
        STATIC_SCRIPT,
        DYNAMIC_SCRIPT;
    }
    // Script types
    public static final long SCRIPT_TYPE_UNKNOWN = 0L;
    public static final long SCRIPT_TYPE_URL = 1L;
    public static final long SCRIPT_TYPE_FIXED = 2L;
    public static final long SCRIPT_TYPE_TEMPLATE = 3L;
    // Script statuses
    public static final long SCRIPT_STATUS_DISABLED = 0L;
    public static final long SCRIPT_STATUS_ENABLED = 1L;
    // 
    // members    
    //
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long scriptId;
    private ScriptType scriptType = ScriptType.UNKNOWN;
    @Lob
    private String content;
    private Long accountId = null;
    private Long scriptStatus = ScriptEntity.SCRIPT_STATUS_ENABLED;

    public Long getScriptId() {
        return scriptId;
    }

    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ScriptType getScriptType() {
        return scriptType;
    }

    public void setScriptType(ScriptType scriptType) {
        this.scriptType = scriptType;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getScriptStatus() {
        return scriptStatus;
    }

    public void setScriptStatus(Long scriptStatus) {
        this.scriptStatus = scriptStatus;
    }
}
