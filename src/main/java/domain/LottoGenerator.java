/*
 * LottoGenerator
 *
 * version 1.1
 *
 * 2019/04/10
 */

package domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 로또 번호를 발생시키는 클래스
 *
 * @author 김성훈
 * @version 1.0 2019/04/11  1 ~ 45 사이의 난수 발생 구현. 범위와 중복 사항에 대한 예외 처리.
 *          1.1 2019/04/14  List 구조의 로또 숫자를 HashSet 으로 저장 (중복 처리 로직을 없애기 위해)
 */
public class LottoGenerator {
    private static final int LOTTO_NUMBER_MAX_RANGE = 45;
    private static final int LOTTO_NUMBER_MIN_RANGE = 1;
    private static final int LOTTO_SIZE = 6;

    Set<Integer> makeLotto() {
        Set<Integer> lotto = new HashSet<>();
        while (lotto.size() < LOTTO_SIZE) {
            lotto.add(new LottoNumber(generateRandomNumber()).getLottoNumber());
        }
        return lotto;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * LOTTO_NUMBER_MAX_RANGE) + LOTTO_NUMBER_MIN_RANGE;
    }
}
