package edu.gsu.student.csc4360;

public class Categories {

    private String category, details;
    private int    id, enabled;

    public String getCategory() {
        return category;
    }

    public String getDetails() {
        return details;
    }

    public int getId() {
        return id;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
