import java.util.List;

class StudentImpl implements Student {
    private final String name;
    private final List<Course> courses;

    public StudentImpl(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name='" + name + '\'' +
                ", courses= " + courses;
    }

    @Override
    public List<Course> getAllCourses() {
        return courses;
    }
}
