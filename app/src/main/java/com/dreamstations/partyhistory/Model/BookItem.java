package com.dreamstations.partyhistory.Model;

import java.io.Serializable;

/**
 * Created by QYH on 2015/12/11.
 */
public class BookItem implements Serializable{
    int id;

    String title;

    String author;
    String publisher;
    String publicationDate;
    String introduction;
    String imgURL;
    String downloadURL;
    public BookItem(int id,String title, String author, String publisher, String publicationDate, String introduction, String imgURL, String downloadURL) {
        this.id=id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.introduction = introduction;
        this.imgURL = imgURL;
        this.downloadURL = downloadURL;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }
}
