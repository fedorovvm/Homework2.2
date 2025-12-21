package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

public final class Article implements Searchable {
    String titleArticle;
    String textArticle;

    public Article(String titleArticle, String textArticle) {
        this.titleArticle = titleArticle;
        this.textArticle = textArticle;
    }

    public String getTitleArticle() {
        return titleArticle;
    }

    public String getTextArticle() {
        return textArticle;
    }
    @Override
    public String toString() {
        return getTitleArticle() + "\n" + getTextArticle();
    }

    public String gettingContentType() {
        return "ARTICLE";
    }

    public String gettingSearchTerm() {
        return this.titleArticle + " " + this.textArticle;
    }

}
