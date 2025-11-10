package com.no99.edunexusassignment_and_assessment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

/**
 * 评分提交请求DTO
 */
@Schema(description = "评分作业提交请求")
public class GradeSubmissionRequest {

    @Schema(description = "评分", required = true, example = "85.5")
    @NotNull(message = "评分不能为空")
    @DecimalMin(value = "0.0", message = "评分不能小于0")
    @DecimalMax(value = "100.0", message = "评分不能大于100")
    private BigDecimal grade;

    @Schema(description = "反馈意见", example = "作业完成得很好，但还有改进空间...")
    private String feedback;

    @Schema(description = "评分者ID", required = true, example = "2")
    @NotNull(message = "评分者ID不能为空")
    private Integer graderId;

    // Constructors
    public GradeSubmissionRequest() {}

    public GradeSubmissionRequest(BigDecimal grade, String feedback, Integer graderId) {
        this.grade = grade;
        this.feedback = feedback;
        this.graderId = graderId;
    }

    // Getters and Setters
    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getGraderId() {
        return graderId;
    }

    public void setGraderId(Integer graderId) {
        this.graderId = graderId;
    }
}
