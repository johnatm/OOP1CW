/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameapplication.view;

import gameapplication.model.Die;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author John Sriskandarajah
 */
public class UIPanel extends javax.swing.JPanel {

    //the following will create a panel
    private JLabel numAttemptsLabel;
    private Box.Filler filler1;
    private Box.Filler filler2;
    private JLabel numAttemptsNameLabel;
    private JLabel gameScoreNameLabel;
    private JLabel rerollsThatLeftNameLabel;
    private JPanel headerPanel;
    private JPanel contentPanel;
    private JLabel playerLabel;
    private JLabel rerollsThatLeftLabel;
    private JLabel gameScoreLabel;
    private JLabel[] diceLabels;
    private Die[] dice;
    private String player;
    private ImageIcon[] dieImages;
    private int score;
    private Border selectedBorder;
    private Border notSelectedBorder;
    private Border selectableBorder;
    private ArrayList<JLabel> selectedDiceLabels;
    private MouseListener mouseListen;
    private JLabel headerLabel2;

    public UIPanel(String player, ImageIcon[] dieImages, int noOfDice) {

        mouseListen = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                labelSelected(evt);
            }
        };
        selectedDiceLabels = new ArrayList<JLabel>();
        selectedBorder = BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(51, 0, 204));
        notSelectedBorder = BorderFactory.createMatteBorder(5, 5, 5, 5, this.getBackground());
        selectableBorder = BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(220, 220, 220));
        score = 0;
        dice = new Die[noOfDice];
        diceLabels = new JLabel[noOfDice];
        this.player = player;
        this.dieImages = dieImages;
        initComponents();

    }

    private void initComponents() {

        headerPanel = new JPanel();
        playerLabel = new JLabel();
        filler1 = new Box.Filler(new Dimension(40, 0), new Dimension(40, 0), new Dimension(40, 32767));
        gameScoreNameLabel = new JLabel();
        gameScoreLabel = new JLabel();
        filler2 = new Box.Filler(new Dimension(20, 0), new Dimension(20, 0), new Dimension(20, 32767));
        numAttemptsNameLabel = new JLabel();
        numAttemptsLabel = new JLabel();
        rerollsThatLeftNameLabel = new JLabel();
        rerollsThatLeftLabel = new JLabel();
        contentPanel = new JPanel();

        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new BorderLayout());

        headerPanel.setBorder(BorderFactory.createEtchedBorder());
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

        playerLabel.setFont(new Font("sansserif", 0, 18));
        playerLabel.setText("Player");
        playerLabel.setText(this.player);
        headerPanel.add(playerLabel);
        URL headerImageURL2 = getClass().getResource("..\\images\\humanUser.png");
        playerLabel.setIcon(new ImageIcon(headerImageURL2));
        headerPanel.add(filler1,playerLabel);
     //   getContentPane().add(headerLabe2, BorderLayout.PAGE_START);

        gameScoreNameLabel.setFont(new Font("sansserif", 1, 12));
        gameScoreNameLabel.setText("Score");
        headerPanel.add(gameScoreNameLabel);

        gameScoreLabel.setFont(new Font("sansserif", 1, 36));
        gameScoreLabel.setForeground(new Color(255, 0, 0));
        gameScoreLabel.setText("0");
        headerPanel.add(gameScoreLabel);
        headerPanel.add(filler2);

        numAttemptsNameLabel.setFont(new Font("sansserif", 1, 12));
        numAttemptsNameLabel.setText("Attempts");
        headerPanel.add(numAttemptsNameLabel);

        numAttemptsLabel.setFont(new Font("sansserif", 1, 36));
        numAttemptsLabel.setForeground(new Color(51, 0, 204));
        numAttemptsLabel.setText("0");
        headerPanel.add(numAttemptsLabel);

        rerollsThatLeftNameLabel.setFont(new java.awt.Font("sansserif", 1, 12));
        rerollsThatLeftNameLabel.setText("Rerolls Left");
        headerPanel.add(rerollsThatLeftNameLabel);

        rerollsThatLeftLabel.setFont(new Font("sansserif", 1, 24));
        rerollsThatLeftLabel.setForeground(new Color(0, 153, 51));
        rerollsThatLeftLabel.setText("0");
        headerPanel.add(rerollsThatLeftLabel);

        add(headerPanel, BorderLayout.PAGE_START);

        contentPanel.setBorder(BorderFactory.createEtchedBorder());
        contentPanel.setLayout(new FlowLayout(java.awt.FlowLayout.CENTER, 100, 20));

        for (int x = 0; x < diceLabels.length; x++) {

            JLabel tempLabel = new JLabel(dieImages[5]);
            tempLabel.setBorder(notSelectedBorder);
            diceLabels[x] = tempLabel;
            contentPanel.add(tempLabel);
        }

        add(contentPanel, java.awt.BorderLayout.CENTER);

    }
