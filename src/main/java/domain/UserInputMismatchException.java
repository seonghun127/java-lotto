package domain;

public class UserInputMismatchException extends UserInputException{

    public void printErrorMessage(){
        System.out.println("숫자만 입력가능합니다.");
    }
}