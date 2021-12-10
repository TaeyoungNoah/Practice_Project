package baseball;

public class Regame {
    String userInput;
    Regame(String userInput){
        this.userInput=userInput;
    }
    public void checkRestart() throws IllegalArgumentException{
        if(!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}
