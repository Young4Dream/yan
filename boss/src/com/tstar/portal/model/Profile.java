package com.tstar.portal.model;

public class Profile {
    private String id;

    private String sectionName;

    private String sectionAlias;

    private Integer sectionOrder;

    private String profileName;

    private String profileAlias;

    private Integer profileOrder;

    private String profileValue;

    private Integer visible;

    private Integer readonly;

    private Integer passwd;

    private String pattern;

    private String tip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName == null ? null : sectionName.trim();
    }

    public String getSectionAlias() {
        return sectionAlias;
    }

    public void setSectionAlias(String sectionAlias) {
        this.sectionAlias = sectionAlias == null ? null : sectionAlias.trim();
    }

    public Integer getSectionOrder() {
        return sectionOrder;
    }

    public void setSectionOrder(Integer sectionOrder) {
        this.sectionOrder = sectionOrder;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName == null ? null : profileName.trim();
    }

    public String getProfileAlias() {
        return profileAlias;
    }

    public void setProfileAlias(String profileAlias) {
        this.profileAlias = profileAlias == null ? null : profileAlias.trim();
    }

    public Integer getProfileOrder() {
        return profileOrder;
    }

    public void setProfileOrder(Integer profileOrder) {
        this.profileOrder = profileOrder;
    }

    public String getProfileValue() {
        return profileValue;
    }

    public void setProfileValue(String profileValue) {
        this.profileValue = profileValue == null ? null : profileValue.trim();
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Integer getReadonly() {
        return readonly;
    }

    public void setReadonly(Integer readonly) {
        this.readonly = readonly;
    }

    public Integer getPasswd() {
        return passwd;
    }

    public void setPasswd(Integer passwd) {
        this.passwd = passwd;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern == null ? null : pattern.trim();
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip == null ? null : tip.trim();
    }
}