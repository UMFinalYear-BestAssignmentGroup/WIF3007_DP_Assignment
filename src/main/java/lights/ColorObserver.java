/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lights;

/**
 *
 * @author Mahirah binti Mansor
 */
public class ColorObserver extends LightObserver{

    public ColorObserver(Light light) {
        this.lights = light;
    }

    @Override
    public void update() {
        lights.resetLights(lights.getLights(), lights.color);
    }
    
}
