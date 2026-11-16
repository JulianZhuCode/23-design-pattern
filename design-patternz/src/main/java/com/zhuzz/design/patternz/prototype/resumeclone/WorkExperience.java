package com.zhuzz.design.patternz.prototype.resumeclone;

/**
 * 工作经历：作为简历的引用类型成员，深拷贝时需要一并克隆
 * Work experience: a reference-typed field that must be cloned too for a deep copy
 */
public class WorkExperience implements Cloneable {
    private String company;
    private String years;

    public WorkExperience(String company, String years) {
        this.company = company;
        this.years = years;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    @Override
    public WorkExperience clone() {
        try {
            return (WorkExperience) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported", e);
        }
    }

    @Override
    public String toString() {
        return company + " (" + years + ")";
    }
}