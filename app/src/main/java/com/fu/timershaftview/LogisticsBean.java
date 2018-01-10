package com.fu.timershaftview;

/**
 * Created by Fu.
 * QQ:908323236
 * 2018/1/10 14:37
 * <p>
 * 物流详情的实体类
 */

public class LogisticsBean {
    private String date;            //日期
    private String time;            //时间
    private int state;              //状态
    private String title;           //标题
    private String content;         //内容

    public LogisticsBean(String date, String time, int state, String title, String content) {
        this.date = date;
        this.time = time;
        this.state = state;
        this.title = title;
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
