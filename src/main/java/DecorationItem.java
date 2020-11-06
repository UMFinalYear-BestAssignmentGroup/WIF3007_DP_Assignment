/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SyafiqRazak
 */
public interface DecorationItem {
    void selectDecoration();
    void resize(double scale);
    void resize(double scale, DecorationItem di);
    void rotate(double degree, DecorationItem di);
    void location(double slider, int length, String orientation, DecorationItem di);
}
