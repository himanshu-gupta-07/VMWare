public class Rectangle implements Area{
    double l;
    double b;

    @Override
    public double area() {
        return l*b;
    }
}
