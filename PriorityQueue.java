
import java.util.ArrayList;

public class PriorityQueue
{

    private ArrayList list;
    private int size;

    public PriorityQueue()
    {
        list = new ArrayList();
        size = 0;
    }

    private int parent(int i)
    {
        return (i - 1) / 2;
    }

    private int leftChild(int i)
    {
        return 2 * i + 1;
    }

    private int rightChild(int i)
    {
        return 2 * i + 2;
    }

    private int compare(int i, int j, ArrayList a)
    {
        return ((Comparable) a.get(i)).compareTo(a.get(j));
    }

    private void swap(int i, int j, ArrayList a)
    {
        Comparable tmp = (Comparable) a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }

    public void add(Comparable c)
    {
        int i = size;
        list.add(i, c);
        while (i > 0 && compare(i, parent(i), list) > 0)
        {
            swap(i, parent(i), list);
            i = parent(i);
        }

        size++;
    }

    public Comparable remove()
    {
        Comparable c = (Comparable) list.get(0);
        list.set(0, list.get(size - 1));
        size--;
        int i = size - 1, j = 0;
        while (true)
        {
            if (leftChild(j) == i && compare(leftChild(j), j, list) < 0)
            {
                swap(j, leftChild(j), list);
                swap(leftChild(j), j, list);
                j = leftChild(j);
            }
            if (leftChild(j) == i && compare(leftChild(j), j, list) > 0)
            {
                swap(j, leftChild(j), list);
                j = leftChild(j);
            }
            else if (rightChild(j) <= i && compare(leftChild(j), rightChild(j), list) >= 0 && compare(leftChild(j), j, list) > 0)
            {
                swap(j, leftChild(j), list);
                j = leftChild(j);
            }
            else if (rightChild(j) <= i && compare(rightChild(j), leftChild(j), list) > 0 && compare(rightChild(j), j, list) > 0)
            {
                swap(j, rightChild(j), list);
                j = rightChild(j);
            }
            else
            {
                return c;
            }
        }
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
}
