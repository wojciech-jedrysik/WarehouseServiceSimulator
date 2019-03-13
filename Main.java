public class Main {

    public static void main(String[] args) {
        Item item1 = new Item("Something1", 12, ItemCondition.NEW, 10);
        Item item2 = new Item("Something2", 3.1, ItemCondition.REFURBISHED, 2);

        item1.print();
        item2.print();

        FulfillmentCenterContainer all = new FulfillmentCenterContainer();
        all.addCenter("Cieszyn", 20);
        all.addCenter("Katowice", 80);
        all.addCenter("Szczecin", 65);

        all.stores.get("Cieszyn").addProduct(item1);
        all.stores.get("Cieszyn").addProduct(item2);
        all.stores.get("Cieszyn").addProduct(item1);
        all.stores.get("Cieszyn").addProduct(item2);

        all.stores.get("Cieszyn").removeProduct(item1);
        all.stores.get("Cieszyn").getProduct(item2);
        all.stores.get("Cieszyn").addProduct(item1);

        System.out.println("Total in a warehouse in Cieszyn:");
        all.stores.get("Cieszyn").summary();

        System.out.println("Searching for a Something2:");
        all.stores.get("Cieszyn").search("Something2").print();

        System.out.println("Counting items by a condition NEW in Cieszyn:");
        System.out.println(all.stores.get("Cieszyn").countByCondition(ItemCondition.NEW));

        System.out.println("Partial searching for the 'thing' fragment:");
        all.stores.forEach((key, value) -> value.searchPartial("thing").forEach(Item::print));

        System.out.println("Sorting by name:");
        all.stores.forEach((key, value) -> value.sortByName().forEach(Item::print));

        System.out.println("Sorting by amount:");
        all.stores.forEach((key, value) -> value.sortByAmount().forEach(Item::print));

        System.out.println("The product with the largest amount in Cieszyn:");
        all.stores.get("Cieszyn").max().print();

        System.out.println("Searching for empty warehouses:");
        for(FulfillmentCenter center : all.findEmpty()){
            System.out.println(center.getName());
        }

        // Summary of warehouses
        all.summary();

        // Removing the warehouse in Szczecin
        all.removeCenter("Szczecin");

    }
}
