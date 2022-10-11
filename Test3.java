public class Test3 {
    public static void main(String[] agrs) {
        Calculator cal = new Calculator();
        double r = 0.0;

        try {
            r = cal.divide(10, 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println("任何情况下都会走到这个分支！！！");
            if(cal.isSwichOn()) {
                cal.close();
            }

        }

    }
}







class Calculator {

    private boolean isSwichOn = false;
    public boolean isSwichOn() {

        return isSwichOn;
    }

    public void setSwichOn(boolean swichOn) {
        this.isSwichOn = isSwichOn;
    }



    public void open() {
        isSwichOn = true;
        System.out.println("打开计算器电源，不过记得用完要关掉哦！！！");
    }

    public double divide(int a, int b) throws Exception {
        double result = 0d;

        open();

        if (b!=0) {
            result = a / b;
        } else {
            throw new Exception("严重警告：不能被0除！！！");
         }
        System.out.println(result);
        close();

        return result;
    }

    public void close() {
        System.out.println("用完关掉电源，不然会爆！！！");
        isSwichOn = false;
    }
}