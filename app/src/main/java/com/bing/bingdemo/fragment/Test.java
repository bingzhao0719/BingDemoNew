package com.bing.bingdemo.fragment;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Test implements Parcelable {
    private int age;
    private String name;
    private int id;

    protected Test(Parcel in) {
        age = in.readInt();
        name = in.readString();
        id = in.readInt();
    }
    protected Test() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeString(name);
        dest.writeInt(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Test> CREATOR = new Creator<Test>() {
        @Override
        public Test createFromParcel(Parcel in) {
            return new Test(in);
        }

        @Override
        public Test[] newArray(int size) {
            return new Test[size];
        }
    };

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
