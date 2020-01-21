package lab05;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * This class draws the canvas of SOS game
 * @author: Oðuz Kaan Ýmamoðlu
 * @date: 27.11.18
 */
public class SOSCanvas extends JPanel 
{
 // properties
 private final int SIZE = 100;   
 SOS sos;
 
 /** Constructor
   * Constructs the SOS Canvas
   * @param object: the sos game object
   */
 public SOSCanvas(SOS object) 
 {
  sos = object;
 }

 @Override
 /**
  * This methods draws the canvas of sos game
  */
 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);

  // properties
  int dimension = sos.getDimension();
  double cellLength = SIZE / dimension;
  double cageLength = SIZE;
  
  // draws the vertical lines
  for (int j = 0; j <= dimension; j++) 
  {
   g.drawLine(0, (int) (j * cellLength), (int) cageLength, (int) (j * cellLength));
  }
  
  // draws the horizontal lines
  for (int i = 0; i <= dimension; i++) 
  {
   g.drawLine((int) (i * cellLength), 0, (int) (i * cellLength), (int) cageLength);
  }
  
  // to print 's' and 'o' to the canvas
  for (int i = 0; i < dimension; i++)
  {
   for (int j = 0; j < dimension; j++) 
   {
    String letter = "" + sos.getCellContents(i, j);
    g.drawString(letter, (int) ((j + 0.5) * cellLength), (int) ((i + 0.5) * cellLength));
    repaint();
   }
  }
 }
}
