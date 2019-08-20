package com.company.Helper.SupportClasses;

public class Booking {
    private String checkInDate, checkOutDate;
    private String hotelName;

    public Booking(String receivedCheckInDate, String receivedCheckOutDate){
        setDates(receivedCheckInDate,receivedCheckOutDate);
    }

    public void setDates(String receivedCheckInDate, String receivedCheckOutDate){
        checkInDate = receivedCheckInDate;
        checkOutDate = receivedCheckOutDate;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCheckInDate(){return checkInDate;}
    public String getCheckOutDate(){return checkOutDate;}
    public String getHotelName(){return hotelName;}
}
