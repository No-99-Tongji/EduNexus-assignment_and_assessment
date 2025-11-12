package com.no99.edunexusassignment_and_assessment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.no99.edunexusassignment_and_assessment.mapper")
public class EduNexusAssignmentAndAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduNexusAssignmentAndAssessmentApplication.class, args);
    }

}
