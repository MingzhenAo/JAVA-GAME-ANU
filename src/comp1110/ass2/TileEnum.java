package comp1110.ass2;

public enum TileEnum {
    A0("A0",1,1,5,5),
    A1("A1",5,1,5,1),
    A2("A2",5,1,1,1),
    A3("A3",5,0,0,0),
    A4("A4",5,0,5,0),
    A5("A5",0,0,5,5),
    B0("BO",5,0,5,1),
    B1("B1",5,0,1,5),
    B2("B2",1,0,1,5),
    S0("S0",0,0,0,1),
    S1("S1",1,0,1,1),
    S2("S2",0,0,0,0),
    S3("S3",1,1,1,1),
    S4("S4",0,0,1,1),
    S5("S5",1,0,1,0);
    String name;
    int left;
    int top;
    int right;
    int bottom;
    TileEnum (String name, int left, int top, int right, int bottom){
        this.name = name;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }
}
