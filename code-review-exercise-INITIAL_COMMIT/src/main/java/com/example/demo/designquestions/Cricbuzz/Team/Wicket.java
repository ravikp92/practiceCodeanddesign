package src.main.java.com.example.demo.designquestions.Cricbuzz.Team;

import src.main.java.com.example.demo.designquestions.Cricbuzz.Inning.BallDetails;
import src.main.java.com.example.demo.designquestions.Cricbuzz.Inning.OverDetails;
import src.main.java.com.example.demo.designquestions.Cricbuzz.Team.Player.PlayerDetails;

public class Wicket {

    public WicketType wicketType;
    public PlayerDetails takenBy;
    public OverDetails overDetail;
    public BallDetails ballDetail;

    public Wicket(WicketType wicketType, PlayerDetails takenBy, OverDetails overDetail, BallDetails ballDetail){

        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.overDetail = overDetail;
        this.ballDetail = ballDetail;
    }
}
