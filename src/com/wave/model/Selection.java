package com.wave.model;

import java.util.Date;

public class Selection {
    private Integer selectionid;

    private Integer studentid;

    private Integer titleid;

    private Byte articleScore;

    private Byte oralScore;

    private String comment;

    private Date createAt;

    public Integer getSelectionid() {
        return selectionid;
    }

    public void setSelectionid(Integer selectionid) {
        this.selectionid = selectionid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getTitleid() {
        return titleid;
    }

    public void setTitleid(Integer titleid) {
        this.titleid = titleid;
    }

    public Byte getArticleScore() {
        return articleScore;
    }

    public void setArticleScore(Byte articleScore) {
        this.articleScore = articleScore;
    }

    public Byte getOralScore() {
        return oralScore;
    }

    public void setOralScore(Byte oralScore) {
        this.oralScore = oralScore;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}