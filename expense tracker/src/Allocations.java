
public abstract class Allocations {

	// This Class is the first part of the bridge, its the savings and
	// budget class basically, which work as the abstraction.

	Earnings E;

	public Allocations(Earnings E) {
		this.E = E;
	}

	public static double Budget;
	public static double Money;

	protected double getMoney() {
		return Money;
	}

	protected void setMoney(double money) {
		Money = money;
	}

	abstract public void setSavings(double savings);

	abstract public double getSavings();

	public static void addMoney(double money) {
		Money = Money + money;
	}

	public abstract boolean setBudget(double Budget);

	public abstract double getBudget();
}