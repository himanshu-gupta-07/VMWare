public class Circle implements Area {
    double r;

    @Override
    public double area() {
        return 3.14*r*r;
    }
}
