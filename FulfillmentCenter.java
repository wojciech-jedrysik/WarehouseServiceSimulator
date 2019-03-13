import java.util.*;


class FulfillmentCenter {
    private String storeName;
    private List<Item> numProd = new ArrayList<Item>();
    private double capacity;

    FulfillmentCenter(String name, double capacity){
        storeName = name;
        this.capacity = capacity;
    }

    String getName(){
        return storeName;
    }

    double getMass(){
        double mass = 0;
        for (Item item : numProd) {
            mass += item.getMass();
        }
        return mass;
    }

    void addProduct(Item item) {
        double mass = 0;
        boolean same = false;
        int index = 0;
        for (int i = 0; i < numProd.size(); i++) {
            Item item1 = numProd.get(i);
            mass += item1.getMass();
            if (item1.compareTo(item) == 0) {
                same = true;
                index = i;
            }
        }

        if (mass + item.getMass() > capacity) {
            System.err.println("The item can not be added because the warehouse is full!");
        } else {
            if (same) {
                numProd.get(index).addAmount(item.getAmount());
            } else {
                numProd.add(item);
            }
        }
    }

    void getProduct(Item item) {
        if (numProd.contains(item)) {
            numProd.get(numProd.indexOf(item)).addAmount(-1);
            if (numProd.get(numProd.indexOf(item)).getAmount() == 0) {
                numProd.remove(item);
            }
        }
    }

    void removeProduct(Item item) {
        numProd.remove(item);
    }

    Item search(String name) {
        Item item = numProd.get(0);
        for (int i = 1; i < numProd.size(); i++) {
            item = numProd.get(i);
            if (name.compareTo(item.getName()) == 0) {
                break;
            }
        }
        return item;
    }

    List<Item> searchPartial(String name) {
        List<Item> list = new ArrayList<>();
        for (Item item : numProd) {
            if (item.getName().contains(name)) {
                list.add(item);
            }
        }
        return list;
    }

    int countByCondition(ItemCondition condition) {
        int count = 0;
        for (Item item : numProd) {
            if (item.getCondition().compareTo(condition) == 0) {
                count++;
            }
        }
        return count;
    }

    void summary() {
        for (Item item : numProd) {
            item.print();
        }
    }

    List<Item> sortByName() {
        List<Item> list = numProd;
        list.sort(Comparator.comparing(Item::getName));
        return list;
    }

    List<Item> sortByAmount(){
        numProd.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.getAmount() > o2.getAmount()) return -1;
                else return (o1.getAmount() < o2.getAmount()) ? 1 : 0;
            }
        });
        return numProd;
    }

    Item max(){
        return Collections.max(numProd, Comparator.comparingInt(Item::getAmount));
    }

    double getCap(){
        return capacity;
    }
}
