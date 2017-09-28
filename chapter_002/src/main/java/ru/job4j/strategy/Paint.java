package ru.job4j.strategy;

/**.
 *
 */
public class Paint {
    /**
     *
     * @param shape Shape
     */
    public void draw(Shape shape) {
        System.out.print(shape.pic());
    }
//
//    public static void main(String[] args) {
//        Paint p = new Paint();
//        p.draw(new Square());
//        p.draw(new Triangle());
//    }
}

