package com.glqdlt.pm6.api.model.book;

import com.glqdlt.pm6.api.model.author.Author;

import java.util.List;

public abstract class BookReviews<A extends Author, B extends Book<A>> {

    private B book;
    private List<BookReview> reviews;

    public B getBook() {
        return book;
    }

    public List<BookReview> getReviews() {
        return this.reviews;
    }

    public void setBook(B book) {
        this.book = book;
    }

    public void setReviews(List<BookReview> reviews) {
        this.reviews = reviews;
    }
}
