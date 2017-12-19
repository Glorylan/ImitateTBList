package com.woker.imitatetblist;

/**
 * 内容信息
 */

public class ContentInfo {

    private String title;
    private String planTime;
    private String endTime;
    private String status;

    public ContentInfo(String title, String planTime, String endTime, String status) {

        this.title = title;
        this.planTime = planTime;
        this.endTime = endTime;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlanTime() {
        return planTime;
    }

    public void setPlanTime(String planTime) {
        this.planTime = planTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
