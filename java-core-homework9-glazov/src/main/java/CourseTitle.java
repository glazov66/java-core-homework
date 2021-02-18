public class CourseTitle implements Course {
    private final String courseTitle;

    public CourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    @Override
    public String getCourseTitle() {
        return courseTitle;
    }

    @Override
    public String toString() {
        return "courseTitle:'" + courseTitle + '\'';
    }

}
