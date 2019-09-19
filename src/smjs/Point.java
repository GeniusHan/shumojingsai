package smjs;

public class Point
{
    public double no; //点编号

    public double x; //坐标值
    public double y;
    public double z;

    public int type; // 校正点类型：1表示垂直误差校正点，0表示水平误差校正点 , 2表示

    public int errorPoint; // 1表示第三问中可能出现问题的点，0表示正常校正点

    @Override
    public String toString() {
        return "Point{" +
                "no=" + no +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", type=" + type +
                ", errorPoint=" + errorPoint +
                '}';
    }
}
