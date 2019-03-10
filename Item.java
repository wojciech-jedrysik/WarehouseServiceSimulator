public class Item implements Comparable<Item> {
    private String nazwa;
    private ItemCondition stan;
    private double masa;
    private int ilosc;

    Item(String nazwa, double masa, ItemCondition stan, int ilosc){
        this.nazwa = nazwa;
        this.masa = masa;
        this.stan = stan;
        this.ilosc = ilosc;
    }

    void print(){
        System.out.println("INFORMACJE O TOWARZE:");
        System.out.println("Nazwa towaru: " + nazwa);
        System.out.println("Stan: " + stan);
        System.out.println("Masa: " + masa);
        System.out.println("Ilość: " + ilosc);
    }

    @Override
    public int compareTo(Item item){
        return nazwa.compareTo(item.nazwa);
    }

    double getMasa(){
        return masa;
    }

    int getIlosc(){
        return ilosc;
    }

    void addIlosc(int ilosc){
        this.ilosc += ilosc;
    }

    String getNazwa(){
        return nazwa;
    }

    ItemCondition getStan(){
        return stan;
    }
}