public void  updateAttempts(int attempts) {
        this.numAttemptsLabel.setText(String.valueOf(attempts));
    }
    
    public void updateRerollsLeft(int rerollsLeft) {
        
        rerollsThatLeftLabel.setText(String.valueOf(rerollsLeft));
    }
 public int getRerollsLeft() {
        return Integer.parseInt(rerollsThatLeftLabel.getText());
    } 
   public synchronized void roll(Die[] rolledDice, int[] dicePosition) {

        for (int x = 0; x < rolledDice.length; x++) {

            dice[dicePosition[x]] = rolledDice[x];
            updateDieLabel(diceLabels[dicePosition[x]], rolledDice[x].getValue());
        }
    } 
  public synchronized int score() {
        
        for(int x = 0; x < dice.length; x++) {
            
            score += dice[x].getValue();
        }
        
        this.gameScoreLabel.setText(String.valueOf(score));
        return this.score;
    }  
   
   
   public int[] getSelectedDicePositions() {
        
        if(selectedDiceLabels.isEmpty()) {
            return null;
        }
        
        int[] selectedDicePositions = new int[selectedDiceLabels.size()];
        JLabel tempLabel;
        
        for(int x = 0; x < selectedDicePositions.length; x++) {
            
            tempLabel = selectedDiceLabels.get(x);
            
            for(int y = 0; y < diceLabels.length; y++) {
                
                if(diceLabels[y] == tempLabel) {
                    
                    selectedDicePositions[x] = y;
                }  
            }    
        }
        return selectedDicePositions;
    }
   
   //once throw is selected can select dice
  public void makeDiceSelectable() {
        
        for(int x = 0; x < diceLabels.length; x++) {
            
            diceLabels[x].addMouseListener(mouseListen);
            diceLabels[x].setBorder(selectableBorder);
        } 
    } 
   public void resetSelection() {
        
        for(int x = selectedDiceLabels.size()-1; x >= 0; x--) {
        
            selectedDiceLabels.remove(x).setBorder(selectableBorder);
        }
        
    }
   //with out clicking throw button dice cant be selected
    public void makeDiceNotSelectable() {
        
        for(int x = 0; x < diceLabels.length; x++) {
            
           diceLabels[x].removeMouseListener(mouseListen);
           diceLabels[x].setBorder(notSelectedBorder);
        }
    }
   private synchronized void updateDieLabel(JLabel die, int value) {

        for (int x = 0; x < value; x++) {

            die.setIcon(dieImages[x]);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {

            }
        }
    }
   
   public synchronized Die[] getDice() {
        return dice;
    }
                                        

    protected void labelSelected(MouseEvent evt) {                               
        
        JLabel tempLabel = (JLabel)evt.getComponent();
        
        if(tempLabel.getBorder() == selectableBorder) {
            tempLabel.setBorder(selectedBorder);
            selectedDiceLabels.add(tempLabel);
        }
        else {
            tempLabel.setBorder(selectableBorder);
            selectedDiceLabels.remove(tempLabel);
        }
        
    }
   
   
   
}
