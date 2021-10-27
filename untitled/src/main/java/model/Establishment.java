package model;

public class Establishment {

    private Integer id;
    private String name;
    private Address address;
    //private Blob image;
    private Integer waitingTime;

    public Establishment(Integer id, String name, Address address, Integer waitingTime) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.waitingTime = waitingTime;
    }

    public Establishment(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
