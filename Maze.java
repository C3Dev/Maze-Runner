
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Maze
{

    public char START = 'S';
    public char GOAL = 'G';
    public char OPEN = ' ';
    public char CLOSED = '*';
    public char VISITED = 'V';
    public char CURRENT = 'C';
    public char TURTLE = 'T';
    
    public Point start;
    public Point goal;
    public Point current;
    public Point turtle;
    
    public boolean open[][];
    public boolean visited[][];
    
    public int columns;
    public int rows;

    public Maze(String s)
    {

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(s));
            String s1;
            while ((s1 = br.readLine()) != null)
            {
                rows++;
                columns = s1.length();
            }
            open = new boolean[columns][rows];
            visited = new boolean[columns][rows];
            br = new BufferedReader(new FileReader(s));
            for (int i = 0; i < rows; i++)
            {
                String s2 = br.readLine();
                for (int j = 0; j < columns; j++)
                {
                    open[j][i] = true;
                    if (s2.charAt(j) == CLOSED)
                        open[j][i] = false;
                    if (s2.charAt(j) == START)
                        start = new Point(j, i);
                    if (s2.charAt(j) == GOAL)
                        goal = new Point(j, i);
                }

            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        current = start;
    }

    public Point getStart()
    {
        return start;
    }

    public boolean isStart(Point point)
    {
        return point.equals(start);
    }

    public Point getGoal()
    {
        return goal;
    }

    public boolean isGoal(Point point)
    {
        return point.equals(goal);
    }

    public void setCurrent(Point point)
    {
        current = point;
    }

    public Point getCurrent()
    {
        return current;
    }

    public boolean isCurrent(Point point)
    {
        return point.equals(current);
    }

    public boolean isOpen(Point point)
    {
        return open[point.getColumn()][point.getRow()];
    }

    public boolean isClosed(Point point)
    {
        return !open[point.getColumn()][point.getRow()];
    }

    public void markVisited(Point point)
    {
        visited[point.getColumn()][point.getRow()] = true;
    }

    public boolean isVisited(Point point)
    {
        return visited[point.getColumn()][point.getRow()];
    }

    public boolean isInBounds(Point point)
    {
        return 0 <= point.getColumn() && point.getColumn() < columns && 0 <= point.getRow() && point.getRow() < rows;
    }

    public ArrayList moves(Point point)
    {
        ArrayList a = new ArrayList();
        Iterator it = point.neighbors().iterator();
        while(true)
        {
            if (!it.hasNext())
                break;
            Point point1 = (Point) it.next();
            if (isInBounds(point1) && isOpen(point1) && !isVisited(point1))
                a.add(point1);
        }
        return a;
    }
}
