import java.util.Scanner;

abstract class Plot {
    String owner;
    public Plot(String owner) {
        this.owner = owner;
    }
    public abstract double getArea();
    public abstract String getShapeName();
}

class Circle extends Plot {
    double radius;
    public Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public String getShapeName() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length, width;
    public Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }
    @Override
    public double getArea() {
        return length * width;
    }
    @Override
    public String getShapeName() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base, height;
    public Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
    @Override
    public String getShapeName() {
        return "TRIANGLE";
    }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String owner = scanner.next();
            if (type.equalsIgnoreCase("CIRCLE")) {
                plots[i] = new Circle(owner, scanner.nextDouble());
            } else if (type.equalsIgnoreCase("RECTANGLE")) {
                plots[i] = new Rectangle(owner, scanner.nextDouble(), scanner.nextDouble());
            } else if (type.equalsIgnoreCase("TRIANGLE")) {
                plots[i] = new Triangle(owner, scanner.nextDouble(), scanner.nextDouble());
            }
        }

        double totalArea = 0;
        for (Plot p : plots) {
            double area = p.getArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f\n", p.owner, p.getShapeName(), area);
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
        scanner.close();
    }
}
