package org.thoughtworks.workshop;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ChaseTarget {
    Batsman batsman = new Batsman();
    Score score = new Score();
    Bowler bowler = new Bowler();

    public boolean isBatsmanTargetAchieved(int targetScore,int sumOfScores){
        if(sumOfScores >=  targetScore) {
            return true;
        }
        return false;
    }

    public String displayWinningResults(int targetScore,int over,String batsmanType){
        for (int i=0; i< over; i++){
            System.out.println(score.setScoreForEachBall(batsmanType).toString());
            System.out.println(batsman.toString());
            batsman.setScores(Arrays.asList(score.setScoreForEachBall(batsmanType)));
            batsman.setTarget(targetScore);
            bowler.setScores(Arrays.asList(score.setScoreForEachBall()));

            int sumOfBatsManScore = Arrays.stream(batsman.getScores().get(i)).sum();
            if( isBatsmanAndBowlerScoresSame(batsman.getScores().get(i),bowler.getScores().get(i)) &&
                    isBatsmanTargetAchieved(batsman.getTarget(), sumOfBatsManScore) )
            return "Batsman has won";
        }
        return "Bowler has won";
    }

    public boolean isBatsmanAndBowlerScoresSame(int[] batsmanScore, int[] bowlersScore){
        return IntStream.range(0,batsmanScore.length)
                .filter(i->batsmanScore[i] == bowlersScore[i])
                .map(i->batsmanScore[i])
                .toArray().length > 0;

    }



}