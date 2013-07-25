
import java.util.ArrayList;

public class Point implements Comparable
{

    private int column;
    private int row;
    private int distance;

    public int getColumn()
    {
        return column;
    }

    public int getDistance()
    {
        return distance;
    }

    public int getRow()
    {
        return row;
    }

    public void setColumn(int column)
    {
        this.column = column;
    }

    public void setDistance(int distance)
    {
        this.distance = distance;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public Point(int column, int row)
    {
        this.column = column;
        this.row = row;
    }

    public boolean equals(Point point)
    {
        return this.column == point.column && this.row == point.row;
    }

    public int calcDistance(Point point)
    {
        return 4 * (Math.abs(this.column - point.column) + Math.abs(this.row - point.row));
    }

    public void setDistance(Point point)
    {
        this.distance = calcDistance(point);
    }

    public int compareTo(Point point)
    {
        if (this.distance < point.distance)
            return 1;
        return this.distance <= point.distance ? 0 : -1;
    }

    public ArrayList neighbors()
    {
        ArrayList a = new ArrayList();
        a.add(new Point(this.column, this.row - 1));
        a.add(new Point(this.column, this.row + 1));
        a.add(new Point(this.column - 1, this.row));
        a.add(new Point(this.column + 1, this.row));
        return a;
    }

    public int compareTo(Object obj)
    {
        return compareTo((Point) obj);
    }
}
