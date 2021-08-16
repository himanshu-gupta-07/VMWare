public class Square implements Area{
    double side;

    @Override
    public double area() {
        return side*side;
    }
}
