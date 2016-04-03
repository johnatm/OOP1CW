/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapplication.view;

/**
 *
 * @author John Sriskandarajah
 */
import gameapplication.controller.GameController;
import gameapplication.model.Die;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

public class PlayingUI extends JFrame{

    private Box.Filler filler1;
    private Box.Filler filler2;
    private JButton throwBtn;
    private JButton rerollBtn;
    private JButton restartBtn;
    private JButton scoreBtn;
    private JLabel headerLabel;
    private JLabel computerWinningLabel;
    private JLabel computerLostLabel;
    private JLabel targetNameLabel;
    private JLabel targetLabel;
    private JLabel HumanWinningNameLabel;
    private JLabel HumanWinningLabel;
    private JLabel computerWinningNameLabel;
    private JLabel HumanLostLabel;
    private JLabel HumanLostNameLabel;
    private JLabel computerLostNameLabel;
    private JPanel bottomPanel;
    private JPanel midPanel;
    private UIPanel computer;
    private UIPanel user;
    private JPanel statDisplayPanel;
    private boolean IsTie = false;

    public PlayingUI() {
        initComponents();
    }

    private void initComponents() {

        headerLabel = new JLabel();
        bottomPanel = new JPanel();
        throwBtn = new JButton();
        scoreBtn = new JButton();
        rerollBtn = new JButton();
        restartBtn = new JButton();
        filler1 = new Box.Filler(new Dimension(100, 0), new Dimension(100, 0), new Dimension(100, 32767));
        targetNameLabel = new JLabel();
        targetLabel = new JLabel();
        midPanel = new JPanel();
        statDisplayPanel = new JPanel();
        HumanWinningNameLabel = new JLabel();
        HumanWinningLabel = new JLabel();
        HumanLostNameLabel = new JLabel();
        HumanLostLabel = new JLabel();
        filler2 = new Box.Filler(new Dimension(100, 0), new Dimension(100, 0), new Dimension(100, 32767));
        computerWinningNameLabel = new JLabel();
        computerWinningLabel = new JLabel();
        computerLostNameLabel = new JLabel();
        computerLostLabel = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dice Pro");

        headerLabel.setFont(new java.awt.Font("Century Gothic", 1, 48));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        URL headerImageURL = getClass().getResource("..\\images\\rolling_dice1.png");
        headerLabel.setIcon(new ImageIcon(headerImageURL));
        headerLabel.setText("Dice Pro");
        getContentPane().add(headerLabel, BorderLayout.PAGE_START);

        throwBtn.setText("Throw Dice");
        throwBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                throwButtonActionPerformed(evt);
            }
        });

        bottomPanel.add(throwBtn);

        scoreBtn.setText("Show Score");
        scoreBtn.setEnabled(false);
        scoreBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                scoreButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(scoreBtn);

        rerollBtn.setText("Reroll Dice");
        rerollBtn.setEnabled(false);
        rerollBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                rerollButtonActionPerformed(evt);
            }
        });

        bottomPanel.add(rerollBtn);

        restartBtn.setText("Restart Game");
        restartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        bottomPanel.add(restartBtn);
        bottomPanel.add(filler1);

        targetNameLabel.setFont(new Font("sansserif", 1, 18));
        targetNameLabel.setText("Target Score: ");
        bottomPanel.add(targetNameLabel);

        targetLabel.setFont(new Font("sansserif", 1, 24));
        targetLabel.setForeground(new Color(204, 0, 0));
        targetLabel.setText(String.valueOf(GameController.targetScore));
        bottomPanel.add(targetLabel);

        getContentPane().add(bottomPanel, BorderLayout.PAGE_END);

        midPanel.setLayout(new BorderLayout());

        statDisplayPanel.setBorder(BorderFactory.createEtchedBorder());
        statDisplayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

        HumanWinningNameLabel.setFont(new Font("sansserif", 0, 18));
        HumanWinningNameLabel.setText("Human Player Wins");
        statDisplayPanel.add(HumanWinningNameLabel);

        HumanWinningLabel.setFont(new Font("sansserif", 1, 24));
        HumanWinningLabel.setForeground(new Color(0, 255, 102));
        HumanWinningLabel.setText(String.valueOf(GameController.player2Wins));
        statDisplayPanel.add(HumanWinningLabel);

        HumanLostNameLabel.setFont(new Font("sansserif", 0, 18));
        HumanLostNameLabel.setText("Human Player Lost");
        statDisplayPanel.add(HumanLostNameLabel);

        HumanLostLabel.setFont(new Font("sansserif", 1, 24));
        HumanLostLabel.setForeground(new Color(204, 51, 0));
        HumanLostLabel.setText(String.valueOf(GameController.player2Lost));
        statDisplayPanel.add(HumanLostLabel);
        statDisplayPanel.add(filler2);

        computerWinningNameLabel.setFont(new Font("sansserif", 0, 18));
        computerWinningNameLabel.setText("Computer Player Wins");
        statDisplayPanel.add(computerWinningNameLabel);

        computerWinningLabel.setFont(new Font("sansserif", 1, 24));
        computerWinningLabel.setForeground(new Color(204, 51, 0));
        computerWinningLabel.setText(String.valueOf(GameController.player1Wins));
        statDisplayPanel.add(computerWinningLabel);

        computerLostNameLabel.setFont(new Font("sansserif", 0, 18));
        computerLostNameLabel.setText("Computer Player Lost");
        statDisplayPanel.add(computerLostNameLabel);

        computerLostLabel.setFont(new Font("sansserif", 1, 24));
        computerLostLabel.setForeground(new Color(0, 255, 51));
        computerLostLabel.setText(String.valueOf(GameController.player1Lost));
        statDisplayPanel.add(computerLostLabel);

        midPanel.add(statDisplayPanel, BorderLayout.PAGE_END);

        computer = new UIPanel(GameController.player1, GameController.dice.getDieFaceImage(), GameController.noOfDice);
        midPanel.add(computer, BorderLayout.PAGE_START);
        user = new UIPanel(GameController.player2, GameController.dice.getDieFaceImage(), GameController.noOfDice);
        midPanel.add(user, BorderLayout.CENTER);

        getContentPane().add(midPanel, BorderLayout.CENTER);

        pack();
    }

    private void throwButtonActionPerformed(ActionEvent evt) {

        Throw();

        throwBtn.setEnabled(false);
        scoreBtn.setEnabled(true);
        rerollBtn.setEnabled(true);
//here it checks for if the scores are tie before the throw button is pressed.
//if there is a tie it will invoke the score method.
// the score method will get this boolean variable and make IsTie=true  
 //if the IsTie is true only the throw button will be enabled and no rethrows will be allowed       
        if (IsTie) {
            score();
        } else {

            computer.updateRerollsLeft(2);
            user.updateRerollsLeft(2);
            user.makeDiceSelectable();
        }

    }
    /*
    This is the restart button.
    Once this is clicked, the playing GUI will be closed and
    The Game UI will be opened
    
    */

    private void restartButtonActionPerformed(ActionEvent evt) {
           
        GameController.mainUI.dispose();
        GameUI launchUI = new GameUI();
        launchUI.setLocationRelativeTo(null);
        launchUI.setVisible(true);
    }

    private void scoreButtonActionPerformed(ActionEvent evt) {

        score();

    }
    /*
    Here I have created a separate button for reroll.
    This button will initially be disabled until a throw button is clicked. 
    Once the throw button is clicked the user will have the option to select the dice he wants to reroll.
    Inside this button it will check initially if there are rerolls left
    if there is rerolls left it will take the positions of the dice to reroll 
    and put them into an array which will store the selected positions of the dice.
    And it will reroll and update them in the UI and will update the rerolls left.

    */

    private void rerollButtonActionPerformed(ActionEvent evt) {

        if (user.getRerollsLeft() > 0) {

            int[] selectedDicePositions = user.getSelectedDicePositions();

            if (selectedDicePositions == null) {
                JOptionPane.showMessageDialog(null, "Please select the dices that you want to reroll", "Select Dice", JOptionPane.INFORMATION_MESSAGE);
            } else {
                roll(user, selectedDicePositions);
                user.updateRerollsLeft(user.getRerollsLeft() - 1);
                user.resetSelection();
            }
        }
        if (user.getRerollsLeft() == 0) {
            score();
        }
    }

    private void Throw() {

        int[] dicePositions = new int[GameController.noOfDice];

        for (int x = 0; x < dicePositions.length; x++) {
            dicePositions[x] = x;
        }
        roll(computer, dicePositions);
        roll(user, dicePositions);
    }
