public class Main {
    public static void main(String[] args) {
        Car c1 = new Car(5, 5);

        System.out.println("Initial Position: (" + c1.x + ", " + c1.y + ")");

        c1.moveUp();
        c1.moveLeft();

        System.out.println("Position after moving up and left: (" + c1.x + ", " + c1.y + ")");

        c1.Destination("Downtown");
        c1.Drive();
    }
}

