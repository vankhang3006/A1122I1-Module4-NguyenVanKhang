package com.codegym.model;

public class Mail {
    private int id;
    private String language;
    private int page;
    private boolean filter;
    private String signature;

    public Mail() {
    }

    public Mail(int id, String language, int page, boolean filter, String signature) {
        this.id = id;
        this.language = language;
        this.page = page;
        this.filter = filter;
        this.signature = signature;
    }

    public Mail(String language, int page, boolean filter, String signature) {
        this.language = language;
        this.page = page;
        this.filter = filter;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
