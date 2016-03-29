package com.example.marcoparolin.csvreader;

public class Address {
    public String type;
    public String name;
    public String number;
    public String intern;

    public Address(String t, String nam, String num, String in) {
        type = t;
        name = nam;
        number = num;
        if(in.length() > 0)
            intern = "interno " + in;
        else
            intern = "";
    }
    public Address(){
        type = null;
        name = null;
        number = null;
        intern = null;
    }


    @Override
    public int hashCode(){
        return (type+name+number).replace(" ", "").hashCode();
    }
}

