/*
 * User
 *
 * version 1.0
 *
 * 2019/04/11
 */

package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또를 발급하고 당첨 계산을 수행하는 주체
 *
 * @author 김성훈
 * @version 1.0 2019/04/11  사용자가 로또를 하는 행위를 순차적으로 구현
 */
public class User {
    private UserInput userInput = new UserInput();
    private LottoGenerator lottoGenerator = new LottoGenerator();

    public void doLotto() {
        WinningLottoCalculation winningLottoCalculation =
                new WinningLottoCalculation(
                        setUserLottoToRank(issueUserLotto(userInput.inputTotalPrice()),
                                issueWinningLotto()));

        winningLottoCalculation.printStatistics();
    }

    private List<Lotto> issueUserLotto(int lottoCount) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoGenerator.setLottoNumber());
            list.add(lotto);
            lotto.printLottoNumbers();
        }
        return list;
    }

    private WinningLotto issueWinningLotto() {
        List<Integer> winningNumbers = userInput.inputWinningNumbers();
        int bonusNumber = userInput.inputBonusNumber(winningNumbers);
        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }

    private List<Rank> setUserLottoToRank(List<Lotto> lottoList, WinningLotto winningLotto) {
        List<Rank> rankList = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            rankList.add(winningLotto.match(lotto));
        }
        return rankList;
    }
}