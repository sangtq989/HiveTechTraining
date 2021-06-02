package com.sang;

import java.io.Serializable;

public class DeserializeClass implements Serializable {
    static final long serialVersionUID = 135791L;
    private String name;
    public String a;public String v;
    private String value;
    private ChildClass child;

    public DeserializeClass(String name, String value, ChildClass child) {
        this.name = name;
        this.value = value;
        this.child = child;
    }

    public DeserializeClass(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ChildClass getChild() {
        return child;
    }

    public void setChild(ChildClass child) {
        this.child = child;
    }
}
