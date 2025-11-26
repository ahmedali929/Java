package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.service.StudentAndGradeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradeServiceTest {

    @Autowired
    private StudentAndGradeService studentService;

    @Test
    @DisplayName("Basic test")
    public void createStudentService() {

        studentService.createStudent("Chad", "Darby", "chad.darby@luv2code.com");
        CollegeStudent student = studentDao.findByEmailAddress("chad.darby@luv2code.com");
        assertEquals("chad.darby@luv2code.com", student.getEmailAddress(), "find by email");

    }

}
