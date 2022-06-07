/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;


public class DRecibos {
 private String Envoice;
 private Date Date;
 private String Truck;
 private float Total;
 private String Details;
 private int Year;
 private String Image;

    public String getEnvoice() {
        return Envoice;
    }

    public void setEnvoice(String Envoice) {
        this.Envoice = Envoice;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getTruck() {
        return Truck;
    }

    public void setTruck(String Truck) {
        this.Truck = Truck;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public DRecibos(String Envoice, Date Date, String Truck, float Total, String Details, int Year, String Image) {
        this.Envoice = Envoice;
        this.Date = Date;
        this.Truck = Truck;
        this.Total = Total;
        this.Details = Details;
        this.Year = Year;
        this.Image = Image;
    }

    public DRecibos() {
    }
}