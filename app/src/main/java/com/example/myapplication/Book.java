package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String title;
    private String author;
    private int pageCount;

    public Book() {
        // Порожній конструктор, що не приймає аргументів
    }

    protected Book(Parcel in) {
        title = in.readString();
        author = in.readString();
        pageCount = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(author);
        dest.writeInt(pageCount);
    }
}
