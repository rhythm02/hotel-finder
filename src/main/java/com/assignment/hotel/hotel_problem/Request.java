package com.assignment.hotel.hotel_problem;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Request {
    Customer customerType;
    List<String> listDates = new ArrayList<String>();

    Request(Customer customerType, List<String> dates){
        this.customerType = customerType;
        this.listDates = dates;
    }



}
