package com.example.mvvm_convertname.View;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

public abstract  class base_Act <T extends ViewBinding, M extends ViewModel> extends AppCompatActivity implements View.OnClickListener {

    protected  T binding ;
    protected  M viewModel  ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =initViewBindings() ;
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(getVM_Class()) ;
        initViews();

    }

    protected abstract Class<M> getVM_Class();

    protected abstract void initViews();

    protected abstract T initViewBindings();
}
