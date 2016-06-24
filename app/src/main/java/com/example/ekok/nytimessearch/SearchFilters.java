package com.example.ekok.nytimessearch;

/**
 * Created by ekok on 6/23/16.
 */
public class SearchFilters {
    String begin_date;
    String sort;
    String news_desk;

    public SearchFilters(String begin_date, String sort, String news_desk) {
        this.begin_date = begin_date;
        this.sort = sort;
        this.news_desk = news_desk;
    }

    public String getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(String begin_date) {
        this.begin_date = begin_date;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getNews_desk() {
        return news_desk;
    }

    public void setNews_desk(String news_desk) {
        this.news_desk = news_desk;
    }
}
