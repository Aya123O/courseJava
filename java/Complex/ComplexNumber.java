class ComplexNumber<T extends Number> {

    T real, image;

    public ComplexNumber(T real, T image) {
        this.real = real;
        this.image = image;
    }

    public void showC() {
        if (real.doubleValue() == 0 && image.doubleValue() == 0) {
            System.out.print("No Number Exists");
        } else if (real.doubleValue() == 0) {
            System.out.print(image + "i");
        } else if (image.doubleValue() == 0) {
            System.out.print(real);
        } else {
            System.out.print(real + " + " + image + "i");
        }
    }

    public static <T extends Number> ComplexNumber<Double> add(ComplexNumber<T> n1, ComplexNumber<T> n2) {
        double realPart = n1.real.doubleValue() + n2.real.doubleValue();
        double imagePart = n1.image.doubleValue() + n2.image.doubleValue();
        return new ComplexNumber<>(realPart, imagePart);
    }

    public static <T extends Number> ComplexNumber<Double> sub(ComplexNumber<T> n1, ComplexNumber<T> n2) {
        double realPart = n1.real.doubleValue() - n2.real.doubleValue();
        double imagePart = n1.image.doubleValue() - n2.image.doubleValue();
        return new ComplexNumber<>(realPart, imagePart);
    }

    public static void main(String arg[]) {
        ComplexNumber<Integer> c1 = new ComplexNumber<>(-4, -5);
        ComplexNumber<Integer> c2 = new ComplexNumber<>(10, 5);

        System.out.print("First Complex number: ");
        c1.showC();

        System.out.print("\nSecond Complex number: ");
        c2.showC();

        ComplexNumber<Double> res = add(c1, c2);
        System.out.print("\nAddition is: ");
        res.showC();

        ComplexNumber<Double> res2 = sub(c1, c2);
        System.out.print("\nSubtraction is: ");
        res2.showC();
    }
}

