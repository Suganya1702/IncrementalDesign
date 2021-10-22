package org.thoughtworks.workshop;

import java.util.List;

public class Batsman {

    private int target;
    private List<int[]> scores;

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public List<int[]> getScores() {
        return scores;
    }

    public void setScores(List<int[]> scores) {
        this.scores = scores;
    }
}