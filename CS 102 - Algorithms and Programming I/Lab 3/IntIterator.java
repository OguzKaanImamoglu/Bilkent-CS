/** 
 * A little more complex interface that include nexInt()
 * @author Oðuz Kaan Ýmamoðlu
 * @date 06.11.18
 */
import java.util.*;
public interface IntIterator extends Iterator
{
    public boolean hasNext();
    public Object next();
    public int nextInt();
}
