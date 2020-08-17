// IBookM.aidl
package com.bing.bingdemo.adil;

import com.bing.bingdemo.adil.Book1;
interface IBookM {
    oneway void addBook(in Book book);
    void addBookList(in List<Book> book);
    void addMap(in Map map);
    List<Book> getBookList();
}
