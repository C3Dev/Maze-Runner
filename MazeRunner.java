
import java.util.Iterator;
import javax.swing.JFrame;

public class MazeRunner
{

    private static int DELAY = 200;

    public MazeRunner()
    {
    }

    public static void main(String args[])
    {
        if (args.length == 1)
        {
            String filename = args[0];

            Maze maze = new Maze(filename);

            JFrame window = new JFrame("Maze Runner");

            MazePanel mp = new MazePanel(maze);

            window.getContentPane().add(mp);
            window.pack();
            window.setVisible(true);
            window.repaint();

            try
            {
                Thread.sleep(DELAY);
            }
            catch (InterruptedException ex)
            {
            }

            Point point = maze.getStart();
            Point point2 = maze.getGoal();

            point.setDistance(point2);

            PriorityQueue pq = new PriorityQueue();

            pq.add(point);
            Point point1;
            for (; !pq.isEmpty(); maze.markVisited(point1))
            {
                point1 = (Point) pq.remove();
                maze.setCurrent(point1);
                window.repaint();
                try
                {
                    Thread.sleep(DELAY);
                }
                catch (InterruptedException ex)
                {
                }
                if (point1.equals(point2))
                {
                    System.out.println("DONE");
                    return;
                }
                Point point3;
                for (Iterator iterator = maze.moves(point1).iterator(); iterator.hasNext(); pq.add(point3))
                {
                    point3 = (Point) iterator.next();
                    point3.setDistance(point2);
                }

            }
        }
        else
        {
            System.out.println("You have to enter the filename as an argument.");
        }
    }
}
