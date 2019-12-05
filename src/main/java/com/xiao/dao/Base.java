package com.xiao.dao;

import com.xiao.pojo.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface Base {
    Student findById(int id);
    int addStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(int id);

}
