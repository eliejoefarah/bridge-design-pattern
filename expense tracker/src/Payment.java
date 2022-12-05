
import java.util.HashMap;

public class Payment implements Expenses {

	public void Expense(double exp) {

		Savings.BudgetUpdate(exp);
		totalPaid += exp;
	}

	public static HashMap<String, Double> ItemMap = new HashMap<>();
	public static String NameP;
	public static double PriceP;
	public static double totalPaid;

	public static boolean ItemPurchase(double Price, String name) {

		if (Price <= Savings.CurrentBudget) {
			if (ItemMap.containsKey(name)) {

				PriceP = Price;
				NameP = name;

				ItemMap.replace(name, ItemMap.get(name), ItemMap.get(name) + Price);

				Savings.BudgetUpdate(Price);

				totalPaid += Price;

			} else {

				ItemMap.put(name, Price);

				Savings.BudgetUpdate(Price);

				PriceP = Price;
				NameP = name;

				totalPaid += Price;

			}
			return true;
		} else {

			return false;
		}
	}
}