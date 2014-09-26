
public class Fox extends Living{
    
    Fox(int r, int c, int a ) {
        row = r;
        column = c;
        age = a;
    }
    Living next(Neighbors world) {
        computeNeighbors(world);
        if (Fox.neighborCount.getValue() > 5 ) //too many Foxes
            return new Empty(row, column);
        else if (age > LIFE_EXPECTANCY) //Fox is too old
            return new Empty(row, column);
        else if (Rabbit.neighborCount.getValue() == 0)
            return new Empty(row, column); // starved
        else
            return new Fox(row, column, age + 1);
    }
    public String toString(){ return "Fox age " + age; }
    char toChar() { return 'F'; }
    Counter getCount() { return neighborCount; }
    static Counter neighborCount = new Counter();
    private int age;
    private final int LIFE_EXPECTANCY = 5;
}

