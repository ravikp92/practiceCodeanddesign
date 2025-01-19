package src.main.java.com.example.demo.designquestions.Cricbuzz.ScoreUpdater;


import src.main.java.com.example.demo.designquestions.Cricbuzz.Inning.BallDetails;

public interface ScoreUpdaterObserver {

    public void update(BallDetails ballDetails);
}
