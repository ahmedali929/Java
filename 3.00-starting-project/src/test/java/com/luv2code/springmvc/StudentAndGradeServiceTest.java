package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradeServiceTest {

    @Test
    @DisplayName("Basic test")
    public void createStudentService() {

        studentService.createStudent("Chad", "Darby", "chad.darby@luv2code.com");
        CollegeStudent student = studentDao.findByEmailAddress("chad.darby@luv2code.com");
        assertEquals("chad.darby@luv2code.com", student.getEmailAddress(), "find by email");

    }

}
