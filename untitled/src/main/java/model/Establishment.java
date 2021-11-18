package model;

public class Establishment {

    private String name;
    private Address address;
    private Integer waitingTime;
    private String category;
    private Integer cep;
    private Integer numero;
    private String login;
    private String senha;




    public Establishment(String name, Address address, Integer waitingTime, String category) {

        this.name = name;
        this.address = address;
        this.waitingTime = waitingTime;
        this.category = category;
    }


    public Establishment(String name, String category, Integer waitingTime, Integer cep, Integer numero, String login, String senha) {
        //this.id = id;
        this.name = name;
        this.category = category;
        this.waitingTime = waitingTime;
        this.cep = cep;
        this.numero=numero;
        this.login = login;
        this.senha = senha;
    }

    public Establishment(){

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

    public Integer getCep(){return  cep;}

    public void setCep(Integer cep){ this.cep = cep;}

    public Integer getNumero(){return  numero;}

    public void setNumero(Integer numero){ this.numero = numero;}

    public String getLogin(){return  login;}

    public void setLogin(String login){ this.login = login;}

    public String getSenha(){return  senha;}

    public void setSenha(String senha){ this.senha = senha;}
}

