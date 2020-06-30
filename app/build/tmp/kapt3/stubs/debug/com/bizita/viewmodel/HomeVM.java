package com.bizita.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/bizita/viewmodel/HomeVM;", "Landroidx/lifecycle/ViewModel;", "()V", "progress_bar", "Landroidx/lifecycle/MutableLiveData;", "", "getProgress_bar", "()Landroidx/lifecycle/MutableLiveData;", "retry", "getRetry", "getload", "", "homeActivity", "Lcom/bizita/ui/HomeActivity;", "onProgressVisible", "onRetry", "onRetryApi", "HomeAuthlistner", "app_debug"})
public final class HomeVM extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> progress_bar = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> retry = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getProgress_bar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getRetry() {
        return null;
    }
    
    public final void getload(@org.jetbrains.annotations.NotNull()
    com.bizita.ui.HomeActivity homeActivity) {
    }
    
    public final void onProgressVisible() {
    }
    
    public final void onRetry() {
    }
    
    public final void onRetryApi(@org.jetbrains.annotations.NotNull()
    com.bizita.ui.HomeActivity homeActivity) {
    }
    
    public HomeVM() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0007\u001a\u00020\u00032\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/bizita/viewmodel/HomeVM$HomeAuthlistner;", "", "onError", "", "message", "", "onRetry", "onSucess", "detailsList", "Ljava/util/ArrayList;", "Lcom/bizita/data/Succes;", "Lkotlin/collections/ArrayList;", "app_debug"})
    public static abstract interface HomeAuthlistner {
        
        public abstract void onSucess(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.bizita.data.Succes> detailsList);
        
        public abstract void onRetry(@org.jetbrains.annotations.NotNull()
        java.lang.String message);
        
        public abstract void onError(@org.jetbrains.annotations.NotNull()
        java.lang.String message);
    }
}