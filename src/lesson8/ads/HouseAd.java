package lesson8.ads;


public class HouseAd extends Ad {
    String ownerName;
    String address;
    double square;
    int floors;

    public HouseAd(long id, int price, String ownerName, String address, double square, int floors) {
        super(id, price);
        this.ownerName = ownerName;
        this.address = address;
        this.square = square;
        this.floors = floors;
    }

    public boolean checkOwner(){
        Owners owners = new Owners();
        for (String name : owners.owners){
            if (ownerName == name)
                return true;
        }
        return false;
    }
}
