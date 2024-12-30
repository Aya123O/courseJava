public class Car implements SelfDrive, Movable {
    int x, y, numOfPass;

    // Default Constructor
    public Car() {
        this.x = 0;
        this.y = 0;
        this.numOfPass = 0;
    }

    // Parameterized Constructor
    public Car(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveUp() {
        y--;
    }

    @Override
    public void moveDown() {
        y++;
    }

    @Override
    public void moveLeft() {
        x--;
    }

    @Override
    public void moveRight() {
        x++;
    }

    @Override
    public void Destination(String d) {
        System.out.println("Destination = " + d);
    }

    @Override
    public void Drive() {
        System.out.println("Driving...");
    }
}

