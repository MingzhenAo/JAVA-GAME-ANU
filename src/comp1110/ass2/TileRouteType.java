package comp1110.ass2;


public class TileRouteType {
    int[][] tilevalue = {{1,1,5,5},{5,1,5,1},{5,1,1,1},{5,0,0,0},{5,0,5,0},{0,0,5,5},
            {5,0,5,1}, {5,0,1,5}, {1,0,1,5},
            {0,0,0,1},{1,0,1,1},{0,0,0,0},{1,1,1,1},{0,0,1,1},{1,0,1,0}};
    String[] tilename = {"A0","A1","A2","A3","A4","A5","B0","B1","B2","S0","S1","S2","S3","S4","S5"};



    public int[] rotate90(int[] a)
    {   int m = a[3];
        a[3] = a[2];
        a[2] = a[1];
        a[1] = a[0];
        a[0] = m;
        return a;
    }
    public int[] mirror(int[] a)
    {   int m = a[3];
        int n = a[0];
        a[3] = a[1];
        a[1] = m;
        a[0] = a[2];
        a[2] = n;
        return a;
    }
    public int[] rotatetime(int[] a,int m)
    {
        int[] b = a;
        if (m > 3){
            b = mirror(a);
            m = m - 4;
        }
        if(m!=0) {
            for (int i = 0; i < m; i ++) {
            b = rotate90(b);
            }
        }


        return b;
    }
}
