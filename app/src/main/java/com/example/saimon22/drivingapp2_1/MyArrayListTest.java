package com.example.saimon22.drivingapp2_1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SAimon22 on 11/29/2017.
 */
public class MyArrayListTest {


    @Test
    public void clear() throws Exception {
        MyArrayList newMyList= new MyArrayList();
        newMyList.add("a");
        Assert.assertTrue(newMyList.get(0).equals("a"));
        newMyList.clear();
        Assert.assertTrue(newMyList.isEmpty());
    }


    @Test
    public void size() throws Exception {
        MyArrayList newMyList= new MyArrayList();
        newMyList.add("a");
        Assert.assertTrue(newMyList.size()==1);
        newMyList.clear();
        Assert.assertTrue(newMyList.size()==0);
    }

    @Test
    public void isEmpty() throws Exception {
        MyArrayList newMyList= new MyArrayList();
        newMyList.add("a");

    }

    @Test
    public void get() throws Exception {
        MyArrayList newMyList= new MyArrayList();
        newMyList.add("a");
        newMyList.add("b");
        newMyList.add("c");

        Assert.assertTrue(newMyList.get(1).equals("b"));
        Assert.assertTrue(newMyList.get(2).equals("c"));

    }

    @Test
    public void set() throws Exception {
        MyArrayList newMyList= new MyArrayList();
        newMyList.add("a");
        newMyList.add("b");
        newMyList.add("c");
        newMyList.set(2,"a");
        Assert.assertTrue(newMyList.get(1).equals("b"));
        Assert.assertTrue(newMyList.get(2).equals("a"));
    }

    @Test
    public void add() throws Exception {
        MyArrayList newMyList= new MyArrayList();
        newMyList.add("a");
        newMyList.add("d");
        newMyList.add("c");
        newMyList.set(1,"a");
        Assert.assertTrue(newMyList.get(1).equals("a"));
        Assert.assertTrue(newMyList.get(2).equals("c"));
    }



    @Test
    public void remove() throws Exception {
        MyArrayList newMyList= new MyArrayList();
        newMyList.add("a");
        newMyList.add("d");
        newMyList.add("c");
        newMyList.remove(2);
        Assert.assertTrue(newMyList.get(1).equals("d"));
        Assert.assertTrue(newMyList.size()==2);
    }

}