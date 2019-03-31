package comp1110.ass2;


public class TileRouteType {
    static int A0[] = {1,1,5,5};
    static int A1[] = {5,1,5,1};
    static int A2[] = {5,1,1,1};
    static int A3[] = {5,0,0,0};
    static int A4[] = {5,0,5,0};
    static int A5[] = {0,0,5,5};
    static int B0[] = {5,0,5,1};
    static int B1[] = {5,0,1,5};
    static int B2[] = {1,0,1,5};
    static int S0[] = {0,0,0,1};
    static int S1[] = {1,0,1,1};
    static int S2[] = {0,0,0,0};
    static int S3[] = {1,1,1,1};
    static int S4[] = {0,0,1,1};
    static int S5[] = {1,0,1,0};

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

    public int[] rotateTimes(int[] a,int m)
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
