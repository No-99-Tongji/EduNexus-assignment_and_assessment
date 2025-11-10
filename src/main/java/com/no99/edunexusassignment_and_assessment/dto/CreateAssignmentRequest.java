package com.no99.edunexusassignment_and_assessment.dto;

import com.no99.edunexusassignment_and_assessment.entity.Assignment;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * 创建作业请求DTO
 */
@Schema(description = "创建作业请求")
public class CreateAssignmentRequest {

    @Schema(description = "作业标题", example = "Java编程作业1", required = true)
    @NotBlank(message = "作业标题不能为空")
    @Size(max = 200, message = "作业标题长度不能超过200个字符")
    private String title;

    @Schema(description = "作业描述", example = "完成Java基础语法练习")
    @Size(max = 2000, message = "作业描述长度不能超过2000个字符")
    private String description;

    @Schema(description = "作业类型", required = true)
    @NotNull(message = "作业类型不能为空")
    private Assignment.AssignmentType assignmentType;

    @Schema(description = "课程ID", example = "1", required = true)
    @NotNull(message = "课程ID不能为空")
    @Min(value = 1, message = "课程ID必须大于0")
    private Integer courseId;

    @Schema(description = "模块ID", example = "1")
    @Min(value = 1, message = "模块ID必须大于0")
    private Integer moduleId;

    @Schema(description = "最高分数", example = "100")
    @Min(value = 0, message = "最高分数不能为负数")
    private Integer maxPoints;

    @Schema(description = "截止日期", example = "2024-12-31 23:59:59")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dueDate;

    @Schema(description = "开放日期", example = "2024-01-01 00:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime availableDate;

    @Schema(description = "最大尝试次数", example = "3")
    @Min(value = 1, message = "最大尝试次数必须大于0")
    private Integer maxAttempts;

    @Schema(description = "是否已发布", example = "false")
    private Boolean isPublished = false;

    // Constructors
    public CreateAssignmentRequest() {}

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Assignment.AssignmentType getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(Assignment.AssignmentType assignmentType) {
        this.assignmentType = assignmentType;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(Integer maxPoints) {
        this.maxPoints = maxPoints;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDateTime availableDate) {
        this.availableDate = availableDate;
    }

    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(Integer maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public Boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Boolean isPublished) {
        this.isPublished = isPublished;
    }

    @Override
    public String toString() {
        return "CreateAssignmentRequest{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assignmentType=" + assignmentType +
                ", courseId=" + courseId +
                ", moduleId=" + moduleId +
                ", maxPoints=" + maxPoints +
                ", dueDate=" + dueDate +
                ", availableDate=" + availableDate +
                ", maxAttempts=" + maxAttempts +
                ", isPublished=" + isPublished +
                '}';
    }
}
