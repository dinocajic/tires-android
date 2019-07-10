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

    The following methods I have not touched and some hurt my heard: setMax_PSI,setWheel_diameter,setImage,setModel,setBrand
       ----------------------------------------------------------------------------------------
    //The following methods I did not touch : setMax_PSI,setWheel_diameter,setImage,setModel,setBrand
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

    public boolean setPart_number(String part_number) {
        // todo validate code.
        try {
            int pn = Integer.parseInt(part_number);
            if ((pn.length()>0) && (pn.length()<=20)) {
                this.part_number = part_number;
                return true;
            } else {
                return false;
            }
        catch(numberFormatException e){
                return false;
            }
        }
    }

    public boolean setWidth(String width) {
        // todo make sure that width has no less than 2 characters and no more than 3 character and
        //      make sure that the input is numeric and greater than 0.

        try {
            int w = Integer.parseInt(width);
            if (p > 0 && ((width.length()==2)||(width.length()==3))) {
                this.width = width;
                return true;
            } else {
                return false;
            }
        catch(numberFormatException e){
                return false;
            }
        }
    }

    public boolean setConstruction(String construction) {
        // todo I couldnt find a list of all the interal tire constructions  for this one

        String[] constructionArray = new String[]{"R","ZR"};
        List<String> list = Arrays.asList(constructionArray);
        if(list.contains(construction)) {
            this.construction = construction;
            return true;
        }
        else{
            return false;
        }

    }

    public void setWheel_diameter(String wheel_diameter) {
        // todo make sure that width 2 characters if no period, and 4 characters total if it has a period, and
        //      make sure that the input is numeric (integer or decimal) and greater than 0.. i.e. 22 or 22.5
        this.wheel_diameter = wheel_diameter;

    }

    public boolean setMax_load(String max_load) {
        // todo make sure max load is numeric and either 3 or 4 characters and greater than 0.
       try {
           int ml = Integer.parseInt(max_load)
                   if(ml>0 && ((max_load.length()==3)|(max_load.length()==4)) ){
                       this.max_load = max_load;
                       return true;
                   }
       }
       catch(NumberFormatException e){
           return false;
       }
    }

    public void setMax_psi(String max_psi) {
        // todo make sure max psi is numeric and either 2 or 3 characters if an integer or 4 or 5 characters
        //      if a decimal and greater than 0.. i.e. 56 or 104.5
        this.max_psi = max_psi;
    }

    public boolean setPly(String ply) {
        // todo make sure that ply is numeric and either 1 or 2 characters and greater than 0.. i.e. 8 or 12
        try {
            int p = Integer.parseInt(ply);
            if (p > 0 && p <= 12) {
                this.ply = ply;
                return true;
            } else {
                return false;
            }
        catch(numberFormatException e){
                return false;
            }
        }
    }

    public boolean setLoad_rating(String load_rating) {
        // todo validate this validation
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
        // todo check validation.
        /
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

    public void setWeight(String weight) {
        // todo make sure that the weight is numeric and no larger than 3 digits in integer or 5 characters
        //      if a decimal and greater than 0.. i.e. 23 or 125.5
        this.weight = weight;
    }

    public boolean setCost(String cost) {
        //toDo - Confirm that validation is correct(determine decimal/int && greter than 0)        try{
        try{
        double c = Double.parseDouble(cost);
                if(c>0){
                    this.cost = cost;
                    return true;
                }
        }
        catch(NumberFormatException e) {
            return false;
        }

    }

    public boolean setSales_price(String sales_price) {

      //toDo - Confirm that validation is correct(determine decimal/int && greter than 0)
        try{
           double ssp = Double.parseDouble(sales_price);
              if(ssp>0){
                  this.sales_price = sales_price;
                  return true;
            }
        }

        catch(NumberFormatException e){
            return false;
        }
    }

    public boolean setQty_per_unit(String cost_per_unit) {
        //toDo - Confirm that validation is correct(determine if int && greter than 1)
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
        // todo make sure it's a string. More details coming later
            this.image = image;
            return true;

    public boolean setHas_warranty(boolean has_warranty) {
        // todo make sure the value is either true or false.
        this.has_warranty = has_warranty;
        return true;
    }

    public boolean setIs_dot_approved(boolean is_dot_approved) {
        // todo make sure the value is either true or false.
        this.is_dot_approved = is_dot_approved;
        return true;
    }

    public boolean setIs_discontinued(boolean is_discontinued) {
        // todo make sure the value is either true or false.
        this.is_discontinued = is_discontinued;
        return true;


    }
}
