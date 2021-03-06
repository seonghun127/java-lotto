/*
 * WinningLottoCalculation
 *
 * version 1.0
 *
 * 2019/04/11
 */

package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 당첨 통계를 내는 클래스
 *
 * @author 김성훈
 * @version 1.0 2019/04/11 당첨 통계 구현 (Map 자료구조 초기화 및 데이터 저장. 총 수입 계산. 수익률 계산. 통계 결과 출력 메소드 구현)
 */
public class WinningLottoCalculation {
    private static final double TOTAL_INPUT_MONEY = 1000.0;

    private List<Rank> rankList;
    // Map 자료구조를 이용해서 사용자 로또에 대한 각각의 Rank에 개수를 mapping
    private Map<Rank, Integer> rankCountMap = new HashMap<>();

    WinningLottoCalculation(List<Rank> ranksList) {
        this.rankList = ranksList;
        initRankCountMap();
        setRankCountMap();
    }

    private void initRankCountMap() {
        for (Rank rank : Rank.values()) {
            rankCountMap.put(rank, 0);
        }
    }

    private void setRankCountMap() {
        for (Rank rank : rankList) {
            rankCountMap.put(rank, rankCountMap.get(rank) + 1);
        }
    }

    private int calcTotalWinningMoney() {
        int totalWinningMoney = 0;
        for (Rank rank : rankList) {
            totalWinningMoney += rank.getWinningMoney();
        }
        return totalWinningMoney;
    }

    private Double calcProfitRate(int totalWinningMoney) {
        return totalWinningMoney / (rankList.size() * TOTAL_INPUT_MONEY);
    }

    void printStatistics() {
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getCountOfMatch() + "개 일치 "
                    + (rank.equals(Rank.SECOND) ? ", 보너스볼 일치 " : "")
                    + "(" + rank.getWinningMoney() + "원) - " + rankCountMap.get(rank) + "개");
        }
        System.out.println(String.format("총 수익률은 %.3f입니다.", calcProfitRate(calcTotalWinningMoney())));
    }
}
