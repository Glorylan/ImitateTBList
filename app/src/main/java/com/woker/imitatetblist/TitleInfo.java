package com.woker.imitatetblist;

/**
 * 标题信息
 */

public class TitleInfo {
    private String id;
    private String name;

    public TitleInfo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
