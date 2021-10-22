package org.thoughtworks.workshop;

import sun.security.util.ArrayUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Score {
    Random random = new Random();
    private final int NO_OF_BALLS = 6;
    int[] scoreForEachBall = new int[NO_OF_BALLS];

    public int generateRandomNumbers(int bound){
        return random.nextInt(bound);
    }

    public int[] setScoreForEachBall(String batsmanType){
        for(int j=0;j<NO_OF_BALLS;j++){
            if(BatsmanHittingType.HITTER.equals(batsmanType)) {
                scoreForEachBall[j] = getRandomNumberForHitterBatsman();
            }else if(BatsmanHittingType.DEFENSIVE.equals(batsmanType)) {
                scoreForEachBall[j] = generateRandomNumbers(3);
            }else {
                scoreForEachBall[j] = generateRandomNumbers(6);
            }

        }
        return scoreForEachBall;
    }
    public int[] setScoreForEachBall(){
        for(int j=0;j<NO_OF_BALLS;j++){
                scoreForEachBall[j] = generateRandomNumbers(NO_OF_BALLS);
        }
        return scoreForEachBall;
    }

    public int getRandomNumberForHitterBatsman() {
            int[] scores = {0, 4, 6};
            double random = Math.random();
            if(random < 0.33){
                return 0;
            } else if(random < 0.66) {
                return 4;
            } else {
                return 6;
            }
        }


}

