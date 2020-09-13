package com.me.array;

import java.util.ArrayList;
import java.util.List;

public class StudentsCourses {
    String studentId;
    String courseId;

    public StudentsCourses(String studentId, String courseId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public static void main(String[] args) {

        List<StudentsCourses> lookupTable = new ArrayList<>();
        lookupTable.add(new StudentsCourses("1","JSB102"));
        lookupTable.add(new StudentsCourses("2","JSB102"));
        lookupTable.add(new StudentsCourses("1","ANG101"));

        for (StudentsCourses obj : lookupTable)
            if (obj.studentId.equals("1"))
              System.out.println(obj.courseId);

        for (StudentsCourses obj : lookupTable)
            if (obj.courseId.equals("JSB102"))
                System.out.println(obj.studentId);


    }
}


