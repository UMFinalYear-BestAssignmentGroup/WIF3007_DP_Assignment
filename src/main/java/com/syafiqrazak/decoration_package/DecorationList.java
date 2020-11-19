///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.syafiqrazak.decoration_package;
//
//
//import java.util.ArrayList;
//import javafx.scene.layout.Pane;
///**
// *
// * @author syafiqrazak
// */
//public class DecorationList {
//
//    private ArrayList<DecorationItem> array = new ArrayList<>();
//    private static DecorationList instance = new DecorationList();
//
//    public DecorationList() {
//    }
//
//    public static synchronized DecorationList getInstance() {
//        return instance;
//    }
//
//    public ArrayList<DecorationItem> getArray() {
//        return array;
//    }
//
//    public synchronized DecorationItem addDecorationItem(DecorationItem decoitem) {
//        decoitem.setId(getSimilarClass(decoitem));
//        array.add(decoitem);
//        
//        System.out.println("Added: "+decoitem.getNameId());
//        
//        return decoitem;
//    }
//
//    public synchronized void removeDecorationItem(String id, Pane designPane) {
//        int index = getIndex(id);
//        designPane.getChildren().remove(array.get(index));
//        array.remove(index);
//    }
//    
//    public synchronized DecorationItem getDecorationItem(String id) {
//        int index = getIndex(id);
//        return array.get(index);
//    }
//
//    private int getSimilarClass(DecorationItem decoitem) {
//        int tmp = 0;
//        for (int i = 0; i < array.size(); i++) {
//            if (array.get(i).getClass() == decoitem.getClass()) {
//                tmp++;
//            }
//        }
//        return tmp;
//    }
//    
//    private int getIndex(String id) {
//        for(int i = 0; i < array.size(); i++) {
//           if(array.get(i).getNameId().equals(id)) {
//               return i;
//           } 
//        }
//        return -1;
//    }
//}
