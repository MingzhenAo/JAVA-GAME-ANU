package comp1110.ass2;

/**
 * the class provides all of the unrotated tiles
 */

public enum TileEnum {

    //0 represents a highway; 1 represents a railway; 5 represents blank
    A0(1, 1, 5, 5),
    A1(5, 1, 5, 1),
    A2(5, 1, 1, 1),
    A3(5, 0, 0, 0),
    A4(5, 0, 5, 0),
    A5(0, 0, 5, 5),
    B0(5, 0, 5, 1),
    B1(5, 0, 1, 5),
    B2(1, 0, 1, 0),
    S0(0, 0, 0, 1),
    S1(1, 0, 1, 1),
    S2(0, 0, 0, 0),
    S3(1, 1, 1, 1),
    S4(0, 0, 1, 1),
    S5(1, 0, 1, 0);

    public int left;
    public int top;
    public int right;
    public int bottom;

    TileEnum(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

}
