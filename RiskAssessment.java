import java.util.List;

public class RiskAssessment {

    private String riskLevel;
    private int score;
    private List<String> warnings;

    public RiskAssessment(
            String riskLevel,
            int score,
            List<String> warnings) {

        this.riskLevel = riskLevel;
        this.score = score;
        this.warnings = warnings;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public int getScore() {
        return score;
    }

    public List<String> getWarnings() {
        return warnings;
    }
}