package edu.gsu.student.csc4360;


import android.util.Log;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Tire {

    private String brand, model, part_number, width, aspect_ratio, construction, wheel_diameter, max_load, max_psi,
                  ply, load_rating, speed_rating, weight, cost, sales_price, cost_per_unit, image;

    private boolean has_warranty, is_dot_approved, is_discontinued;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPart_number() {
        return part_number;
    }

    public String getWidth() {
        return width;
    }

    public String getAspect_ratio() { return aspect_ratio; }

    public String getConstruction() {
        return construction;
    }

    public String getWheel_diameter() {
        return wheel_diameter;
    }

    public String getMax_load() {
        return max_load;
    }

    public String getMax_psi() {
        return max_psi;
    }

    public String getPly() {
        return ply;
    }

    public String getLoad_rating() {
        return load_rating;
    }

    public String getSpeed_rating() {
        return speed_rating;
    }

    public String getWeight() {
        return weight;
    }

    public String getCost() {
        return cost;
    }

    public String getSales_price() {
        return sales_price;
    }

    public String getCost_per_unit() {
        return cost_per_unit;
    }

    public String getImage() {
        return image;
    }

    public boolean getHas_warranty() {
        return has_warranty;
    }

    public boolean getIs_dot_approved() {
        return is_dot_approved;
    }

    public boolean getIs_discontinued() {
        return is_discontinued;
    }

    public boolean setBrand(String brand) {
        // todo get brands from Globals.db.getBrands() and verify that the brand actually exists
        //      inside the returned array
        this.brand = brand;

        return true;
    }

    public boolean setModel(String model) {
        // todo get models from Globals.db.getBrands() and verify that the model actually exists
        //      inside the returned array
        this.model = model;

        return true;
    }

    public boolean setPart_number(String part_number) {
        if ( ! (part_number.length() > 0 && part_number.length() < 20) ) {
            return false;
        }

        if ( ! part_number.matches("[A-Za-z0-9]+") ) {
            return false;
        }

        // TODO call partNumberExists(part_number) to check if the part number is unique or not

        return true;
    }

    public boolean setWidth(String width) {
        try {
            int w = Integer.parseInt(width);
            if (w > 0 && ((width.length() == 2) || (width.length() == 3))) {
                this.width = width;
                return true;
            } else {
                return false;
            }
        } catch(NumberFormatException e){
                return false;
        }
    }

    public boolean setAspect_ratio( String aspect_ratio ) {
        try {
            int w = Integer.parseInt(aspect_ratio);

            if (w > 0 && aspect_ratio.length() == 2) {
                this.aspect_ratio = aspect_ratio;
                return true;
            } else {
                return false;
            }

        } catch(NumberFormatException e){
            return false;
        }
    }

    public boolean setConstruction(String construction) {
        String[] constructionArray = new String[]{"R","ZR"};
        List<String> list = Arrays.asList(constructionArray);

        if(list.contains(construction)) {
            this.construction = construction;
            return true;
        }

        return false;

    }

    public boolean setWheel_diameter(String wheel_diameter) {
        double doubleDiam;

        try {
            doubleDiam = Double.parseDouble(wheel_diameter);
        } catch(NumberFormatException e) {
            return false;
        }

        if ( doubleDiam > 0 && wheel_diameter.length() == 2 ) {
            this.wheel_diameter = wheel_diameter;
            return true;
        }

        String[] parameters = wheel_diameter.split( Pattern.quote(".") );

        if (parameters.length == 2) {
            if ( doubleDiam > 0 && parameters[0].length() == 2 && parameters[1].length() == 1 ) {
                this.wheel_diameter = wheel_diameter;
                return true;
            }
        }

        return false;

    }

    public boolean setMax_load(String max_load) {
       try {
           int ml = Integer.parseInt(max_load);

           if(ml>0 && ((max_load.length()==3) || (max_load.length()==4)) ){
               this.max_load = max_load;
               return true;
           } else {
               return false;
           }
       } catch(NumberFormatException e) {
           return false;
       }
    }

    public boolean setMax_psi(String max_psi) {
        if ( max_psi.length() <= 1 ) {
            return false;
        }

        double doublePSI;

        try {
            doublePSI = Double.parseDouble(max_psi);
        } catch (NumberFormatException e) {
            return false;
        }

        if ( doublePSI > 0 && (max_psi.length() == 2 || max_psi.length() == 3)) {
            this.max_psi = max_psi;
            return true;
        }

        String[] parameters = max_psi.split( Pattern.quote(".") );

        if (parameters.length == 2) {
            if ( doublePSI > 0 && parameters[0].length() == 2 && parameters[1].length() == 1 ) {
                this.max_psi = max_psi;
                return true;
            }

            if ( doublePSI > 0 && parameters[0].length() == 3 && parameters[1].length() == 1 ) {
                this.max_psi = max_psi;
                return true;
            }
        }

        return false;
    }

    public boolean setPly(String ply) {
        try {
            int p = Integer.parseInt(ply);
            if (p > 0 && p <= 12) {
                this.ply = ply;
                return true;
            } else {
                return false;
            }
        } catch(NumberFormatException e) {
                return false;
        }
    }

    public boolean setLoad_rating(String load_rating) {
        String[] loadRating = new String[]{"B","C","D","E","F"};
        List<String> list = Arrays.asList(loadRating);
        if(list.contains(load_rating)) {
            this.load_rating = load_rating;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setSpeed_rating(String speed_rating) {
        String[] speedRating = new String[]{"Z","P","S","R","Q","Y","V","W","T","H"};
        List<String> list = Arrays.asList(speedRating);
        if(list.contains(speed_rating)) {
            this.speed_rating = speed_rating;
            return true;
        }
        else{
            return false;
        }

    }

    public boolean setWeight(String weight) {
        this.weight = weight;

        double doubleWeight;

        try {
            doubleWeight = Double.parseDouble(weight);
        } catch(NumberFormatException e) {
            return false;
        }

        if ( doubleWeight > 0 && weight.length() <= 3 ) {
            this.weight = weight;
            return true;
        }

        String[] parameters = weight.split( Pattern.quote(".") );

        if (parameters.length == 2) {
            if ( doubleWeight > 0 && (parameters[0].length() == 2 || parameters[0].length() == 3) && parameters[1].length() == 1 ) {
                this.weight = weight;
                return true;
            }
        }

        return false;
    }

    public boolean setCost(String cost) {
        try{
            double c = Double.parseDouble(cost);

            if(c>0){
                this.cost = cost;
                return true;
            } else {
                return false;
            }
        }
        catch(NumberFormatException e) {
            return false;
        }

    }

    public boolean setSales_price(String sales_price) {
        try{
           double ssp = Double.parseDouble(sales_price);
              if(ssp>0){
                  this.sales_price = sales_price;
                  return true;
            } else {
                  return false;
              }
        } catch(NumberFormatException e){
            return false;
        }
    }

    public boolean setQty_per_unit(String cost_per_unit) {
        try {
            int cpu = Integer.parseInt(cost_per_unit);
            if(cpu>=1){
                this.cost_per_unit = cost_per_unit;
                return true;
            }
            else {
                return false;
            }
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    public boolean setImage(String image) {
        if ( image.length() < 5 ) {
            return false;
        }

        this.image = image;
        return true;
    }

    public void setHas_warranty(boolean has_warranty) {
        this.has_warranty = has_warranty;
    }

    public void setIs_dot_approved(boolean is_dot_approved) {
        this.is_dot_approved = is_dot_approved;
    }

    public void setIs_discontinued(boolean is_discontinued) {
        this.is_discontinued = is_discontinued;
    }
}
