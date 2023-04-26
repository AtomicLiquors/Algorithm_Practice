package page2;
class arrClass{

    //o
    private int[] arrTest;
    private String StringTest;
    public arrClass(){
        arrTest=new int[]{2020};
        StringTest="Class";
    }

    public int[] getArrTest(){
        return arrTest;
    }

    public String getStringTest(){
        return StringTest;
    }

    public void printArr(){
        System.out.println(arrTest[0]+" / "+StringTest);
    }
}

public class Start {
    public static void main(String[] args)  {
        arrClass ac = new arrClass();

        int[] arr = ac.getArrTest();
        String s = ac.getStringTest();

        arr[0]=2021;
        s="Main";

        ac.printArr();
    }
}
