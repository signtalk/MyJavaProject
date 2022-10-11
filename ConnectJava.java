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
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;

public class ConnectJava {
    static final private String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final private String DB_URL = "jdbc:mysql://localhost:3306/Simon?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static final  String USER = "root";
    static final String PASS = "admin";

    public static void main(String[] args) throws IOException {
        ConnectJava cj = new ConnectJava();
        cj.gainFromSQL();
    }

    public void gainFromSQL() {
        Connection conn = null;
        Statement stmt = null;

        ArrayList<String> idList =new ArrayList<>();
        ArrayList<String> nameList =new ArrayList<>();
        ArrayList<String> urlList =new ArrayList<>();


        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connect to database:");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("实例化Statement对象");
            stmt = (Statement) conn.createStatement();
            String sql = "SELECT id, name, url FROM websites";
            ResultSet rs = stmt.executeQuery(sql);
            int row = 0;

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");

                idList.add(Integer.toString(id));
                nameList.add(name);
                urlList.add(url);


                ArrayList<String> appendList =new ArrayList<>();
                appendList.add(Integer.toString(id));
                appendList.add(name);
                appendList.add(url);

                appendFile(row++, appendList);
            }

            tableSawTest(idList, nameList, urlList);//Display the list of database.

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

        }
        System.out.println("Goodbye!");
    }

    public void appendFile(int rowIndex, ArrayList<String> appendList) throws IOException{
        String path = "D:\\Hello.xls";
        File file = new File(path);
        int columnIndex = 0;
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

        for(String value : appendList){

            if(row == null){
                row = sheet.createRow(rowIndex);
            }
            HSSFCell cell = row.createCell(columnIndex++);
            cell.setCellValue(value);
        }

        workbook.write(file);
    }

    public void tableSawTest(ArrayList<String> idList, ArrayList<String> nameList, ArrayList<String> urlList) {
        String[] id = new String[idList.size()];
        String[] name = new String[nameList.size()];
        String[] url = new String[urlList.size()];

        idList.toArray(id);
        nameList.toArray(name);
        urlList.toArray(url);

        Table table = Table.create("Complete Collection of Web sites").addColumns(
                StringColumn.create("ID", id),
                StringColumn.create("站点名称", name),
                StringColumn.create("站点地址", url));

        System.out.println(table.print());
    }
}