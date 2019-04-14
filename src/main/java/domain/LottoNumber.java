package domain;

/**
 * 로또 하나의 숫자를 관리하는 클래스
 *
 * @author 김성훈
 * @version 1.0 2019/04/14  생성자로 범위에 벗어난 로또 번호에 대해 예외 처리
 */
public class LottoNumber {
    private static final int LOTTO_NUMBER_MAX_RANGE = 45;
    private static final int LOTTO_NUMBER_MIN_RANGE = 1;

    private final int lottoNumber;

    LottoNumber(int lottoNumber) {
        if(lottoNumber < LOTTO_NUMBER_MIN_RANGE || lottoNumber > LOTTO_NUMBER_MAX_RANGE){
            throw new IllegalArgumentException("범위를 벗어났습니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    int getLottoNumber() {
        return lottoNumber;
    }
}
