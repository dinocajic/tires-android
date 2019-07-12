package edu.gsu.student.csc4360;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Tire {

    private int id, productsId, imageId, latestCostId, latestPriceId;

    private Brands brand;
    private Models model;

    private String  part_number, width, aspect_ratio, construction, wheel_diameter, max_load, max_psi,
            ply, load_rating, speed_rating, weight, cost, sales_price, qty_per_unit, image;

    private boolean has_warranty, is_dot_approved, is_discontinued;

    public int getId() {
        return id;
    }

    public int getProductsId() {
        return productsId;
    }

    public int getImageId() {
        return imageId;
    }

    public int getLatestCostId() {
        return latestCostId;
    }

    public int getLatestSalesPriceId() { return latestPriceId; }

    public Brands getBrand() {
        return brand;
    }

    public Models getModel() {
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

    public String getQty_per_unit() {
        return qty_per_unit;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setProductsId(int productsId) {
        this.productsId = productsId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setLatestCostId(int latestCostId) {
        this.latestCostId = latestCostId;
    }

    public void setLatestPriceId(int latestPriceId) { this.latestPriceId = latestPriceId; }

    public boolean setBrand(Brands brand) {
        this.brand = brand;
        return true;
    }

    public boolean setModel(Models model) {
        this.model = model;
        return true;
    }

    /**
     * Checks to see that the number is between 0 and 20 characters, is alphanumeric, and sees if
     * it's unique inside the tires table. If valid, sets it.
     *
     * @param part_number - Tire part number
     * @return boolean
     */
    public boolean setPart_number(String part_number) {
        if ( ! (part_number.length() > 0 && part_number.length() < 20) ) {
            return false;
        }

        if ( ! part_number.matches("[A-Za-z0-9]+") ) {
            return false;
        }

        this.part_number = part_number;

        return true;
    }

    /**
     * Checks to see if the width submitted is a number and either 2 or 3 digits in length.
     * If valid, sets it.
     *
     * @param width - Tire width
     * @return boolean
     */
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

    /**
     * Checks to see if the aspect ratio is exactly 2 digits in length. If valid, sets it.
     *
     * @param aspect_ratio - Tire Aspect Ratio
     * @return boolean
     */
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

    /**
     * Checks to see that the internal construction is either R or ZR. If valid, sets it.
     *
     * @param construction - internal construction
     * @return boolean
     */
    public boolean setConstruction(String construction) {
        String[] constructionArray = new String[]{"R","ZR"};
        List<String> list = Arrays.asList(constructionArray);

        if(list.contains(construction)) {
            this.construction = construction;
            return true;
        }

        return false;

    }

    /**
     * Checks to see that the wheel diameter is numeric. If so, it then makes sure that the number
     * of characters inside the wheel_diameter is either 2 or 4: i.e. 20 or 22.5. If valid, sets it.
     *
     * @param wheel_diameter - Wheel diameter
     * @return boolean
     */
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

    /**
     * Checks to make sure that the max load is either 3 or 4 characters in length and numeric.
     * If valid, sets it.
     *
     * @param max_load - Max Load
     * @return boolean
     */
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

    /**
     * Checks to make sure that the max psi is numeric, i smore than 1 digit in length, is either
     * 2 or 3 digits in length if no period is present, and either 4 or 5 digits in length if a
     * period is present. If valid, sets it.
     *
     * @param max_psi - Tire maximum PSI
     * @return boolean
     */
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
            if ( doublePSI > 0 && (parameters[0].length() == 2 || parameters[0].length() == 3) && parameters[1].length() == 1 ) {
                this.max_psi = max_psi;
                return true;
            }
        }

        return false;
    }

    /**
     * Checks to see if the ply is a number between 0 and 12. If valid, sets it.
     *
     * @param ply - Tire Ply amount
     * @return boolean
     */
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

    /**
     * Checks to make sure that the load rating matches one in the array. If valid, sets it.
     *
     * @param load_rating - Tire Load Rating
     * @return boolean
     */
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

    /**
     * Checks to make sure that the speed rating matches one in the array. If valid, sets it.
     *
     * @param speed_rating - Tire speed rating
     * @return boolean
     */
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

    /**
     * Checks to make sure that the weight is numeric, and if it does not have a period between 1 and
     * 3 digits in length. If it contains a period, then it checks to make sure that the value is
     * between 4 and 5 characters in length. If valid, sets it.
     *
     * @param weight - Tire weight
     * @return boolean
     */
    public boolean setWeight(String weight) {
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

    /**
     * Makes sure that the cost is numeric and greater than or equal to zero. If valid, sets it.
     *
     * @param cost - Cost of the tire
     * @return boolean
     */
    public boolean setCost(String cost) {
        try{
            double c = Double.parseDouble(cost);

            if(c>=0){
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

    /**
     * Checks to make sure that the sales price is greater than zero and is numeric. If valid, sets it.
     *
     * @param sales_price - Selling price of the tire
     * @return boolean
     */
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

    /**
     * Checks to see if the quantity per unit is numeric and is greater than or equal to 1. If valid, sets it.
     *
     * @param qty_per_unit - Quantity per unit
     * @return boolean
     */
    public boolean setQty_per_unit(String qty_per_unit) {
        try {
            int cpu = Integer.parseInt(qty_per_unit);
            if(cpu>=1){
                this.qty_per_unit = qty_per_unit;
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

    /**
     * Checks to make sure that the length of the string is greater than 4. If valid, sets it.
     *
     * @param image - Image URI
     * @return boolean
     */
    public boolean setImage(String image) {
        if ( image.length() < 5 ) {
            return false;
        }

        this.image = image;
        return true;
    }

    /**
     * Sets has_warranty.
     *
     * @param has_warranty - Has Warranty
     */
    public void setHas_warranty(boolean has_warranty) {
        this.has_warranty = has_warranty;
    }

    /**
     * Sets is_dot_approved
     *
     * @param is_dot_approved - Is DOT approved
     */
    public void setIs_dot_approved(boolean is_dot_approved) {
        this.is_dot_approved = is_dot_approved;
    }

    /**
     * Sets is_discontinued;
     *
     * @param is_discontinued - Is discontinued?
     */
    public void setIs_discontinued(boolean is_discontinued) {
        this.is_discontinued = is_discontinued;
    }
}
