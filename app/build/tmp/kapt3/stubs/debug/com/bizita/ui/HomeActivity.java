package com.bizita.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0016\u001a\u00020\u000f2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u001c"}, d2 = {"Lcom/bizita/ui/HomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bizita/viewmodel/HomeVM$HomeAuthlistner;", "()V", "linear", "Landroidx/recyclerview/widget/LinearLayoutManager;", "listAdapter", "Lcom/bizita/ui/adapter/HomeAdapter;", "viewModle", "Lcom/bizita/viewmodel/HomeVM;", "getViewModle", "()Lcom/bizita/viewmodel/HomeVM;", "setViewModle", "(Lcom/bizita/viewmodel/HomeVM;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onError", "message", "", "onRetry", "onSucess", "detailsList", "Ljava/util/ArrayList;", "Lcom/bizita/data/Succes;", "Lkotlin/collections/ArrayList;", "setAdapter", "app_debug"})
public abstract class HomeActivity extends androidx.appcompat.app.AppCompatActivity implements com.bizita.viewmodel.HomeVM.HomeAuthlistner {
    private androidx.recyclerview.widget.LinearLayoutManager linear;
    private com.bizita.ui.adapter.HomeAdapter listAdapter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.bizita.viewmodel.HomeVM getViewModle();
    
    public abstract void setViewModle(@org.jetbrains.annotations.NotNull()
    com.bizita.viewmodel.HomeVM p0);
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setAdapter() {
    }
    
    @java.lang.Override()
    public void onSucess(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.bizita.data.Succes> detailsList) {
    }
    
    @java.lang.Override()
    public void onRetry(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @java.lang.Override()
    public void onError(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public HomeActivity() {
        super();
    }
}