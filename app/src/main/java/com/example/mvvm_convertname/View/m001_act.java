package com.example.mvvm_convertname.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;

import com.example.mvvm_convertname.R;
import com.example.mvvm_convertname.ViewModel.m001_VM;
import com.example.mvvm_convertname.databinding.ActivityMainBinding;

public class m001_act extends base_Act<ActivityMainBinding, m001_VM> {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    protected Class<m001_VM> getVM_Class() {
        return m001_VM.class;
    }

    @Override
    protected void initViews() {

        viewModel.fullName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvRs.setText(s.toString());
            }
        });
            binding.edtFisrtName.addTextChangedListener(new UpdateEditText() {
                @Override
                public void afterTextChanged(Editable editable) {
                    updateUI() ;
                }
            });
        binding.edtLastName.addTextChangedListener(new UpdateEditText() {
            @Override
            public void afterTextChanged(Editable editable) {
                updateUI() ;
            }
        });
        binding.scCv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                updateUI();
            }
        });

    }

    private void updateUI() {
        viewModel.updateIn4(binding.edtFisrtName.getText().toString(),binding.edtLastName.getText().toString(),binding.scCv.isChecked()) ;

    }

    @Override
    protected ActivityMainBinding initViewBindings() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onClick(View v) {

    }
}