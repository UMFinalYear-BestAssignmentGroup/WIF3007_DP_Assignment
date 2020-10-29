/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Melvin
 */
public interface FoodObserver {
    public void update(int slider, int length, String orientation);
    public void update(int scale);
}
