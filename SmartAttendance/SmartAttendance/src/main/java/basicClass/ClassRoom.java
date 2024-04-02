package basicClass;

//x
public class ClassRoom {
    int id;
    Course[] courses;
    String place;
//    camera

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

}
