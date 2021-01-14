package com.sang;

import java.io.Serializable;

public class ChildClass implements Serializable {
    private String childName;
    private Integer childValue;

    public ChildClass(String childName, Integer childValue) {
        this.childName = childName;
        this.childValue = childValue;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Integer getChildValue() {
        return childValue;
    }

    public void setChildValue(Integer childValue) {
        this.childValue = childValue;
    }
}
