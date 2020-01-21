/**
 * Interface for using on selectable objects
 * @author O�uz Kaan �mamo�lu
 * @date 06.11.18
 */
public interface Selectable extends Locatable
{
    boolean getSelected();
    void setSelected( boolean isSelected );
    Shape contains( int x, int y );
    public double getArea();
}
       