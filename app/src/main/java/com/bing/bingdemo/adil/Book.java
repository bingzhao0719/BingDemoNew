package com.bing.bingdemo.adil;

import android.os.Parcel;
import android.os.Parcelable;

public final class Book implements Parcelable {
    public int bookId;
    public String bookName;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.bookId);
        dest.writeString(this.bookName);
    }
    public void readFromParcel(Parcel parcel){
        this.bookId = parcel.readInt();
        this.bookName = parcel.readString();
    }

    public Book() {
        bookName = "";
    }

    protected Book(Parcel in) {
        this.bookId = in.readInt();
        this.bookName = in.readString();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };


    public static void main(String[] args) {
        int [] nums ={2,7,11,15};
        int target = 9;
        search(nums,target);
    }
    private static void search(int [] nums,int target){
        int length = nums.length;
        int start = 0;
        int next = 1;
        for (int i = next; i < length; i++) {
            if(nums[start] + nums[next] == target){
                System.out.println(start+","+next);
            }
        }
        while (true){
            if(nums[start] + nums[next] == target){
                System.out.println(start+","+next);
                break;
            }
            next++;
            if(next == length){
                start++;
                next = start + 1;
            }
        }
    }
}
