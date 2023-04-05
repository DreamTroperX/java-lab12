package my.lab12.beans;

public record Graphic(double x, double y) {
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
}
