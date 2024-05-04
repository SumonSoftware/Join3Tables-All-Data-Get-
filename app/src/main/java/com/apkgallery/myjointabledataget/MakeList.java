package com.apkgallery.myjointabledataget;

import java.util.ArrayList;
import java.util.HashMap;

public class MakeList {

    ////   Book and Authors Table Data get Code =============

    public static ArrayList<ArrayList<HashMap<String, String>>> rootArrayList;
    public static ArrayList<HashMap<String, String>> bookTableArrayList;
    public static ArrayList<HashMap<String, String>> authorsTableArrayList;
    public static HashMap<String, String> hashMap;

    //--------------------------------------------------------------------------------------------

    //========================================================================

    public static void bookList(String BooksTable_id, String BooksTable_title,String BooksTable_subTitle) {

        rootArrayList.add(authorsTableArrayList);
        hashMap = new HashMap<>();
        hashMap.put("BooksTable_id", BooksTable_id);
        hashMap.put("BooksTable_title", BooksTable_title);
        hashMap.put("BooksTable_subTitle", BooksTable_subTitle);
        bookTableArrayList.add(hashMap);
        authorsTableArrayList = new ArrayList<>();


    }

    //========================================================================

    public static void authorsList(String AuthorsTable_id, String AuthorsTable_title,String AuthorsTable_subTitle) {

        hashMap = new HashMap<>();
        hashMap.put("AuthorsTable_id", AuthorsTable_id);
        hashMap.put("AuthorsTable_title", AuthorsTable_title);
        hashMap.put("AuthorsTable_subTitle", AuthorsTable_subTitle);
        authorsTableArrayList.add(hashMap);


    }



}
