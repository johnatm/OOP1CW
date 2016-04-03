/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapplication.model;

import javax.swing.ImageIcon;

/**
 *
 * @author John Sriskandarajah
 */
public interface DieIntf {
   
    ImageIcon getDieImage();
    void setImage(ImageIcon face);
    void setValue(int value);
    int getValue();
    
}
