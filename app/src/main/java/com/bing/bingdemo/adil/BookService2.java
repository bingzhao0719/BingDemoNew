package com.bing.bingdemo.adil;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookService2 extends Service {
    public BookService2() {
    }

    private List<Book> bookList = new ArrayList<>();

    private Binder binder = new IBookM.Stub() {
        @Override
        public void addBook(Book book) throws RemoteException {
            Log.i("wubingzhao", "addBook: "+Thread.currentThread());
            Book book1 = new Book();
            book1.bookId = book.bookId;
            book1.bookName = book.bookName;
            bookList.add(book1);
            if(bookList.size() > 0){
                book.bookId = bookList.get(0).bookId;
                book.bookName = bookList.get(0).bookName;
            }
            SystemClock.sleep(2000);
        }

        @Override
        public void addBookList(List<Book> book) throws RemoteException {
            Log.i("wubingzhao", "addBookList book: "+book.getClass());
            bookList.addAll(book);
        }

        @Override
        public void addMap(Map map) throws RemoteException {

        }

        @Override
        public List<Book> getBookList() throws RemoteException {
            Log.i("wubingzhao", "getBookList: "+Thread.currentThread());
            return bookList;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("wubingzhao", "BookService2 onBind: " +"--"+Thread.currentThread());
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("wubingzhao", "BookService2 onStartCommand startId: " +startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("wubingzhao", "BookService2 onCreate: " +"--"+Thread.currentThread());
        Book book = new Book();
        book.bookId = 11;
        book.bookName = "蔡智慧书";
        bookList.add(book);
    }
}
