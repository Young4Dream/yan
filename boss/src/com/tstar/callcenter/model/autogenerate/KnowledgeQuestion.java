package com.tstar.callcenter.model.autogenerate;

public class KnowledgeQuestion {
    private Long id;

    private String content;

    private String subUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSubUser() {
        return subUser;
    }

    public void setSubUser(String subUser) {
        this.subUser = subUser == null ? null : subUser.trim();
    }
}