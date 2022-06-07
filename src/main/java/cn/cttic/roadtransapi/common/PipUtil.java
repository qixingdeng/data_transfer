package cn.cttic.roadtransapi.common;

public class PipUtil {
	/**
     * @author Paul Hallett 10/05/2004 GIS Developer
     * @return boolean true if point is outside a region, false if it is fixed
     *         in the region
     * @param X,Y
     *            The cordinates of the point being located
     * @param Xg,Yg
     *            Double arrays listing the x,y pointlist of the region you are
     *            searching in
     * @param ncoord
     *            is the amount of points there are in the search region
     */ 
    public boolean inPolygon(double X, double Y, double[] Xg, double[] Yg, 
            int ncoord) { 
        int count = 0; 
        double Gradient, Intercept, Yintercept; 
        double maxX, minX; 
        int i, j; 
        for (i = 0; i < ncoord; i++) { 
            j = (i + 1) % ncoord; 
            maxX = Xg[i] > Xg[j] ? Xg[i] : Xg[j]; 
            minX = Xg[i] < Xg[j] ? Xg[i] : Xg[j]; 
            if (X < maxX && X >= minX) { 
                Gradient = (Yg[i] - Yg[j]) / (Xg[i] - Xg[j]); 
                Intercept = Yg[i] - Gradient * Xg[i]; 
                Yintercept = X * Gradient + Intercept; 
                if (Yintercept > Y) { 
                    count++; 
                } 
            } 
        } 
        return (count % 2 == 1); 
    } 
   
    public static boolean isPointInsidePolygon(double x,double y, double[] xpoly, 
            double[] ypoly) { 
        int i1; 
        boolean isInside = false; 
        double X = x; 
        double Y = y; 
        for (int i = 0; i < xpoly.length - 1; i++) { 
            i1 = (i % xpoly.length) + 1; // modulus 
            if (ypoly[i] == ypoly[i1]) 
                if (Y == ypoly[i]) 
                    if (!(X < xpoly[i] ^ X > xpoly[i1])) 
                        return true; 
   
            // If point is on the boundary return true 
            if (X == xpoly[i] | X == xpoly[i1]) { 
                return true; 
            } else { 
                if (!(Y < ypoly[i] ^ Y >= ypoly[i1])) { 
                    /* point is within y limits */ 
                    double exp = (X - xpoly[i] - (Y - ypoly[i]) 
                            * (xpoly[i1] - xpoly[i]) / (ypoly[i1] - ypoly[i])); 
                    if (exp < 0) 
                        isInside = !isInside; 
                    else if (exp == 0) 
                        return true; // point is on boundary 
                } 
            } 
        } 
        return isInside; 
    } 
       
}
