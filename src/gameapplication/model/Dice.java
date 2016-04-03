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

import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;

public class Dice {
    
    private Die[] dice;
        
       public Dice() {
           /*I have created an array which will hold six die images,
           I have assigned it to a variable called dice. Then I have created a for loop which will iterate through the die array.
           I have created an image variable which is set to this array this will iterate through images 
           and the image variable will be set to each index in the array.
           */
           dice = new Die[6];
           
           for(int x = 0; x < dice.length; x++){
               
               dice[x] = new Die();
               dice[x].setValue(x+1);
               URL dieImageURL = getClass().getResource("..\\images\\" +(x+1) +".png");
               dice[x].setImage(new ImageIcon(dieImageURL));
           }
       }
    
    public synchronized Die[] roll(int numberInDice) {
           
           Random random = new Random();
           Die[] roll= new Die[numberInDice];
           
           for(int x = 0; x < numberInDice; x++) {
            
               roll[x] = dice[random.nextInt(dice.length)];               
           }
           return roll;
       }
     public synchronized ImageIcon[] getDieFaceImage() {
           
           ImageIcon[] dieFacesImage = new ImageIcon[dice.length];
           
           for(int x = 0; x < dieFacesImage.length; x++) {
               
               dieFacesImage[x] = dice[x].getDieImage();
           }
           return dieFacesImage;
       } 
}
