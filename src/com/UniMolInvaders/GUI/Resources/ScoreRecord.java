package UniMolInvaders.GUI.Resources;

public class ScoreRecord {

    private Integer id;
    private String playerName;
    private String playDate;
    private Integer points;
    private Integer level;

    @Override
    public String toString() {
        return "ScoreRecord [id=" + id + ", palyerName=" + playerName
                + ", playDate=" + playDate + ", points=" + points + ", level=" + level + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayDate() {
        return playDate;
    }

    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
