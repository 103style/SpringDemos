package com.style103.mybatis.pojo;

import java.util.List;

/**
 * create by 103style on 2024/12/16 23:28
 * github:https://github.com/103style
 */
public class Dep {
    private int depId;
    private String depName;
    private List<Emp> depEmps;

    public Dep() {
    }

    public Dep(int depId, String depName) {
        this.depId = depId;
        this.depName = depName;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<Emp> getDepEmps() {
        return depEmps;
    }

    public void setDepEmps(List<Emp> depEmps) {
        this.depEmps = depEmps;
    }

    @Override
    public String toString() {
        return "Dep{" + "depId=" + depId + ", depName='" + depName + '\'' + ", depEmps=" + depEmps + '}';
    }
}
