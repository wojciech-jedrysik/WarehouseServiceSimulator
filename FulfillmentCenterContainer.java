import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class FulfillmentCenterContainer {
    Map<String, FulfillmentCenter> stores = new TreeMap<>();

    void addCenter(String name, double capacity){
        FulfillmentCenter store = new FulfillmentCenter(name, capacity);
        stores.put(name, store);
    }

    void removeCenter(String name){
        stores.remove(name);
    }

    List<FulfillmentCenter> findEmpty(){
        List<FulfillmentCenter> empty = new ArrayList<>();
        for(Map.Entry<String,FulfillmentCenter> entry : stores.entrySet()) {
            FulfillmentCenter value = entry.getValue();

            if(value.getMass() == 0){
                empty.add(value);
            }
        }
        return empty;
    }

    void summary(){
        System.out.println("INFORMATION ABOUT WAREHOUSES:");

        for(Map.Entry<String,FulfillmentCenter> entry : stores.entrySet()) {
            String key = entry.getKey();
            FulfillmentCenter value = entry.getValue();

            System.out.println("The name of the warehouse: " + key);
            System.out.println("Percentage full: " + (Math.round((value.getMass()/value.getCap())*100)) + "%");
        }
    }
}
