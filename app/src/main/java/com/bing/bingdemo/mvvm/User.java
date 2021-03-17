package com.bing.bingdemo.mvvm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.bing.bingdemo.BR;

public class User extends BaseObservable {
    public String firstName;
    public String lastName;
    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
