
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MazePanel extends JPanel
{

    public static int SIDE = 30;
    
    public static Color startColor;
    public static Color goalColor;
    public static Color openColor;
    public static Color closedColor;
    public static Color visitedColor;
    public static Color turtleColor;
    
    public Maze maze;
    
    public int rows;
    public int columns;
    public int height;
    public int width;

    static
    {
        startColor = Color.red;
        goalColor = Color.green;
        openColor = Color.white;
        closedColor = Color.black;
        visitedColor = Color.black;
        turtleColor = Color.yellow;
    }

    public MazePanel(Maze m)
    {
        maze = m;
        columns = m.columns;
        rows = m.rows;
        width = SIDE * columns;
        height = SIDE * rows;
        setPreferredSize(new Dimension(width, height));
    }

    public void drawBox(int i, int j, int k, Color color, Graphics g)
    {
        int l = i * SIDE + SIDE / 2;
        int i1 = j * SIDE + SIDE / 2;
        int j1 = k / 2;
        g.setColor(color);
        g.fillRect(l - j1, i1 - j1, k, k);
    }

    public void drawDot(int i, int j, int k, Color color, Graphics g)
    {
        int l = i * SIDE + SIDE / 2;
        int i1 = j * SIDE + SIDE / 2;
        int j1 = k / 2;
        g.setColor(color);
        g.fillOval(l - j1, i1 - j1, k, k);
    }

    public void paintComponent(Graphics g)
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                Point point = new Point(j, i);
                if (maze.isOpen(point))
                    drawBox(j, i, SIDE, openColor, g);
                if (maze.isClosed(point))
                    drawBox(j, i, SIDE, closedColor, g);
                if (maze.isStart(point))
                    drawBox(j, i, SIDE, startColor, g);
                if (maze.isGoal(point))
                    drawBox(j, i, SIDE, goalColor, g);
                if (maze.isVisited(point))
                    drawDot(j, i, SIDE / 2, visitedColor, g);
                if (maze.isCurrent(point))
                    drawDot(j, i, SIDE / 2, turtleColor, g);
            }

        }

    }
}
