package com.example.samrat.tutorials;

public class StoreList {

    String topicname,topiclink,type1;

    public StoreList(String topicname, String topiclink, String type1) {
        this.topicname = topicname;
        this.topiclink = topiclink;
        this.type1 = type1;
    }

    public String getTopicname() {
        return topicname;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public String getTopiclink() {
        return topiclink;
    }

    public void setTopiclink(String topiclink) {
        this.topiclink = topiclink;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }
}
