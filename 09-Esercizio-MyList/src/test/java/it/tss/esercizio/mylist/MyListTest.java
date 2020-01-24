/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.esercizio.mylist;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author tss
 */
public class MyListTest {

    public MyListTest() {

    }

    @Test
    public void create() {
        String[] start = {"A", "B", "C"};
        TssList<String> list = new TssList(start);
        Assert.assertTrue(list.contains("A") && list.contains("B") && list.contains("C"));
    }

    @Test
    public void add() {
        String[] start = {"A", "B", "C"};
        TssList<String> list = new TssList(start);
        list.add("D");
        Assert.assertTrue(list.contains("D"));
    }

    @Test
    public void remove() {
        String[] start = {"A", "B", "C"};
        TssList<String> list = new TssList(start);
        list.remove("A");
        Assert.assertTrue(!list.contains("A"));
    }

    @Test
    public void containsAll() {
        String[] start = {"A", "B", "C"};
        TssList<String> list = new TssList(start);
        String[] tmp = {"C", "B"};
        Assert.assertTrue(list.containsAll(Arrays.asList(tmp)));
        String[] tmp1 = {"H", "B"};
        Assert.assertFalse(list.containsAll(Arrays.asList(tmp1)));
    }

    @Test
    public void retainAll() {
        String[] start = {"A", "B", "C"};
        TssList<String> list = new TssList(start);
        String[] tmp = {"C", "B"};
        list.retainAll(Arrays.asList(tmp));
        System.out.println(list);
        Assert.assertTrue(!list.contains("A") && list.contains("B") && list.contains("C"));

    }
}
