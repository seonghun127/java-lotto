package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 로또 어플리케이션을 실행시키위한 클래스
 *
 * @author 김성훈
 * @version 1.0 2019/04/14  UserInterface, LottoGenerator를 인스턴스화시켜서 프로그램 기능 구현
 */
public class Game {
    private UserInterface userInterface;
    private LottoGenerator lottoGenerator;

    Game(UserInterface userInterface, LottoGenerator lottoGenerator) {
        this.userInterface = userInterface;
        this.lottoGenerator = lottoGenerator;
    }

    void play() {
        List<Lotto> lottoList = issueUserLottoList(getLottoCountByPurchasePrice());
        userInterface.printLottoList(lottoList);
        userInterface.printWinningStatistics(
                new WinningLottoCalculation(setLottoListToRank(lottoList, setWinningLotto()))
        );
    }

    private int getLottoCountByPurchasePrice() {
        try {
            return userInterface.getPurchasePrice();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getLottoCountByPurchasePrice();
        }
    }

    private List<Lotto> issueUserLottoList(int lottoCount) {
        try {
            List<Lotto> lottoList = new ArrayList<>();
            while (lottoList.size() < lottoCount) {
                lottoList.add(new Lotto(lottoGenerator.makeLotto()));
            }
            return lottoList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return issueUserLottoList(lottoCount);
        }
    }

    private WinningLotto setWinningLotto() {
        try {
            Lotto winningLotto = new Lotto(parseWinningLottoToSet(userInterface.getWinningLotto()));
            int bonusNumber = setBonusNumber(winningLotto);
            return new WinningLotto(winningLotto, bonusNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setWinningLotto();
        }
    }

    private int setBonusNumber(Lotto winningLotto){
        try{
            int bonusNumber =  userInterface.getBonusNumber();
            if(winningLotto.contain(bonusNumber)){
                throw new IllegalArgumentException("당첨 번호와 중복됩니다.");
            }
            return new LottoNumber(bonusNumber).getLottoNumber();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return setBonusNumber(winningLotto);
        }
    }

    private Set<Integer> parseWinningLottoToSet(List<Integer> winningLotto) {
        Set<Integer> winningLottoSet = new HashSet<>();
        for (int winningLottoNumber : winningLotto) {
            winningLottoSet.add(new LottoNumber(winningLottoNumber).getLottoNumber());
        }
        return winningLottoSet;
    }

    private List<Rank> setLottoListToRank(List<Lotto> lottoList, WinningLotto winningLotto) {
        List<Rank> rankList = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            rankList.add(winningLotto.match(lotto));
        }
        return rankList;
    }
}
