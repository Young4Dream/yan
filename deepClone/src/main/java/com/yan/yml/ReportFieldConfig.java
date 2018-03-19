package com.yan.yml;

public class ReportFieldConfig {
    /** 报表字段标识 */
    private String name;

    /** 报表字段标题 */
    private String title;

    /** 报表字段逻辑脚本 */
    private String script;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
