package com.example.onlineeduplatformlecture.domain;

public class Content {

    private final int contentId;
    private final int lectureId;
    private final String content;

    public Content(int contentId, int lectureId, String content) {
        this.contentId = contentId;
        this.lectureId = lectureId;
        this.content = content;
    }

    public int getContentId() {
        return contentId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public String getContent() {
        return content;
    }
}
