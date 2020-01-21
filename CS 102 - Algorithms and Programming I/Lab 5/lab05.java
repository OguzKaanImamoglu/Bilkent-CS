package lab05;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * Users can plays arbirary number of sos game with this class
 * @author Oðuz Kaan Ýmamoðlu
 * @date 27.11.18
 */
public class lab05 
{
 public static void main(String[] args) 
 {
  
  // properties & variables
  JFrame frame;
  String player1Name = "Default Name1";
  String player2Name = "Default Name2";
  int gameCount = 0;
  int defaultDimension = 3;
  
  JTextField howMany;
  JLabel label;
  JPanel firstPanel;
  
  // This panel is for getting game count ( extension)
  firstPanel = new JPanel();
  label = new JLabel("How many game");
  howMany = new JTextField(10);
  firstPanel.setLayout( new GridLayout(1,2));
  firstPanel.add(label);
  firstPanel.add(howMany);
 
  int firstPanelContents = JOptionPane.showConfirmDialog(null, firstPanel, null,JOptionPane.OK_CANCEL_OPTION);
  
  if (firstPanelContents == JOptionPane.OK_OPTION) 
  {
     gameCount = Integer.parseInt(howMany.getText());
  }
  
  // Setting the frame options
  frame = new JFrame("SOS GAME");
  frame.setPreferredSize(new Dimension(1000,1000));
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setBackground(Color.red);
  frame.setLayout(new GridLayout((int) gameCount/2  ,2));
  
  // This is for getting multiplie input based on game count
  for (int i = 0; i < gameCount ; i++)
  {
    JTextField player1;
    JTextField player2;
    JTextField dimensionText;
  
    JLabel label1;
    JLabel label2;
    JLabel dimensions;
  
    JPanel playerPanel;
  
    int dimension = defaultDimension;
  
    SOSCanvas sosCanvas;
  
    playerPanel = new JPanel();
    playerPanel.setLayout(new GridLayout(3, 2));

    // To get initialization values from the user
  
    player1 = new JTextField(10);
    player2 = new JTextField(10);
    dimensionText = new JTextField(10);

    label1 = new JLabel("Player 1: ");
    label2 = new JLabel("Player 2: ");
    dimensions = new JLabel("Dimensions: ");

    // To add all to panel
    
    playerPanel.add(label1);
    playerPanel.add(player1);
    playerPanel.add(label2);
    playerPanel.add(player2);
    playerPanel.add(dimensions);
    playerPanel.add(dimensionText);
    
    // A confirm panel to get initialization values
    int playersPanelsContents = JOptionPane.showConfirmDialog(null, playerPanel, null,JOptionPane.OK_CANCEL_OPTION);
    
    if (playersPanelsContents == JOptionPane.OK_OPTION) 
    {
       // to set player names
       player1Name = player1.getText();
       player2Name = player2.getText();
       
       // to set arbitrary dimension
       if (!dimensionText.getText().equals(""))
       {
          dimension = Integer.parseInt(dimensionText.getText());
       }
    }
    
    // to start and show the game
    if (playersPanelsContents == JOptionPane.OK_OPTION) 
    {
       JPanel panel = new SOSGUIPanel(new SOS(dimension), player1Name, player2Name);
       panel.setBackground(Color.red);
       panel.setPreferredSize(new Dimension(120,120));
       
       // to construct the canvas
       JPanel mainScreen = ((SOSGUIPanel) panel).sosCanvas;
       
       // last touches
       mainScreen.setBackground(Color.cyan);
       mainScreen.setPreferredSize(new Dimension(100, 100));
       JPanel thePanel = new JPanel();
       thePanel.setLayout(new BorderLayout());
       
       panel.add(mainScreen);
       thePanel.add(panel, BorderLayout.CENTER);
       
       frame.add(thePanel);
       frame.setBackground(Color.red);
       frame.pack();
       frame.setVisible(true);
   }
  }
 }
}
