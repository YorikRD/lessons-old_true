package lesson10;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("string 1");
        linkedList.add("string 2");
        linkedList.add("string 3");

        System.out.println(linkedList.get(2));


        Transport transport1 = new Transport("Москва", "Тверь", "123У");
        Transport transport2 = new Transport("Санкт-Петербург", "Тамбов", "468Ф");

        LinkedList<Transport> transportList = new LinkedList<>();
        transportList.add(transport1);
        transportList.add(transport2);

        Bus bus = new Bus("Самара", "Рязань", "2326P", true);
        transportList.add(bus);

        Transport transportFromList = transportList.get(1);

//        ClassCastException
//        Bus busFromList = (Bus) transportList.get(2);
//        busFromList.isWiFi();

//        LinkedList<Bus> busLinkedList = new LinkedList<>();
//        busLinkedList.add(transport1);
//        getThird(busLinkedList);

    }


    public static Bus getThird(LinkedList<? extends Transport> list){
//        Transport transport = new Transport("Самара", "Рязань", "2326P");
//        list.add(transport); // null

        Transport transport1 = list.get(2);
        return (Bus) transport1;
    }

    public void addToList(LinkedList<? super Transport> list){
        Bus bus = new Bus("Самара", "Рязань", "2326P", true);
        list.add(bus);

        Transport transport = new Transport("Самара", "Рязань", "2326P");
        list.add(transport); // null

        Object o = list.get(2);
        Transport transport1 = (Transport) list.get(2);
    }

//    public void addToList(LinkedList<?> list){}
}
