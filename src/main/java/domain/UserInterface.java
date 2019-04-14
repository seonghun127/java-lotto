package domain;

import java.util.List;

/**
 * 사용자 인터페이스 담당 인터페이스
 *
 * @author 김성훈
 * @version 1.0 2019/04/14
 */
public interface UserInterface {
    int getPurchasePrice() throws IllegalArgumentException;

    void printLottoList(List<Lotto> lottoList);

    List<Integer> getWinningLotto() throws IllegalArgumentException;

    int getBonusNumber() throws IllegalArgumentException;

    void printWinningStatistics(WinningLottoCalculation winningLottoCalculation);
}
