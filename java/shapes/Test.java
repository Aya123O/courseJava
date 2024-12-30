import java.util.List;

abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    @Override
    void draw() {
        double rad = 5.5; 
        double area = rad * rad * Math.PI; 
        System.out.println("Circle Area: " + area);
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        double length = 5.5;
        double height = 8.0;
        double area = length * height; 
        System.out.println("Rectangle Area: " + area);
    }
}

class Test {
    public static void drawshapes(List<? extends Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public static void main(String[] args) {
        List<Circle> circles = List.of(new Circle(), new Circle());
        List<Rectangle> rectangles = List.of(new Rectangle(), new Rectangle());

   
        System.out.println("Drawing Circles:");
        drawshapes(circles);

        System.out.println("Drawing Rectangles:");
        drawshapes(rectangles);
    }
}

