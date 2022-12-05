
public class Savings extends Allocations {

	public Savings(Earnings E) {
		super(E);
	}

	public static double Savings;
	public static double CurrentBudget;

	public void setSavings(double savings) {
		E.Expense(savings);
		Savings = savings;
	}

	public double getSavings() {
		return Savings;
	}

	public static void addSavings(double addedSavings) {
		Savings += addedSavings;

	}

	public boolean setBudget(double budget) {
		// This class is like the budget the user can specify
		// for how much money he wants to spend each month or like a
		// "cap" for how much he pays

		if (budget > Savings) {
			// Throw Exception or Error message
			System.out.println("The budget must be equal or less than the savings");
			return false;
			// Repeat the statement
		} else {
			System.out.println("Budget Set");
			Budget = Math.abs(budget);
			CurrentBudget = Budget;
			return true;
		}
	}

	public double getBudget() {
		return Budget;
	}

	public static void BudgetUpdate(double p) {
		CurrentBudget = CurrentBudget - p;
		Savings = Savings - p;
	}

	public static boolean addBudget(double p) {
		if (p > Savings) {
			// Throw Exception or Error message
			// System.out.println("The budget must be equal or less than the savings");
			return false;

		} else {
			CurrentBudget = CurrentBudget + p;
			return true;
		}

	}

	public static double HowMuchLeft() {
		return CurrentBudget;
	}

	public static double percentageLeft() {
		// How much % of the budget is left
		return (CurrentBudget * 100) / Budget;
	}

	public static String LatestPurchase() {
		return "Your latest purchase was : " + Payment.NameP + ". And "
				+ "you bought them for : " + Payment.PriceP;
	}

}