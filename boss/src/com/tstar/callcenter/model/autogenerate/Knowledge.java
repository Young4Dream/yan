package com.tstar.callcenter.model.autogenerate;

public class Knowledge {
    private Long klId;

    private String klTitle;

    private Long klcId;

    private String klFileUrl;

    private String klContent;

    public Long getKlId() {
        return klId;
    }

    public void setKlId(Long klId) {
        this.klId = klId;
    }

    public String getKlTitle() {
        return klTitle;
    }

    public void setKlTitle(String klTitle) {
        this.klTitle = klTitle == null ? null : klTitle.trim();
    }

    public Long getKlcId() {
        return klcId;
    }

    public void setKlcId(Long klcId) {
        this.klcId = klcId;
    }

    public String getKlFileUrl() {
        return klFileUrl;
    }

    public void setKlFileUrl(String klFileUrl) {
        this.klFileUrl = klFileUrl == null ? null : klFileUrl.trim();
    }

    public String getKlContent() {
        return klContent;
    }

    public void setKlContent(String klContent) {
        this.klContent = klContent == null ? null : klContent.trim();
    }
}