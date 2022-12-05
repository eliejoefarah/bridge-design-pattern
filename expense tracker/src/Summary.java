
import java.util.Map;

public class Summary {

    public static String getCurrentSummary() {
        System.out.println("List of Items and Prices: ");

        for (Map.Entry<String, Double> entry : Payment.ItemMap.entrySet()) {

            System.out.println(entry.getKey() + ": " + Payment.ItemMap.get(entry.getKey()));

        }

        String toReturn = "Total payments this month: " + Payment.totalPaid + "\n" + "Remaining budget: "
                + Savings.HowMuchLeft() + "\n" + "Remaining budget Percentage: " + Savings.percentageLeft();
        return toReturn;

    }

}