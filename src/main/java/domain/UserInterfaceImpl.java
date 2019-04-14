package domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 사용자인터페이스를 구현한 클래스
 *
 * @author 김성훈
 * @version 1.0 2019/04/14  사용자 화면에 보여지는 모든 인터페이스 기능 구현
 */
public class UserInterfaceImpl implements UserInterface {
    private static final int LOTTO_PER_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public int getPurchasePrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int purchasePrice = Integer.parseInt(SCANNER.nextLine());
        if (purchasePrice < LOTTO_PER_PRICE) {
            throw new IllegalArgumentException("1000원 이상의 가격을 입력헤주세요.");
        }
        return purchasePrice / LOTTO_PER_PRICE;
    }

    @Override
    public void printLottoList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            lotto.printLotto();
        }
    }

    @Override
    public List<Integer> getWinningLotto() {
        System.out.println("지난주 당첨 번호를 입력헤 주세요.");
        String[] lastWeekWinningLotto =
                SCANNER.nextLine().replaceAll(" ", "").trim().split(",");
        if(lastWeekWinningLotto.length != LOTTO_SIZE){
            throw new IllegalArgumentException("로또 번호 6개를 입력해주세요.");
        }
        return Arrays.stream(lastWeekWinningLotto).map(Integer::valueOf).collect(Collectors.toList());
    }

    @Override
    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력헤 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    @Override
    public void printWinningStatistics(WinningLottoCalculation winningLottoCalculation) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        winningLottoCalculation.printStatistics();
    }
}
