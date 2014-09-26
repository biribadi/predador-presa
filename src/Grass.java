
public class Grass extends Living{
    
    
    public Grass(int r, int c) { row = r; column = c; }
    public Living next(Neighbors world) {
        computeNeighbors(world);
        if (Grass.neighborCount.getValue() > 2 * Rabbit.neighborCount.getValue())
            // rabbits move in to eat the grass
        return (new Rabbit(row, column, 0));
        else if (Grass.neighborCount.getValue() > Rabbit.neighborCount.getValue())
            // grass remains
        return (new Grass(row, column));
        else
            // rabbits eat all the grass
        return (new Empty(row, column));
    }
    public String toString() { return "Grass"; }
    char toChar() { return 'G'; }
    Counter getCount() { return neighborCount; }
    static Counter neighborCount = new Counter();
}