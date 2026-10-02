import java.util.ArrayList;
import java.util.List;

public class ScamAnalyzer {

    public RiskAssessment analyze(String message) {

        String text = message.toLowerCase();

        int score = 0;

        List<String> warnings = new ArrayList<>();

        // Prize and reward detection
        if (text.contains("won") ||
            text.contains("winner") ||
            text.contains("prize") ||
            text.contains("reward") ||
            text.contains("lottery")) {

            score += 20;
            warnings.add("Unexpected prize, reward or lottery claim detected.");
        }

        // Money request detection
        if (text.contains("pay") ||
            text.contains("payment") ||
            text.contains("processing fee") ||
            text.contains("transfer money") ||
            text.contains("send money")) {

            score += 25;
            warnings.add("Message asks for money or payment.");
        }

        // Sensitive information detection
        if (text.contains("otp") ||
            text.contains("password") ||
            text.contains("pin") ||
            text.contains("cvv") ||
            text.contains("bank details")) {

            score += 25;
            warnings.add("Message requests sensitive information.");
        }

        // Urgency detection
        if (text.contains("urgent") ||
            text.contains("immediately") ||
            text.contains("act now") ||
            text.contains("hurry") ||
            text.contains("within 24 hours")) {

            score += 15;
            warnings.add("Pressure or urgent language detected.");
        }

        // Link detection
        if (text.contains("http://") ||
            text.contains("https://") ||
            text.contains("www.") ||
            text.contains("click this link")) {

            score += 15;
            warnings.add("External link or website detected.");
        }

        // Account threat detection
        if (text.contains("account blocked") ||
            text.contains("account suspended") ||
            text.contains("account will be closed") ||
            text.contains("account terminated")) {

            score += 20;
            warnings.add("Threat of account suspension or closure detected.");
        }

        // Maximum score
        if (score > 100) {
            score = 100;
        }

        String riskLevel;

        if (score >= 60) {
            riskLevel = "HIGH";
        } else if (score >= 30) {
            riskLevel = "MEDIUM";
        } else {
            riskLevel = "LOW";
        }

        return new RiskAssessment(riskLevel, score, warnings);
    }
}