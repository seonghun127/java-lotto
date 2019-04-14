/*
 * Lotto
 *
 * version 1.1
 *
 * 2019/04/10
 */

package domain;

import java.util.List;
import java.util.Set;

/**
 * 로또 한장을 의미하는 객체
 *
 * @author 우아한 테크코스, 김성훈
 * @version 1.0 2019/04/10  로또 숫자 출력 메소드 구현
 *          1.1 2019/04/11  다른 로또 번호(당첨 번호)와 일치 갯수 계산 메소드 구현
 *          1.2 2019/04/14  Set자료구조를 이용해서 로또 번호의 중복에 대한 예외 처리
 */
public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final Set<Integer> numbers;

    Lotto(Set<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        this.numbers = numbers;
    }

    void printLotto() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int number : numbers) {
            stringBuilder.append(number);
            stringBuilder.append(", ");
        }
        System.out.println(stringBuilder.toString().substring(0, stringBuilder.length() - 2) + "]");
    }

    boolean contain(int number) {
        return numbers.contains(number);
    }

    int calcCountOfMatch(Lotto winningNumbers) {
        int countOfMatch = 0;
        for (int number : numbers) {
            countOfMatch += winningNumbers.contain(number) ? 1 : 0;
        }
        return countOfMatch;
    }
}
