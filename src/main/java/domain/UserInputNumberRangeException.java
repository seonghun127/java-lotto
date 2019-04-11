package domain;

public class UserInputNumberRangeException extends UserInputException {
    @Override
    void printErrorMessage() {
        System.out.println("범위에서 벗어난 숫자입니다. 로또 숫자의 범위는 1에서 45 사이입니다.");
    }
}
