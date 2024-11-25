package org.example;

public class WiseSayingSetting {
    private final int id;
    private String author;
    private String comment;

    public WiseSayingSetting(int id , String author , String comment) {
        this.id = id;
        this.author = author;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toString() {
        return "id = " + id + "\n작가 = " + author + "\n명언 = " + comment + "\n";
    }
}
