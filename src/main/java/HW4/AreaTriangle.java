package HW4;
public class AreaTriangle {

    public float area(int a, int b, int c) throws NotTriangle {
        if (testValue(a, b, c)) throw new NotTriangle("Треугольника с такими сторонами не может быть");
        float p = (float) (a + b + c) / 2;
        float result = (float) Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println("Треугольник существует, площадь равна:" + result);
        return result;

    }

    private boolean testValue(int a, int b, int c){
        return a <= 0 || b <= 0 || c <= 0 || (a + b) <= c || (a + c) <=b || (b + c) <=a;
    }
}