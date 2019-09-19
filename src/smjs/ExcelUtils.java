package smjs;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

    /**
     * 读取xlxs文件内容
     * @param path
     */
    public List<Point> readXlsx(String path)
    {
        List<Point> points = new ArrayList<Point>();

        XSSFWorkbook xssfWorkbook = null;
        try{
            InputStream is = new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(is);
        } catch (IOException e){
            e.printStackTrace();
        }
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
        Point p = null;
        for (int rowNum = 2; rowNum <= xssfSheet.getLastRowNum(); rowNum++){
            XSSFRow xssfRow = xssfSheet.getRow(rowNum);
            if (xssfRow != null){
                XSSFCell cell0 = xssfRow.getCell(0);
                XSSFCell cell1 = xssfRow.getCell(1);
                XSSFCell cell2 = xssfRow.getCell(2);
                XSSFCell cell3 = xssfRow.getCell(3);
                XSSFCell cell4 = xssfRow.getCell(4);
                XSSFCell cell5 = xssfRow.getCell(5);

                p = new Point();
                p.no = cell0.getNumericCellValue();
                p.x = Double.valueOf(cell1.toString());
                p.y = Double.valueOf(cell2.toString());
                p.z = Double.valueOf(cell3.toString());
                if(rowNum == 2) {
                    p.type = 2; // 起始
                }else if(rowNum == xssfSheet.getLastRowNum()){
                    p.type = 3; // 结束
                }else {
                    p.type = (int)cell4.getNumericCellValue();
                }
                p.errorPoint = (int)cell5.getNumericCellValue();

                points.add(p);
            }
        }

        return points;
    }
}
