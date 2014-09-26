abstract class  Living {
    abstract Counter getCount();
    abstract Living next(Neighbors world);
    abstract char toChar(); // character for this form
    void computeNeighbors(Neighbors world) {
        world.clearNeighborCounts();
        world.cells[row][column].getCount().setValue(-1);
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                world.cells[row+i][column+j].getCount().increseValue();
        }
        int row, column; //location
    }
    