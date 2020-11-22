/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syafiqrazak.decoration_package;
/**
 *
 * @author SyafiqRazak
 */
public interface DecorationItem {
    void selectDecoration();
    void resize(double scale, DecorationItem di);
    void rotate(double degree, DecorationItem di);
    void location(double slider, int length, String orientation, DecorationItem di);
    void setVisibility(boolean visible, DecorationItem di);
    double getSize(DecorationItem di);
    double getXCoordinate(DecorationItem di);
    double getYCoordinate(DecorationItem di);
    double getRotation(DecorationItem di);
    boolean getVisibility(DecorationItem di);
    
}
