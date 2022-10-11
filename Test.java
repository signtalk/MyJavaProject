import java.io.*;
import java.util.regex.Pattern;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Test {


    public static void main(String[] args){
        getFileListName("D:\\");
    }

    public static void getFileListName(String strPath) {

        File dir = new File(strPath);
        File[] files = dir.listFiles();



        if (files != null) {
            for (int i = 0; i < files.length; i++) {

                String content = files[i].getName();

                String pattern = ".*陈瀚洋.*";

                boolean isMatch = Pattern.matches(pattern, content);

                if (isMatch) {
                    System.out.println(files[i].getName());
                }

                if (files[i].isDirectory()) {
                    getFileListName(files[i].getAbsolutePath());
                    //System.out.println(files[i].getAbsolutePath() + files[i].getName());

                }

            }

        }

    }

}

