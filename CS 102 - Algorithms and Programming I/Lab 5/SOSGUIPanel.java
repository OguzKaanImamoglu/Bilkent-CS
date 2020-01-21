package lab05;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/**
 * This class demonstrates GUI aspects of SOS
 * @ author Oðuz Kaan Ýmamoðlu
 * @ date 27.11.18
 */
public class SOSGUIPanel extends JPanel implements MouseListener
{
   //properties
   
   SOSCanvas sosCanvas;
   private String player1;
   private String player2;
   
   private int row;
   private int column;
   
   private JLabel l1;
   private JLabel l2;
   
   private JPanel p1;
   private JPanel p2;
   private JPanel p3;
   
   private JRadioButton sButton;
   private JRadioButton oButton;
   private ButtonGroup buttons;
  
   private String finalWords; 
   
   /**
    * Constructor method
    * It constructs and initializes variables
    * @ param name1: name of p1
    * @param name2: name of p2
    */  
   public SOSGUIPanel(SOS object,String name1, String name2)
   {
      player1 = name1;
      player2 = name2;
      
      p1 = new JPanel();
      p2 = new JPanel();
      p3 = new JPanel();
      
      sosCanvas = new SOSCanvas( object );
      p1.add( sosCanvas );
      
      l1 = new JLabel( player1 + ": 0 ");
      l2 = new JLabel( player2 + ": 0 " );  
      l1.setOpaque( true );
      l2.setOpaque( true );
      l1.setBackground( Color.GREEN );
      l2.setBackground( Color.WHITE ); 
      
      sButton = new JRadioButton( "s" );
      oButton = new JRadioButton( "o" );
      buttons = new ButtonGroup();
      buttons.add( sButton );
      buttons.add( oButton );
      
      p3.setSize( 50 , 50 );
      p3.setLayout( new BorderLayout() );
      p3.add( sButton , BorderLayout.WEST );    
      p3.add( oButton , BorderLayout.EAST );
      
      p2.add( l1 );
      p2.add( p3 );
      p2.add( l2 );      
      
      add( p1 );
      add( p2 );
      
      sosCanvas.addMouseListener( this );
   }
   
   /**
    * This method listens mouse clicks
    */
   public void mouseClicked( MouseEvent event )
   {
      int locationOfX = event.getX();
      int locationOfY = event.getY();
      
      int dimension;
      dimension = sosCanvas.sos.getDimension();
      
      int cellLength = 100 / dimension;
      
      column = (locationOfX / cellLength ) + 1;
      row = (locationOfY / cellLength ) + 1;
      
      // This part shows whose turn is this
      if( sosCanvas.sos.getTurn() == 1 )
      {
         l1.setBackground( Color.GREEN );
         l2.setBackground( Color.WHITE ); 
      }            
      else if ( sosCanvas.sos.getTurn() == 2)
      {
         l1.setBackground( Color.WHITE );
         l2.setBackground( Color.GREEN ); 
      }
      
      // user plays s
      if( sButton.isSelected() )
      {      
         sosCanvas.sos.play( 's', row, column );   
      }  
      
       // user plays o
      else if( oButton.isSelected() )
      {    
        sosCanvas.sos.play( 'o', row, column ); 
      }
      
      // This part shows whose turn is this
      if( sosCanvas.sos.getTurn() == 1 )
      {
         l1.setBackground( Color.GREEN );
         l2.setBackground( Color.WHITE ); 
      }            
      else if ( sosCanvas.sos.getTurn() == 2)
      {
         l1.setBackground( Color.WHITE );
         l2.setBackground( Color.GREEN ); 
      }
     
      // This shows scores
      l1.setText( player1 + ": " + sosCanvas.sos.getPlayerScore1() );
      l2.setText( player2 + ": " + sosCanvas.sos.getPlayerScore2() );
      
      // To end the game
      if( sosCanvas.sos.isGameOver() == true )
      {
         if(sosCanvas.sos.getPlayerScore1() > sosCanvas.sos.getPlayerScore2() )
         {
            finalWords = "The winner is " + player1;
         }
         if(sosCanvas.sos.getPlayerScore1() < sosCanvas.sos.getPlayerScore2()) 
         {
            finalWords = "The winner is " + player2;
         }
         else if( sosCanvas.sos.getPlayerScore1() == sosCanvas.sos.getPlayerScore2())
         {
            finalWords = "It's a draw";
         }
         
         JOptionPane.showMessageDialog(null, finalWords);
        
      }
   }
   
   // listener methods to make program compile
   public void mouseReleased( MouseEvent e ){}
   public void mouseEntered( MouseEvent e ){}
   public void mouseExited( MouseEvent e ){}
   public void mousePressed( MouseEvent e ){}
}

