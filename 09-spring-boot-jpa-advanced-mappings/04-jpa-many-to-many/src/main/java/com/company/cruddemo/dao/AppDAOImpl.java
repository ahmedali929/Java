package com.company.cruddemo.dao;

import com.company.cruddemo.entity.Course;
import com.company.cruddemo.entity.Instructor;
import com.company.cruddemo.entity.InstructorDetail;
import com.company.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        //retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        List<Course> courses = tempInstructor.getCourses();

        // break associations of all courses for instructor
        for (Course tempCourse: courses) {
            tempCourse.setInstructor(null);
        }

        //remove the instructor
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {

        // retrieve instructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        // remove the associated object reference; break bi-directional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        // delete the instructor detail. this will also delete associated instructor due to the cascade effect
        entityManager.remove(tempInstructorDetail);

    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        //create query
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        //execute query
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        //create query
        TypedQuery<Instructor> query = entityManager.createQuery("SELECT i FROM Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail WHERE i.id = :data", Instructor.class);
        query.setParameter("data", theId);

        //execute query
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    public void deleteCourseById(int theId) {
        //retrieve the course
        Course tempCourse = entityManager.find(Course.class, theId);

        //delete the course
        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c JOIN FETCH c.reviews WHERE c.id = :data", Course.class);
        query.setParameter("data", theId);

        // execute query
        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c JOIN FETCH c.students WHERE c.id = :data", Course.class);
        query.setParameter("data", theId);

        // execute query
        Course course = query.getSingleResult();

        return course;

    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {

        // create query
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s JOIN FETCH s.courses WHERE s.id = :data", Student.class);
        query.setParameter("data", theId);

        // execute query
        Student student = query.getSingleResult();

        return student;
    }

    @Override
    @Transactional
    public void update(Student tempStudent) {
        entityManager.merge(tempStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {

        // retrieve the student
        Student tempStudent = entityManager.find(Student.class, theId);

        if (tempStudent != null) {

            // get the courses
            List<Course> courses = tempStudent.getCourses();

            // break association of all courses for the student
            for (Course tempCourse : courses) {
                tempCourse.getStudents().remove(tempStudent);
            }

            // now delete the student
            entityManager.remove(tempStudent);
        }
    }
}
