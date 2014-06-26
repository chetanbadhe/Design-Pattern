package bing.conference.dpconference;

import bing.conference.restaurants.LemonGrassRestaurants;
import bing.conference.restaurants.Number5Restaurant;
import bing.conference.restaurants.PSRestaurant;
import bing.conference.restaurants.RestuarantInterface;

public class RestaurantFactory {


    public static RestuarantInterface createRestaurant (String restaurantName) {
    if (restaurantName. equalsIgnoreCase ("No5")){
           return new Number5Restaurant();
    }else if(restaurantName. equalsIgnoreCase ("PS")){
           return new PSRestaurant();
    }else if(restaurantName. equalsIgnoreCase ("LemonGrass")){
           return new LemonGrassRestaurants();
     }
    throw new IllegalArgumentException("No such Restaurant !!!");
    }

}
