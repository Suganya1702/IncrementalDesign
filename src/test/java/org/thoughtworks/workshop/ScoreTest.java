package org.thoughtworks.workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ScoreTest {
    @InjectMocks
    Score score = new Score();
    @Mock
    Random random;

    @Test
    public void testScoreForEachBallReturnRandom(){
        when(random.nextInt(anyInt())).thenReturn(1);
        int [] actual = score.setScoreForEachBall();
        Assertions.assertArrayEquals(new int[]{1,1,1,1,1,1},actual);
    }

    @Test
    public void testScoreForEachBallReturnRandom_when_normalBatsmanType(){
        when(random.nextInt(anyInt())).thenReturn(1);
        int [] actual = score.setScoreForEachBall(BatsmanHittingType.NORMAL_BATSMAN.toString());
        Assertions.assertArrayEquals(new int[]{1,1,1,1,1,1},actual);
    }

    @Test
    public void testScoreForEachBallReturnRandom_when_defensiveBatsmanType(){
        when(random.nextInt(anyInt())).thenReturn(1)
                .thenReturn(1)
                .thenReturn(3)
                .thenReturn(2)
                .thenReturn(1)
                .thenReturn(2);
        int [] actual = score.setScoreForEachBall(BatsmanHittingType.DEFENSIVE.toString());
        Assertions.assertArrayEquals(new int[]{1,1,3,2,1,2},actual);
    }

    @Test
    public void testScoreForEachBallReturnRandom_when_hitterBatsmanType(){
        when(random.nextInt(anyInt())).thenReturn(4)
                .thenReturn(6)
                .thenReturn(0)
                .thenReturn(6)
                .thenReturn(0)
                .thenReturn(1);
        int [] actual = score.setScoreForEachBall(BatsmanHittingType.HITTER.toString());
        Assertions.assertArrayEquals(new int[]{4,6,0,6,0,1},actual);


    }

    @Test
    public void testRandomScoreGenerationForHitterBatsmanType(){
        List<Integer> scoreList = new ArrayList<Integer>(Arrays.asList(new Integer[]{0, 4, 6}));
        int actual = score.getRandomNumberForHitterBatsman();
        Assertions.assertEquals(true,scoreList.contains(actual));
    }


}
