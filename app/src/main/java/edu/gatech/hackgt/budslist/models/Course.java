package edu.gatech.hackgt.budslist.models;

public class Course {
    private Department department;
    private int courseNumber;

    public Course(Department department, int courseNumber) {
        this.department = department;
        this.courseNumber = courseNumber;
    }
    public Department getDepartment() {
        return this.department;
    }
    public int getCourseNumber() {
        return this.courseNumber;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public boolean equals(Object other) {
        if (other == this) {return true; }
        if (!(other instanceof Course)) { return false; }
        Course that = (Course) other;
        return this.department.equals(that.department) && this.courseNumber == that.courseNumber;
    }

}
