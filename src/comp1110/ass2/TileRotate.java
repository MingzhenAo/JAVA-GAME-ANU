package comp1110.ass2;


import java.util.ArrayList;

import static java.lang.Character.getNumericValue;

/**
 * This class provides some methods to rotate or flip the tiles
 */

/**
 * @Author: Mingzhen Ao
 * this class is for tile rotate
 */
public class TileRotate {

    /**
     * @Author: Mingzhen Ao
     * AS is shown in Class TileEnum,a[0]:left,a[1]:top,a[2]:right,a[3]:bottom.
     * So, a rotation of 90 degree clockwise means:
     * a[0] to the top, a[1] to the right, a[2] to the bottom, a[3] to the left.
     *@Author: Mingzhen Ao
     * @param  a
     * @return rotate90 a
     */
    public int[] rotate90(int[] a) {

        int temp = a[1];
        a[1] = a[0];
        a[0] = a[3];
        a[3] = a[2];
        a[2] = temp;

        return a;
    }

    /**
     * AS is shown in Class TileEnum,a[0]:left,a[1]:top,a[2]:right,a[3]:bottom.
     * So, a rotation of 90 degree clockwise means:
     * So, mirroring the original position over the y-axis means:
     * Exchange the value of a[0] and a[2].
     * @Author: Mingzhen Ao
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
     *@Author: Mingzhen Ao
     * @param a
     * @param m: the serial number of Orientation (0 to 7)
     * @return rotate m times a
     */
    public int[] rotateTime(int[] a, int m) {
        int[] result = a;

        if (m > 3) {
            result = mirror(a);
            m = m - 4;
        }

        if (m != 0) {   //Orientation 0 is the unrotated state
            for (int i = 0; i < m; i++) {
                result = rotate90(result);
            }
        }

        return result;
    }


    /**
     * @Author: Mingzhen Ao
     * @param placementString
     * @return an int array containing 4 integers.
     * The fist element represents the left;
     * The second element  represents the top;
     * The third  element represents the right;
     * The forth  element represents the bottom;
     * <p>
     * 0 represents a highway; 1 represents a railway; 5 represents blank
     * <p>
     * For example, if the array is [0,5,1,5],
     * it means the tile has a highway in the left, blank for top, a railway for right, blank for bottom
     */
    public static int[] getRotatedTile(String placementString) {

        TileRotate r = new TileRotate();
        int[] tile = new int[4];

        /*
        placementString.substring(0, 2) will return the object's name of TileEnum, such as A0, A1 etc.
        Then, by the method of valueOf(String name), we will get the corresponding object.
        */

        TileEnum tileName = TileEnum.valueOf(placementString.substring(0, 2));

        tile[0] = tileName.left;
        tile[1] = tileName.top;
        tile[2] = tileName.right;
        tile[3] = tileName.bottom;

        r.rotateTime(tile, getNumericValue(placementString.charAt(4)));

        return tile;
    }
}