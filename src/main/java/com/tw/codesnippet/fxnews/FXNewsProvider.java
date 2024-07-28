package com.tw.codesnippet.fxnews;

public class FXNewsProvider {

    private FXNewsListener fxNewsListener;

    private FXNewsPersister fxNewsPersister;

    public FXNewsProvider(FXNewsListener fxNewsListener, FXNewsPersister fxNewsPersister) {
        this.fxNewsListener = fxNewsListener;
        this.fxNewsPersister = fxNewsPersister;
    }

    public void getAndPersistNews() {
        System.out.println("register and wire fxNewsProvider successfully");
    }
}
