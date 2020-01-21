/**
 * Interface for using on selectable objects
 * @author Oðuz Kaan Ýmamoðlu
 * @date 06.11.18
 */
package shapes;
public interface Selectable 
{
    boolean getSelected();
    void setSelected( boolean isSelected );
    Shape contains( int x, int y );
    
}
       