package com.example.mvvm_convertname.ViewModel;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class m001_VM extends ViewModel {
    private MutableLiveData<String> firstName = new MutableLiveData<>()  ;
    private MutableLiveData<String> lastName = new MutableLiveData<>()  ;
    private MutableLiveData<Boolean> isEn = new MutableLiveData<>(false) ;

    public void updateIn4(String fisrtName, String lastName, boolean isCheck) {
        this.firstName.postValue(fisrtName);
        this.lastName.postValue(lastName);
        this.isEn.postValue(isCheck);
    }

    public MutableLiveData<String> getLastName() {
        return lastName;
    }

    public MutableLiveData<String> getFirstName() {
        return firstName;
    }

    public MutableLiveData<Boolean> getIsEn() {
        return isEn;
    }

        public MediatorLiveData<String> fullName() {

        MediatorLiveData<String> Mediator = new MediatorLiveData<>() ;


            Observer<Object> handlName = new Observer<Object>() {
                @Override
                public void onChanged(Object o) {
                    if(isEn.getValue() == true)
                        Mediator.postValue(lastName.getValue() +" " + firstName.getValue());
                    else
                        Mediator.postValue(firstName.getValue() +" "+ lastName.getValue()) ;
                }
            } ;
            Mediator.addSource(firstName,handlName);
        Mediator.addSource(lastName,handlName);
        Mediator.addSource(isEn,handlName);
        return Mediator ;
    }




}
