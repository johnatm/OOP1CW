/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapplication.view;

import gameapplication.controller.GameController;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.*;

/**  
 *
 * @author John Sriskandarajah
 */
public class GameUI extends JFrame {

    private JButton startButton;
    private JLabel playerNameLabel;
    private JLabel scoreTargetLabel;
    private JPanel topPanel;
    private JPanel midPanel2;
    private JPanel bottomPanel;
    private JTextField PlayerNameField;
    private JTextField scoreTargetField;

    public GameUI() {
        initComponents();
    }

    private void initComponents() {

        topPanel = new JPanel();
        playerNameLabel = new JLabel();
        PlayerNameField = new JTextField();
        midPanel2 = new JPanel();
        scoreTargetLabel = new JLabel();
        scoreTargetField = new JTextField();
        bottomPanel = new JPanel();
        startButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dice Pro");
        setResizable(false);

        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 5));

        playerNameLabel.setText("Enter Player Name:");
        topPanel.add(playerNameLabel);

        PlayerNameField.setText(GameController.player2);
        PlayerNameField.setPreferredSize(new Dimension(100, 28));
        topPanel.add(PlayerNameField);

        getContentPane().add(topPanel, BorderLayout.PAGE_START);

        midPanel2.setLayout(new FlowLayout(java.awt.FlowLayout.CENTER, 40, 5));
//here there is an option where the user can set the target score. 
//the initial score will be 101        
        scoreTargetLabel.setText("Initial Target:");
        midPanel2.add(scoreTargetLabel);

        scoreTargetField.setText("101");
        scoreTargetField.setPreferredSize(new Dimension(100, 28));
        midPanel2.add(scoreTargetField);

        getContentPane().add(midPanel2, BorderLayout.CENTER);

        startButton.setText("Start Game");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(startButton);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);

        pack();

    }

    private void startButtonActionPerformed(ActionEvent evt) {

        if (PlayerNameField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "The player name field should not be empty!\nPlease enter a name and retry", "Please enter the player name!", JOptionPane.ERROR_MESSAGE);
            PlayerNameField.requestFocus();
        } else {

            GameController.player2 = PlayerNameField.getText();
            GameController.targetScore = Integer.parseInt(scoreTargetField.getText());
            GameController.reset();
            this.dispose();
        }
    }

}
