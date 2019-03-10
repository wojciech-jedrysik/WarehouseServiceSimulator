import java.util.*;


public class FulfillmentCenter {
    private String nazwaMag;
    private List<Item> lProd = new ArrayList<Item>();
    private double max;

    public void addProduct(Item item) {
        double masa = 0;
        boolean same = false;
        int index = 0;
        for (int i = 0; i < lProd.size(); i++) {
            Item item1 = lProd.get(i);
            masa += item1.getMasa();
            if (item1.compareTo(item) == 0) {
                same = true;
                index = i;
            }
        }

        if (masa + item.getMasa() > max) {
            System.err.println("Nie można dodać towaru, ponieważ magazyn jest przepełniony!");
        } else {
            if (same) {
                lProd.get(index).addIlosc(item.getIlosc());
            } else {
                lProd.add(item);
            }
        }
    }

    public void getProduct(Item item) {
        if (lProd.contains(item)) {
            lProd.get(lProd.indexOf(item)).addIlosc(-1);
            if (lProd.get(lProd.indexOf(item)).getIlosc() == 0) {
                lProd.remove(item);
            }
        }
    }

    public void removeProduct(Item item) {
        lProd.remove(item);
    }

    Item search(String nazwa) {
        Item item = lProd.get(0);
        for (int i = 1; i < lProd.size(); i++) {
            item = lProd.get(i);
            if (nazwa.compareTo(item.getNazwa()) == 0) {
                break;
            }
        }
        return item;
    }

    List<Item> searchPartial(String nazwa) {
        List<Item> lista = new ArrayList<Item>();
        for (int i = 0; i < lProd.size(); i++) {
            if (lProd.get(i).getNazwa().contains(nazwa)) {
                lista.add(lProd.get(i));
            }
        }
        return lista;
    }

    int countByCondition(ItemCondition stan) {
        int count = 0;
        for (int i = 0; i < lProd.size(); i++) {
            if (lProd.get(i).getStan().compareTo(stan) == 0) {
                count++;
            }
        }
        return count;
    }

    void summary() {
        for (int i = 0; i < lProd.size(); i++) {
            lProd.get(i).print();
        }
    }

    List<Item> sortByName() {
        List<Item> lista = lProd;
        lista.sort(Comparator.comparing(Item::getNazwa));
        return lista;
    }

    List<Item> sortByAmount(){
        List<Item> posortowana = Collections.sort(lProd, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getIlosc() > o2.getIlosc() ? -1 : (o1.getIlosc() < o2.getIlosc()) ? 1 : 0;
            }
        });
        return posortowana;
    }




}
