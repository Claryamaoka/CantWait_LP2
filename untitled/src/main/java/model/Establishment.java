package model;

public class Establishment {

    //private Integer id;
    private String name;
    private Address address;
    //private Blob image;
    private Integer waitingTime;
    private String category;

    public Establishment(String name, Address address, Integer waitingTime, String category) {
        //this.id = id;
        this.name = name;
        this.address = address;
        this.waitingTime = waitingTime;
        this.category = category;
    }

    public Establishment(String name, String category, Integer waitingTime) {
        //this.id = id;
        this.name = name;
        this.category = category;
        this.waitingTime = waitingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Integer waitingTime) {
        this.waitingTime = waitingTime;
    }

    public String getCategory(){ return category;}

    public void setCategory(String category){
        this.category = category;
    }


   /* public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }*/
}
