/**
 * Program finds the two furthest points from the point entered by the user and draws a circle that makes this distance a diameter.
 *
 * @author Ceren YILMAZ
 * @since Date: 29.03.2021
 */

public class FarthestPoints{
    public static void main(String[] args) {

        StdDraw.setCanvasSize(700, 700);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        StdDraw.enableDoubleBuffering();
        double x, y;

        double[] xValues = new double[10]; //array that stores x coordinates
        double[] yValues = new double[10];//array that stores y coordinates

        int i = 0;
        while (i < 10) {
            if (StdDraw.isMousePressed()) {

                StdDraw.setPenColor(StdDraw.BLACK);
                x = StdDraw.mouseX();
                xValues[i] = StdDraw.mouseX();
                y = StdDraw.mouseY();
                yValues[i] = StdDraw.mouseY();

                StdDraw.pause(200);
                System.out.printf("mouse pressed: x= %5.2f, y=%5.2f\n", x, y);
                StdDraw.filledCircle(x, y, 0.01);
                StdDraw.show();
                i++;

            }
        }

        double maxDistance = 0;//defines maxDistance as 0


        int index1 = 0, index2 = 0; //defines the indexes of the two furthest points

        for (int k = 0; k < xValues.length - 1; k++) {
            for (int j = k + 1; j < yValues.length; j++) {
                double distance = distance(xValues, yValues, k, j);
                if (distance > maxDistance) {
                    maxDistance = distance;

                    index1 = j;
                    index2 = k;

                }
            }
        }

        double circleRadius = maxDistance / 2; //calculates radius of circle
        double circleCenterX = (xValues[index1] + xValues[index2]) / 2; //calculates circle center X
        double circleCenterY = (yValues[index1] + yValues[index2]) / 2;//calculates circle center y
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.circle(circleCenterX, circleCenterY, circleRadius);
        StdDraw.setPenRadius(0.02);

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledCircle(xValues[index1], yValues[index1], 0.01);
        StdDraw.filledCircle(xValues[index2], yValues[index2], 0.01);

        StdDraw.show();

    }

    /**
     * This method calculates distance between two points
     *
     * @param xValues double array
     * @param yValues double array
     * @param index1  integer number1
     * @param index2  integer number2
     * @return distance
     */
    public static double distance(double[] xValues, double[] yValues, int index1, int index2) {
        return Math.pow(Math.pow(xValues[index1] - xValues[index2], 2) + Math.pow(yValues[index1] - yValues[index2], 2), 0.5);


    }
}