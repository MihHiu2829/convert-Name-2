package com.example.mvvm_convertname.View;

import android.text.Editable;
import android.text.TextWatcher;

public interface UpdateEditText extends TextWatcher {


    default  void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    default void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) ;
}
