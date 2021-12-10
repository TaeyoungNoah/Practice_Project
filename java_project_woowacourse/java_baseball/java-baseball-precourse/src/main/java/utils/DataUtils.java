package utils;

public class DataUtils {
    private static int[] computerNum;
    private static int[] userNum;

    public static int[] getComputerNum(){
        return computerNum;
    }
    public static void setComputerNum(int[] computerNum){
        DataUtils.computerNum =computerNum;
    }
    public static int[] getUserNum(){
        return userNum;
    }
    public static void setUserNum(String[] userNumString){
        int[] userNum = new int[3];
        for(int i = 0; i<userNum.length; i++){
            userNum[i]=Integer.parseInt(userNumString[i]);
        }
        DataUtils.userNum=userNum;
    }
}
