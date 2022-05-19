package com.example.swe311_final_assignment_swe1904867;

public class PlanItemModelClass {

    private int planId;
    private String title;
    private String note;
    private int image;

    public PlanItemModelClass(int planId,String title, String note, int image) {
        this.planId=planId;
        this.title = title;
        this.note = note;
        this.image = image;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