/*
    The below method checks who wins.
    This is done by the initial target the player sets.
    First it checks if the player1 score is greater than the target score or the player2 score is greater 
    than the target score.
    If the player1 score is greate than the target score it will display a message box saying the human 
    player won. If player2 score is great than target score computer user wins.
    
    */
    private void isWin() {

        if (!(GameController.player1Score > GameController.targetScore || GameController.player2Score > GameController.targetScore)) {
            return;
        }
        if (GameController.player2Score > GameController.targetScore && GameController.player2Attempts < GameController.player1Attempts) {
            JOptionPane.showMessageDialog(null, "Congratulations You Win!\nYou scored " + GameController.player2Score + " in " + GameController.player2Attempts + " attempts", "Congradulations", JOptionPane.INFORMATION_MESSAGE);
            GameController.player2Wins++;
            GameController.player1Lost++;
            GameController.mainUI.gameOver();

        } else if (GameController.player1Score > GameController.targetScore && GameController.player1Attempts < GameController.player2Attempts) {
            JOptionPane.showMessageDialog(null, "You Lose!\nYou scored " + GameController.player2Score + " in " + GameController.player2Attempts + " attempts", "Better Luck Next Time!", JOptionPane.INFORMATION_MESSAGE);
            GameController.player1Wins++;
            GameController.player2Lost++;
            GameController.mainUI.gameOver();

        } else if (GameController.player2Score > GameController.player1Score) {
            JOptionPane.showMessageDialog(null, "You Win!\nYou scored " + GameController.player2Score + " in " + GameController.player2Attempts + " attempts", "Congradulations", JOptionPane.INFORMATION_MESSAGE);
            GameController.player2Wins++;
            GameController.player1Lost++;
            GameController.mainUI.gameOver();

        } else if (GameController.player1Score > GameController.player2Score) {
            JOptionPane.showMessageDialog(null, "You Lose!\nYou scored " + GameController.player2Score + " in " + GameController.player2Attempts + " attempts", "Better Luck Next Time!", JOptionPane.INFORMATION_MESSAGE);
            GameController.player1Wins++;
            GameController.player2Lost++;
            GameController.mainUI.gameOver();
        } else {
            /*
            here it will be checking if the scores are tie when checking for the winner.
            */
            IsTie = true;
        }

    }
    /*
    
    the below method is to check if the game is over.
    This method will be called to display if any of the player wins or looses.
    This will set the String to the label in the GUI
    */

    public void gameOver() {

        throwBtn.setEnabled(false);
        rerollBtn.setEnabled(false);
        scoreBtn.setEnabled(false);
        HumanWinningLabel.setText(String.valueOf(GameController.player2Wins));
        HumanLostLabel.setText(String.valueOf(GameController.player2Lost));
        computerWinningLabel.setText(String.valueOf(GameController.player1Wins));
        computerLostLabel.setText(String.valueOf(GameController.player1Lost));

        GameController.saveGameDetails();
    }
