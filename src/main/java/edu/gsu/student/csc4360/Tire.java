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
        this.part_number = part_number;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public void setWheel_diameter(String wheel_diameter) {
        this.wheel_diameter = wheel_diameter;
    }

    public void setMax_load(String max_load) {
        this.max_load = max_load;
    }

    public void setMax_psi(String max_psi) {
        this.max_psi = max_psi;
    }

    public void setPly(String ply) {
        this.ply = ply;
    }

    public void setLoad_rating(String load_rating) {
        this.load_rating = load_rating;
    }

    public void setSpeed_rating(String speed_rating) {
        this.speed_rating = speed_rating;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setSales_price(String sales_price) {
        this.sales_price = sales_price;
    }

    public void setQty_per_unit(String cost_per_unit) {
        this.cost_per_unit = cost_per_unit;
    }

    public void setImage(String image) {
        this.image = image;
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
