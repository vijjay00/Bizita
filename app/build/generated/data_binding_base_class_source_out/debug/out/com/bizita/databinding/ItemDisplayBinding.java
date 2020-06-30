// Generated by data binding compiler. Do not edit!
package com.bizita.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bizita.R;
import com.bizita.data.Succes;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemDisplayBinding extends ViewDataBinding {
  @NonNull
  public final TextView address;

  @NonNull
  public final TextView category;

  @NonNull
  public final AppCompatImageView image;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView noImage;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final RelativeLayout relative;

  @NonNull
  public final TextView retry;

  @Bindable
  protected Succes mModel;

  protected ItemDisplayBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView address, TextView category, AppCompatImageView image, TextView name,
      TextView noImage, ProgressBar progressBar, RelativeLayout relative, TextView retry) {
    super(_bindingComponent, _root, _localFieldCount);
    this.address = address;
    this.category = category;
    this.image = image;
    this.name = name;
    this.noImage = noImage;
    this.progressBar = progressBar;
    this.relative = relative;
    this.retry = retry;
  }

  public abstract void setModel(@Nullable Succes model);

  @Nullable
  public Succes getModel() {
    return mModel;
  }

  @NonNull
  public static ItemDisplayBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_display, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemDisplayBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemDisplayBinding>inflateInternal(inflater, R.layout.item_display, root, attachToRoot, component);
  }

  @NonNull
  public static ItemDisplayBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_display, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemDisplayBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemDisplayBinding>inflateInternal(inflater, R.layout.item_display, null, false, component);
  }

  public static ItemDisplayBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ItemDisplayBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemDisplayBinding)bind(component, view, R.layout.item_display);
  }
}