/*
    Here is the thread that will be used by the human player
    
    */
    public void roll(final UIPanel player, final int[] dicePositions) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                player.roll(GameController.dice.roll(dicePositions.length), dicePositions);
            }
        }).start();
    }

//here we return the array index to be rerolled
    private int[] findDiceToReroll(Die[] dice) {

        //here we are keeping track of the array positions
        ArrayList<Integer> dicePositions = new ArrayList<Integer>();

        // this iterates through the dice array 
        for (int x = 0; x < dice.length; x++) {

            // here it checks if the dice in the current position is below than 3 (including 3)
            if (dice[x].getValue() <= 3) {
                //here it will record the position
                dicePositions.add(x);
            }
        }

        // here it checks if the position list is empty
        if (dicePositions.isEmpty()) {

            return null;
        }

        // the array to be returned
        int[] dicePositionsArray = new int[dicePositions.size()];

        //here it will iterates through the positions list
        for (int x = 0; x < dicePositions.size(); x++) {
            // here it will assign the positions in the list to the resultant array
            dicePositionsArray[x] = dicePositions.get(x);
        }

        return dicePositionsArray;
    }

    /*
    I have created a method called score here it initially disables the score button. 
    Unless the user clicks on throw the score button will be disabled.
    Once the user clicks on throw the score button will be enabled.
    If the users chooses to click score without the reroll the method will calculate 
    that instance of the human score
    and will call the reroll computer method which will take the rerolls of the computer.
    */

    private void score() {

        scoreBtn.setEnabled(false);
        rerollBtn.setEnabled(false);
        throwBtn.setEnabled(true);
        user.makeDiceNotSelectable();

        rerollOfComputer();

        new Thread(new Runnable() {

            @Override
            public void run() {

                GameController.player1Attempts++;
                GameController.player2Attempts++;
                GameController.player1Score = computer.score();
                GameController.player2Score = user.score();
                computer.updateAttempts(GameController.player1Attempts);
                user.updateAttempts(GameController.player2Attempts);
                computer.updateRerollsLeft(0);
                user.updateRerollsLeft(0);
                isWin();
            }
        }).start();

    }
                  // comuter strategy
//here the below method is for deciding if taking the rerolls for computer
 //this the strategy the computer uses for its rerolls 
    private void rerollOfComputer() {

        //here we check the positions of the dice that have to be rerolled
        int[] dicePositions;

        //here we check if the computer score is higher than the human score
        if (GameController.player1Score > GameController.player2Score) {
            
            return;
        } //here it check the difference of the human and computer and if its more than 10
        else if ((GameController.player2Score - GameController.player1Score) > 10) {

            // finds the dice to be rerolled
            dicePositions = findDiceToReroll(computer.getDice());

            // check here if there are dice to be rerolled,should reroll them twice
            if (dicePositions != null) {
                // reroll the dice once
                roll(computer, dicePositions);
                // update the rerolls that are left in the GUI
                computer.updateRerollsLeft(computer.getRerollsLeft() - 1);
                // again find the optimum dice to be rerolled
                dicePositions = findDiceToReroll(computer.getDice());
                //reroll again
                roll(computer, dicePositions);
                // update the rerolls left count in the GUI
                computer.updateRerollsLeft(computer.getRerollsLeft() - 1);

            }
        } //here it checks of the computer score is lower than the human score and difference is within 10
        else {
            // find the dice to be rerolled
            dicePositions = findDiceToReroll(computer.getDice());

            //check if the dice are rerolled
            if (dicePositions != null) {

                //reroll the dice once
                roll(computer, dicePositions);
                // updare rerolls left in the GUI
                computer.updateRerollsLeft(computer.getRerollsLeft() - 1);
            }
        }
    }

}
