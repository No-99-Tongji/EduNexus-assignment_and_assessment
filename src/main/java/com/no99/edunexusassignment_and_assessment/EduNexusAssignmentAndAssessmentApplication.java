package com.no99.edunexusassignment_and_assessment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        com.alibaba.cloud.nacos.discovery.NacosDiscoveryAutoConfiguration.class,
        com.alibaba.cloud.nacos.registry.NacosServiceRegistryAutoConfiguration.class,
        com.alibaba.cloud.nacos.NacosConfigAutoConfiguration.class,
        org.springframework.cloud.client.serviceregistry.ServiceRegistryAutoConfiguration.class
})
@MapperScan("com.no99.edunexusassignment_and_assessment.mapper")
// @EnableDiscoveryClient - Disabled when Nacos is not available
public class EduNexusAssignmentAndAssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduNexusAssignmentAndAssessmentApplication.class, args);
    }

}
