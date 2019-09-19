package smjs;

import java.util.List;

public class MainFunc {

    public static void main(String[] args) {
        // 第一步：读取excel文件内容，更新空间内所有点的信息
        ExcelUtils e = new ExcelUtils();
        List<Point> points = e.readXlsx("f://jar//data2.xlsx");
//        for (Point p:
//                points) {
//            System.out.println(p.toString());
//        }


    }
}
