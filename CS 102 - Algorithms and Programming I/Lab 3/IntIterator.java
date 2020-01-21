/** 
 * A little more complex interface that include nexInt()
 * @author O�uz Kaan �mamo�lu
 * @date 06.11.18
 */
import java.util.*;
public interface IntIterator extends Iterator
{
    public boolean hasNext();
    public Object next();
    public int nextInt();
}
