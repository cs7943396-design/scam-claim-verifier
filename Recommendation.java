public class Recommendation {

    public static String getAdvice(String riskLevel) {

        if (riskLevel.equals("HIGH")) {

            return "Do not click suspicious links, transfer money, "
                    + "or share OTPs, passwords or banking information. "
                    + "Verify the message through an official source.";

        } else if (riskLevel.equals("MEDIUM")) {

            return "Be careful. Verify the sender and information "
                    + "through an official website or trusted source "
                    + "before taking action.";

        } else {

            return "No major warning signs were detected. "
                    + "However, always verify unexpected messages "
                    + "before taking action.";
        }
    }
}