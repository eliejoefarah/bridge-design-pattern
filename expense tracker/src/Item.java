public class Item {

    private String type;
    private double price;
    private double budgetRem;
    private double savingsRem;

    public Item() {
        this.type = "";
        this.price = 0;
        this.budgetRem = 0;
        this.savingsRem = 0;
    }

    public Item(String type, double price, int budgetRem, int savingsRem) {
        this.type = type;
        this.price = price;
        this.budgetRem = budgetRem;
        this.savingsRem = savingsRem;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBudgetRem() {
        return this.budgetRem;
    }

    public void setBudgetRem(double budgetRem) {
        this.budgetRem = budgetRem;
    }

    public double getSavingsRem() {
        return this.savingsRem;
    }

    public void setSavingsRem(double savingsRem) {
        this.savingsRem = savingsRem;
    }

}
