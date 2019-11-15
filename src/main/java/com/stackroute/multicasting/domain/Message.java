package com.stackroute.multicasting.domain;

public class Message {
    private String fromName;
    private String toName;
    private String content;

    public String getFromName() {
        return fromName;
    }

    public Message(String fromName, String toName, String content) {
        this.fromName = fromName;
        this.toName = toName;
        this.content = content;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
