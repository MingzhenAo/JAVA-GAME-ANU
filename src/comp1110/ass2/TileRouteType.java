package comp1110.ass2;


public class TileRouteType {
    int A0[] = {1,1,5,5};
    int A1[] = {5,1,5,1};
    int A2[] = {5,1,1,1};
    int A3[] = {5,0,0,0};
    int A4[] = {5,0,5,0};
    int A5[] = {0,0,5,5};
    int B0[] = {5,0,5,1};
    int B1[] = {5,0,1,5};
    int B2[] = {1,0,1,5};
    int S0[] = {0,0,0,1};
    int S1[] = {1,0,1,1};
    int S2[] = {0,0,0,0};
    int S3[] = {1,1,1,1};
    int S4[] = {0,0,1,1};
    int S5[] = {1,0,1,0};
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
