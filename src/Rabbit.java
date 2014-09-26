
public class Rabbit extends Living{
    
    Rabbit(int r, int c, int a ) { row = r; column = c; age = a;}
    Living next(Neighbors world) {
        computeNeighbors(world);
        if (Fox.neighborCount.getValue() >=
            Rabbit.neighborCount.getValue() )
        return (new Empty(row, column)); // eat Rabbits
        else if (age > LIFE_EXPECTANCY)
            return (new Empty(row, column)); // too old
        else if (Grass.neighborCount.getValue() == 0)
            return (new Empty(row, column)); // starved
        else
            return (new Rabbit(row, column, age + 1));
    }
    public String toString() {return "Rabbit age " + age;}
    char toChar() { return 'R'; }
    Counter getCount() { return neighborCount; }
    static Counter neighborCount = new Counter();
    private int age;
    private final int LIFE_EXPECTANCY = 3;
}