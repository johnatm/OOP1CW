/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapplication.controller;

/**
 *
 * @author John Sriskandarajah
 */
import gameapplication.view.UIPanel;
import gameapplication.model.Dice;
import gameapplication.view.GameUI;
import gameapplication.view.PlayingUI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class GameController {

    public static Dice dice;
    public static String player1;
    public static String player2;
    public static int targetScore;
    public static PlayingUI mainUI;
    public static int noOfDice = 5;
    public static int player1Wins;
    public static int player2Wins;
    public static int player1Lost;
    public static int player2Lost;
    public static int player1Score;
    public static int player1Attempts;
    public static int player2Score;
    public static int player2Attempts;
  //  private final File GameFile = new File("gameFile.txt");

    public static void main(String[] args) {

        dice = new Dice();
        player1 = "Computer Player";
      // readFromFile();

        GameUI gameUI = new GameUI();
        gameUI.setLocationRelativeTo(null);
        gameUI.setVisible(true);

    }

    public static void reset() {

        player1Score = 0;
        player2Score = 0;
        player1Attempts = 0;
        player2Attempts = 0;

        mainUI = new PlayingUI();
        mainUI.setLocationRelativeTo(null);
        mainUI.setVisible(true);
    }

    public synchronized static void readFromFile() {
// if (!(GameFile.exists())) { // Existence
//            fileOut = new FileOutputStream(GameFile); // creating the file
//            scoreOutputStream(score); // saving the null object
//
//        }
        File GameFile = new File("..\\controller\\gameFile.txt");

        try {

            Scanner sc = new Scanner(GameFile);
            StringBuilder stb = new StringBuilder();

            while (sc.hasNextLine()) {
                stb.append(sc.nextLine());
                stb.append(" ");
            }

            String[] arr = stb.toString().split("");

           player1Wins = Integer.parseInt(arr[0]);
            player1Lost = Integer.parseInt(arr[1]);
            player2Wins = Integer.parseInt(arr[2]);
            player2Lost = Integer.parseInt(arr[3]);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "gameFile.txt is missing", "The game file Missing!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public synchronized static void saveGameDetails() {
        FileWriter fWriter = null;
        BufferedWriter bWrite = null;

        try {
            File file = new File("gameFile.txt");
            fWriter = new FileWriter(file);
            bWrite = new BufferedWriter(fWriter);
            bWrite.write(player1Wins);
            bWrite.newLine();
            bWrite.write(player1Lost);
            bWrite.newLine();
            bWrite.write(player2Wins);
            bWrite.newLine();
            bWrite.write(player2Lost);
            bWrite.newLine();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "gameFile.txt is missing", "GameFile Missing!", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {

        } finally {
            try {
                fWriter.close();
                bWrite.close();
            } catch (IOException ex) {

            }
        }
    }

}
