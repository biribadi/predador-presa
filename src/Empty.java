
public class Empty extends Living{
    
    Empty(int r, int c) { row = r; column = c; }
    Living next(Neighbors world) {
        computeNeighbors(world);
        if (Rabbit.neighborCount.getValue() > 2)
            return (new Fox(row, column, 0));
        else if (Grass.neighborCount.getValue() > 4)
            return (new Rabbit(row, column, 0));
        else if (Grass.neighborCount.getValue() > 0)
            return (new Grass(row, column));
        else
            return (new Empty(row, column));
    }
    public String toString() { return "."; }
    char toChar() { return '.'; }
    Counter getCount() { return neighborCount; }
    static Counter neighborCount = new Counter();
}
