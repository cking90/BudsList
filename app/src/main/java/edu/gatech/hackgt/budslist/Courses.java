package edu.gatech.hackgt.budslist;

public class Courses {
    private Departments department;
    private int courseNumber;
    private String name;

    public Courses(Departments department, int courseNumber, String name) {
        this.department = department;
        this.courseNumber = courseNumber;
        this.name = name;
    }
    public Departments getDepartment() {
        return this.department;
    }
    public int getCourseNumber() {
        return this.courseNumber;
    }
    public String getName() {
        return this.name;
    }
    public void setDepartment(Departments department) {
        this.department = department;
    }
    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }
    public void setName(String name) {
        this.name = name;
    }

}
