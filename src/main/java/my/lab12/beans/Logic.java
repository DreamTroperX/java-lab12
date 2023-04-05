package my.lab12.beans;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@SessionScope
public class Logic {
private List<Graphic> graphics;
    double eps = 1.0E-4;

    public void fillGraphic(double a, double h, double begin, double end){
        graphics = new ArrayList<Graphic>();
        int size = (int)Math.round((end - begin) / h) + 1;
        for(int i=0; i<size; i++){
           double x = begin + i*h;
           double y = functionY(x,a);
           graphics.add(new Graphic(x,y));
        }
    }
    public double functionY (double x,double a) {
        if (x > a + eps){
            return x*Math.sqrt(x-a);
        } else if (Math.abs(x - a) < eps) {
            return Math.exp(-a*x)*Math.cos(a*x);
        } else {
            return x*Math.sin(x*a);
        }
    }

    public int maxIndexY() {
        Graphic g = graphics.get(0);
        double maxY = g.getY();
        int maxIndex = 0;
        for (int i = 1; i < graphics.size(); i++) {
            g = graphics.get(i);
            if (g.getY() > maxY) {
                maxY = g.getY();
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    public double maxYNumber() {
        int index = maxIndexY();
        Graphic g = graphics.get(index);
        return g.getY();
    }
    public double maxXNumber() {
        int index = maxIndexY();
        Graphic g = graphics.get(index);
        return g.getX();
    }

    public int minIndexY() {
        Graphic g = graphics.get(0);
        double maxY = g.getY();
        int maxIndex = 0;
        for (int i = 1; i < graphics.size(); i++) {
            g = graphics.get(i);
            if (g.getY() < maxY) {
                maxY = g.getY();
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    public double minYNumber() {
        int index = minIndexY();
        Graphic g = graphics.get(index);
        return g.getY();
    }
    public double minXNumber() {
        int index = minIndexY();
        Graphic g = graphics.get(index);
        return g.getX();
    }

    public double sumY() {
        double sum = 0;
        for (Graphic g : graphics) {
            sum +=g.getY();
        }
        return sum;
    }


    public double midY() {
        double sum = sumY();
        return sum/graphics.size();

    }
}