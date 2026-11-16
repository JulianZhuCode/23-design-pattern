package com.zhuzz.design.patternz.prototype.resumeclone;

/**
 * 原型：简历，实现 Cloneable 并做深拷贝（连同工作经历一起克隆）
 * Prototype: resume; deep-copies the work experience together with itself
 */
public class Resume implements Cloneable {
    private String name;
    private WorkExperience experience;

    public Resume(String name, WorkExperience experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkExperience getExperience() {
        return experience;
    }

    public void setExperience(WorkExperience experience) {
        this.experience = experience;
    }

    /**
     * 深拷贝：同时克隆工作经历，避免与原型共享同一引用
     * Deep copy: clones the experience so it is not shared with the prototype
     */
    @Override
    public Resume clone() {
        try {
            Resume cloned = (Resume) super.clone();
            cloned.experience = this.experience.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone not supported", e);
        }
    }

    @Override
    public String toString() {
        return "Resume [name=" + name + ", experience=" + experience + "]";
    }
}