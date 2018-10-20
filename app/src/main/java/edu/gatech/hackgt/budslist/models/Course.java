package edu.gatech.hackgt.budslist.models;

public class Course {
    private Department department;
    private int courseNumber;
    private String name;

    public Course(Department department, int courseNumber, String name) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.name = name;
    }
    public Department getDepartment() {
        return this.department;
    }
    public int getCourseNumber() {
        return this.courseNumber;
    }
    public String getName() {
        return this.name;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object other) {
        if (other == this) {return true; }
        if (!(other instanceof Course)) { return false; }
        Course that = (Course) other;
        return this.department.equals(that.department) && this.courseNumber == that.courseNumber;
    }

}
