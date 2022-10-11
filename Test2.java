import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test2{
    public static void main(String[] args) throws IOException {
        Test2 t2 = new Test2();
        t2.creatFile();
        t2.appendFile();
    }

    public void creatFile() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow row = sheet.createRow(2);
        HSSFCell cell = row.createCell(3);
        cell.setCellValue("我是你爹----by Simon Chen");
        Path path = Paths.get("D:\\").resolve("Hello.xls");

        if(Files.exists(path)){
            Files.delete(path);
        }

        File file = Files.createFile(path).toFile();


        workbook.write(file);
    }

    public void appendFile() throws IOException{
        String path = "D:\\Hello.xls";
        File file = new File(path);
        int rowIndex = 3;
        int columnIndex = 5;
        HSSFWorkbook workbook = null;
        HSSFSheet sheet = null;

        if(file.exists()){
            FileInputStream fis = new FileInputStream(file);
            workbook = new HSSFWorkbook(fis);
            sheet = workbook.getSheet("Sheet0");
        }else {
            workbook = new HSSFWorkbook();
            sheet = workbook.createSheet();
        }

        HSSFRow row = sheet.getRow(rowIndex);

        if(row == null){
            row = sheet.createRow(rowIndex);
        }
        HSSFCell cell = row.createCell(columnIndex);
        cell.setCellValue("追加：really---by Peter Mao");
        workbook.write(file);
    }
}