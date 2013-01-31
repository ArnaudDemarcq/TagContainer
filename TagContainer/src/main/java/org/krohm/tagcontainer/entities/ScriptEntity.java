/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Arnaud
 */
@Entity
public class ScriptEntity {

    public enum ScriptType {

        UNKNOWN,
        EXTERNAL_URL,
        STATIC_SCRIPT,
        DYNAMIC_SCRIPT;
    }
    // Script types
    public static final long SCRIPT_TYPE_UNKNOWN = 1L;
    public static final long SCRIPT_TYPE_URL = 1L;
    public static final long SCRIPT_TYPE_FIXED = 2L;
    public static final long SCRIPT_TYPE_TEMPLATE = 3L;
    // 
    // members    
    //
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long scriptId;
    private ScriptType scriptType = ScriptType.UNKNOWN;
    private String content;

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
}
