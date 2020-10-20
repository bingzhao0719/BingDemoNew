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

public class BookService extends Service {
    public BookService() {
    }

    private List<Book> bookList = new ArrayList<>();

    private int type = 1;

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

    private Binder binder2 = new IBookM.Stub() {
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
        type = intent.getIntExtra("test",1);
        Log.i("wubingzhao", "onBind: " +"--"+Thread.currentThread()+" type:"+type);
        return type == 1 ? binder : binder2;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("wubingzhao", "onStartCommand startId: " +startId+" flags:"+flags);
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("wubingzhao", "onCreate: " +"--"+Thread.currentThread());
        Book book = new Book();
        book.bookId = 11;
        book.bookName = "蔡智慧书";
        bookList.add(book);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("wubingzhao", "onUnbind: ");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i("wubingzhao", "onDestroy: ");
        super.onDestroy();
    }
}
