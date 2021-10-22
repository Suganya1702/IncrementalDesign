package org.thoughtworks.workshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ChaseTargetTest {
    @Mock
    Score mockScore;

    @InjectMocks
    ChaseTarget chaseTarget = new ChaseTarget();


    @Test
    public void testTargetAcheived(){
        ChaseTarget chaseTarget = new ChaseTarget();
        boolean expected = chaseTarget.isBatsmanTargetAchieved(12,13);
        Assertions.assertEquals(true,expected);
    }

    @Test
    public void testTargetNotAchieved(){
        ChaseTarget chaseTarget = new ChaseTarget();
        boolean actual = chaseTarget.isBatsmanTargetAchieved(8,6);
        Assertions.assertEquals(false,actual);
    }

    @Test
    public void testBatsmanAndBowlerScoresSame(){
        ChaseTarget chaseTarget = new ChaseTarget();
        int[] batsman = {4,7,0,1,5,8};
        int[] bowler = {1,2,3,4,5,6};
        boolean actual = chaseTarget.isBatsmanAndBowlerScoresSame(batsman,bowler);
        Assertions.assertEquals(true,actual);
    }
    @Test
    public void testBatsmanAndBowlerScoresNotSame(){
        ChaseTarget chaseTarget = new ChaseTarget();
        int[] batsman = {4,7,0,1,5,8};
        int[] bowler = {1,2,3,4,8,6};
        boolean actual = chaseTarget.isBatsmanAndBowlerScoresSame(batsman,bowler);
        Assertions.assertEquals(false,actual);
    }

    @Test
    public void testBatsManWon(){
        int[] batsman = {4,7,0,1,5,8};
        int[] bowler = {1,2,3,4,5,6};
        doReturn(batsman).when(mockScore).setScoreForEachBall(anyString());
        doReturn(bowler).when(mockScore).setScoreForEachBall();
        String actual = chaseTarget.displayWinningResults(6,1,BatsmanHittingType.NORMAL_BATSMAN.toString());
        Assertions.assertEquals("Batsman has won",actual);
    }

    @Test
    public void testBowlerWon(){
        int[] batsman = {4,7,0,1,5,8};
        int[] bowler = {1,2,3,4,8,6};
        doReturn(batsman).when(mockScore).setScoreForEachBall(anyString());
        doReturn(bowler).when(mockScore).setScoreForEachBall();
        String actual = chaseTarget.displayWinningResults(6,1,BatsmanHittingType.NORMAL_BATSMAN.toString());
        Assertions.assertEquals("Bowler has won",actual);
    }



}