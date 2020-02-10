/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testarea;

/**
 *
 * @author D.Porter
 */
public interface StopClock {
    StopClock start(String label);

    StopClock pause(String label);

    StopClock measure(String label);

    StopClock reset(String label);
}
