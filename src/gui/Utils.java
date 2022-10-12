package gui;

import java.util.ArrayList;
import java.util.List;

import data.Coordinate;

public class Utils {
    public static String formatOrder(List<Integer> orderList) {
        String orderString = "";
        for (int i = 0; i < orderList.size(); i++) {
            if (i != 0) {
                orderString += " -> ";
            }
            orderString += orderList.get(i);
        }
        return orderString;
    }

    public static List<Coordinate> listCoordinateByOrder(List<Coordinate> coordinates, List<Integer> order) {
        List<Coordinate> rearrangedList = new ArrayList<>();
        for (Integer o : order) {
            rearrangedList.add(coordinates.get(o));
        }
        return rearrangedList;
    }

    public static List<Coordinate> scaleCoordinates(List<Coordinate> coordinates, int maxWidth, int maxHeight) {
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        for (Coordinate c : coordinates) {
            double x = c.x;
            double y = c.y;
            if (maxX < x) maxX = x;
            if (minX > x) minX = x;
            if (maxY < y) maxY = y;
            if (minY > y) minY = y; 
        }
        List<Coordinate> out = new ArrayList<>();
        double xdiff = maxX - minX;
        double ydiff = maxY - minY;
        for (int i = 0; i < coordinates.size(); i++) {
            Coordinate coordinate = coordinates.get(i);
            double x = coordinate.x;
            double y = coordinate.y;
            if(minX < 0) x = x - minX;
            if(minY < 0) y = y - minY;
            int new_x = (int) (maxWidth * x / xdiff);
            int new_y = (int) (maxHeight * y / ydiff);
            Coordinate xy = new Coordinate(new_x, new_y);
            out.add(xy);
        }
        return out;
    }
}
