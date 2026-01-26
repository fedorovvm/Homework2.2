package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
    String titleArticle;
    String textArticle;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(titleArticle, article.titleArticle) && Objects.equals(textArticle, article.textArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleArticle, textArticle);
    }

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

    @Override
    public String getTitle() {
       return titleArticle;
    }

    public String gettingSearchTerm() {
        return this.titleArticle + " " + this.textArticle;
    }

}
