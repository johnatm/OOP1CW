/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapplication.model;

/**
 *
 * @author John Sriskandarajah
 */


import javax.swing.ImageIcon;


public class Die implements DieIntf, Comparable<Die> {
    private ImageIcon dieFace;
    private int faceValue;
    

    @Override
    public ImageIcon getDieImage() {
        
        return dieFace;
    }

    @Override
    public void setImage(ImageIcon face) {
        this.dieFace=face;
    }

    @Override
    public void setValue(int value) {
       this.faceValue=value;
    }

    @Override
    public int getValue() {
        return this.faceValue;
    }

    @Override
    public int compareTo(Die o) {
         if(this.faceValue < o.getValue()) {
            return -1;
        }
        else if (this.faceValue > o.getValue()) {
            return 1;
        }
        else {
            return 0;
        }
    }
  
}
