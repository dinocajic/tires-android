package edu.gsu.student.csc4360;

public class Tire {

    private String brand, model, part_number, width, construction, wheel_diameter, max_load, max_psi,
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

    // todo change all setters from void to boolean
    //      - return true if successful, and false if not successful
    //      ----------------------------------------------------------------------------------------

    public void setBrand(String brand) {
        // todo get brands from Globals.db.getBrands() and verify that the brand actually exists
        //      inside the returned array
        this.brand = brand;
    }

    public void setModel(String model) {
        // todo get models from Globals.db.getBrands() and verify that the model actually exists
        //      inside the returned array
        this.model = model;
    }

    public void setPart_number(String part_number) {
        // todo make sure that part number is not smaller than 1 character and no larger than 20 characters
        this.part_number = part_number;
    }

    public void setWidth(String width) {
        // todo make sure that width has no less than 2 characters and no more than 3 character and
        //      make sure that the input is numeric and greater than 0.
        this.width = width;
    }

    public void setConstruction(String construction) {
        // todo look up different types of tire internal constructions. Make sure it's one of those.
        //      for exapmle, internal construction can be R, ZR, etc.
        this.construction = construction;
    }

    public void setWheel_diameter(String wheel_diameter) {
        // todo make sure that width 2 characters if no period, and 4 characters total if it has a period, and
        //      make sure that the input is numeric (integer or decimal) and greater than 0.. i.e. 22 or 22.5
        this.wheel_diameter = wheel_diameter;
    }

    public void setMax_load(String max_load) {
        // todo make sure max load is numeric and either 3 or 4 characters and greater than 0.
        this.max_load = max_load;
    }

    public void setMax_psi(String max_psi) {
        // todo make sure max psi is numeric and either 2 or 3 characters if an integer or 4 or 5 characters
        //      if a decimal and greater than 0.. i.e. 56 or 104.5
        this.max_psi = max_psi;
    }

    public void setPly(String ply) {
        // todo make sure that ply is numeric and either 1 or 2 characters and greater than 0.. i.e. 8 or 12
        this.ply = ply;
    }

    public void setLoad_rating(String load_rating) {
        // todo make sure that load rating is a single character. i.e. E
        this.load_rating = load_rating;
    }

    public void setSpeed_rating(String speed_rating) {
        // todo make sure that speed rating is a single character i.e. Y
        //      https://www.ntb.com/info/a20022/what-is-a-tire-speed-rating
        this.speed_rating = speed_rating;
    }

    public void setWeight(String weight) {
        // todo make sure that the weight is numeric and no larger than 3 digits in integer or 5 characters
        //      if a decimal and greater than 0.. i.e. 23 or 125.5
        this.weight = weight;
    }

    public void setCost(String cost) {
        // todo check to make sure that the cost is either an integer or decimal and greater than 0.
        this.cost = cost;
    }

    public void setSales_price(String sales_price) {
        // todo check to mae sure that the sale price is either an integer or decimal and greater than 0.
        this.sales_price = sales_price;
    }

    public void setQty_per_unit(String cost_per_unit) {
        // todo check to make sure that the value is numeric and is greater than or equal to 1.
        this.cost_per_unit = cost_per_unit;
    }

    public void setImage(String image) {
        // todo make sure it's a string. More details coming later
        this.image = image;
    }

    public void setHas_warranty(boolean has_warranty) {
        // todo make sure the value is either true or false.
        this.has_warranty = has_warranty;
    }

    public void setIs_dot_approved(boolean is_dot_approved) {
        // todo make sure the value is either true or false.
        this.is_dot_approved = is_dot_approved;
    }

    public void setIs_discontinued(boolean is_discontinued) {
        // todo make sure the value is either true or false.
        this.is_discontinued = is_discontinued;
    }
}