public class Item implements Comparable<Item> {
    private String name;
    private ItemCondition condition;
    private double mass;
    private int amount;

    Item(String name, double mass, ItemCondition condition, int quantity){
        this.name = name;
        this.mass = mass;
        this.condition = condition;
        this.amount = quantity;
    }

    void print(){
        System.out.println("INFORMATION ABOUT THE GOODS:");
        System.out.println("Product name: " + name);
        System.out.println("Condition: " + condition);
        System.out.println("Mass: " + mass);
        System.out.println("Amount: " + amount);
    }

    @Override
    public int compareTo(Item item){
        return name.compareTo(item.name);
    }

    double getMass(){
        return mass;
    }

    int getAmount(){
        return amount;
    }

    void addAmount(int amount){
        this.amount += amount;
    }

    String getName(){
        return name;
    }

    ItemCondition getCondition(){
        return condition;
    }
}
