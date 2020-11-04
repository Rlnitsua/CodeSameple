package rlnitsua.math;

import java.util.List;

public class Triangle {
    public String castMagic(List<List<Integer>> triangle, int[] point) {
        POINT A = new POINT(triangle.get(0).get(0), triangle.get(0).get(1));
        POINT B = new POINT(triangle.get(1).get(0), triangle.get(1).get(1));
        POINT C = new POINT(triangle.get(2).get(0), triangle.get(2).get(1));
        POINT D = new POINT(point[0], point[1]);
        return isInTriangle(A, B, C, D) ? "Yes" : "No";
    }

    public boolean isInTriangle(POINT A, POINT B, POINT C, POINT P) {
        double ABC = triAngleArea(A, B, C);
        double ABp = triAngleArea(A, B, P);
        double ACp = triAngleArea(A, C, P);
        double BCp = triAngleArea(B, C, P);
        double sumOther = ABp + ACp + BCp;
        double ABS_DOUBLE_0 = 0.0001;
        if (-ABS_DOUBLE_0 < (ABC - sumOther) && (ABC - sumOther) < ABS_DOUBLE_0) {
            return true;
        } else {
            return false;
        }
    }

    private static class POINT {
        int x;
        int y;

        public POINT(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private double triAngleArea(POINT A, POINT B, POINT C) {
        POINT ab, bc;
        ab = new POINT(B.x - A.x, B.y - A.y);//
        bc = new POINT(C.x - B.x, C.y - B.y);
        return Math.abs((ab.x * bc.y - ab.y * bc.x) / 2.0);
    }
}
