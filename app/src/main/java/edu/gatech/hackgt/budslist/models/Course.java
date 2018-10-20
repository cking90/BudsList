package edu.gatech.hackgt.budslist.models;

public class Course {
    private Department department;
    private String courseNumber;

    public Course(Department department, String courseNumber) {
        this.department = department;
        this.courseNumber = courseNumber;
    }
    public Department getDepartment() {
        return this.department;
    }
    public String getCourseNumber() {
        return this.courseNumber;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public boolean equals(Object other) {
        if (other == this) {return true; }
        if (!(other instanceof Course)) { return false; }
        Course that = (Course) other;
        return this.department.equals(that.department) && this.courseNumber.equals(that.courseNumber);
    }

}
