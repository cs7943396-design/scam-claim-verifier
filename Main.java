import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("       SCAM & CLAIM VERIFIER");
        System.out.println("==========================================");

        System.out.println();
        System.out.println("Enter the suspicious message:");
        System.out.println();

        String message = scanner.nextLine();

        ScamAnalyzer analyzer = new ScamAnalyzer();

        RiskAssessment result = analyzer.analyze(message);

        System.out.println();
        System.out.println("==========================================");
        System.out.println("              ANALYSIS RESULT");
        System.out.println("==========================================");

        System.out.println("Risk Level : " + result.getRiskLevel());
        System.out.println("Risk Score : " + result.getScore() + "/100");

        System.out.println();
        System.out.println("Warning Signs:");

        if (result.getWarnings().isEmpty()) {

            System.out.println("- No obvious warning signs detected.");

        } else {

            for (String warning : result.getWarnings()) {
                System.out.println("- " + warning);
            }
        }

        System.out.println();
        System.out.println("Recommendation:");

        System.out.println(
                Recommendation.getAdvice(result.getRiskLevel())
        );

        System.out.println();
        System.out.println("==========================================");

        scanner.close();
    }
}