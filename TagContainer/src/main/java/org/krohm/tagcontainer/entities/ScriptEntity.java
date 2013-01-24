/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krohm.tagcontainer.entities;

/**
 *
 * @author Arnaud
 */
public class ScriptEntity {

    // Script types
    public static final long SCRIPT_TYPE_UNKNOWN = 1L;
    public static final long SCRIPT_TYPE_URL = 1L;
    public static final long SCRIPT_TYPE_FIXED = 2L;
    public static final long SCRIPT_TYPE_TEMPLATE = 3L;
    // 
    // members
    private Long scriptId;
    private Long scriptType = SCRIPT_TYPE_UNKNOWN;
    private String content;

    public Long getScriptType() {
        return scriptType;
    }

    public void setScriptType(Long scriptType) {
        this.scriptType = scriptType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
