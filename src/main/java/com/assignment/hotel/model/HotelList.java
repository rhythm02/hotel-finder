package com.assignment.hotel.model;

import com.assignment.hotel.utility.DateToDay;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Getter
public class HotelList{
        ArrayList<Hotel> hotels = new ArrayList<>();
        Hotel lakewood;
        Hotel bridgewood;
        Hotel ridgewood;

        public void init(){
            Map<Category, Integer> mapLakewood = new HashMap<Category, Integer>();
            mapLakewood.put(new Category(Customer.REGULAR, Days.WEEKDAY),110);
            mapLakewood.put(new Category(Customer.REGULAR, Days.WEEKEND), 90);
            mapLakewood.put(new Category(Customer.REWARD, Days.WEEKDAY), 80);
            mapLakewood.put(new Category(Customer.REWARD, Days.WEEKEND), 80);

            Map<Category, Integer> mapBridgewood = new HashMap<Category, Integer>();
            mapBridgewood.put(new Category(Customer.REGULAR, Days.WEEKDAY), 160);
            mapBridgewood.put(new Category(Customer.REGULAR, Days.WEEKEND), 60);
            mapBridgewood.put(new Category(Customer.REWARD, Days.WEEKDAY), 110);
            mapBridgewood.put(new Category(Customer.REWARD, Days.WEEKEND), 50);


            Map<Category, Integer> mapRidgewood = new HashMap<Category, Integer>();
            mapRidgewood.put(new Category(Customer.REGULAR, Days.WEEKDAY), 220);
            mapRidgewood.put(new Category(Customer.REGULAR, Days.WEEKEND), 150);
            mapRidgewood.put(new Category(Customer.REWARD, Days.WEEKDAY), 100);
            mapRidgewood.put(new Category(Customer.REWARD, Days.WEEKEND), 40);

            lakewood = new Hotel("Lakewood", 3, mapLakewood);
            bridgewood = new Hotel("Bridgewood", 4, mapBridgewood);
            ridgewood = new Hotel("Ridgewood", 4, mapRidgewood);

            hotels.add(lakewood);
            hotels.add(bridgewood);
            hotels.add(ridgewood);
        }
        
        public int findTotalCost(Hotel hotel, Request request){
            int cost=0;
            int totalCost=0;
            Map<Category, Integer> map = hotel.getMap();

            for (String date:request.listDates
            ) {
                int day = new DateToDay().getDay(date);
                if(day >= Calendar.MONDAY && day <= Calendar.FRIDAY){
                    if(request.getCustomerType().equals(Customer.REGULAR)) {
                        cost = map.get(new Category(Customer.REGULAR, Days.WEEKDAY));
                    }
                    else {
                        cost = map.get(new Category(Customer.REWARD, Days.WEEKDAY));
                    }
                }
                else{
                    if(request.getCustomerType().equals(Customer.REGULAR)) {
                        cost = map.get(new Category(Customer.REGULAR, Days.WEEKEND));
                    }
                    else {
                        cost = map.get(new Category(Customer.REWARD, Days.WEEKEND));
                    }
                }
                totalCost = totalCost+cost;
            }
            return totalCost;
        }

}
