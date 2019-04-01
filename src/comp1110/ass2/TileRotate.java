package comp1110.ass2;


public class TileRotate {
    /*
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
    */

    /**
     * AS Shown in Class TileEnum,a[0]:left,a[1]:top,a[2]:right,a[3]:bottom.
     * So, a rotation of 90 degree clockwise means:
     * a[0] to the top, a[1] to the right, a[2] to the bottom, a[3] to the left.
     *
     * @param a
     * @return
     */
    public int[] rotate90(int[] a) {
     /*   int m = a[3];
        a[3] = a[2];
        a[2] = a[1];
        a[1] = a[0];
        a[0] = m;*/
        int temp = a[1];
        a[1] = a[0];
        a[0] = a[3];
        a[3] = a[2];
        a[2] = temp;

        return a;
    }

    /**
     * AS Shown in Class TileEnum,a[0]:left,a[1]:top,a[2]:right,a[3]:bottom.
     * So, a rotation of 90 degree clockwise means:
     * So, mirroring the original position over the y-axis means:
     * Exchange the value of a[0] and a[2].
     *
     * @param a
     * @return
     */
    public int[] mirror(int[] a) {
        int temp = a[0];
        a[0] = a[2];
        a[2] = temp;
        return a;
    }

    /**
     * This method will return a final status of tiles by passing the array and the serial number of Orientation
     * , with the help of method rotate90(int[] a) and method mirror(int[] a)
     *
     * @param a
     * @param m: the serial number of Orientation (0 to 7)
     * @return
     */
    public int[] rotateTime(int[] a, int m) {
        int[] temp = a;

        if (m > 3) {
            temp = mirror(a);
            m = m - 4;
        }

        if (m != 0) {   //Orientation 0 is the unrotated state
            for (int i = 0; i < m; i++) {
                temp = rotate90(temp);
            }
        }
        return temp;
    }
}
