package com.no99.edunexusassignment_and_assessment.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * 作业实体类
 */
@Schema(description = "作业信息")
public class Assignment {

    public enum AssignmentType {
        HOMEWORK("homework", "作业"),
        QUIZ("quiz", "测验"),
        EXAM("exam", "考试"),
        PROJECT("project", "项目");

        private final String code;
        private final String description;

        AssignmentType(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

    @Schema(description = "作业ID", example = "1")
    private Integer id;

    @Schema(description = "作业标题", example = "Java编程作业1")
    @NotNull(message = "作业标题不能为空")
    @Size(max = 200, message = "作业标题长度不能超过200个字符")
    private String title;

    @Schema(description = "作业描述", example = "完成Java基础语法练习")
    @Size(max = 2000, message = "作业描述长度不能超过2000个字符")
    private String description;

    @Schema(description = "作业类型")
    @NotNull(message = "作业类型不能为空")
    private AssignmentType assignmentType;

    @Schema(description = "课程ID", example = "1")
    @NotNull(message = "课程ID不能为空")
    private Integer courseId;

    @Schema(description = "模块ID", example = "1")
    private Integer moduleId;

    @Schema(description = "最高分数", example = "100")
    private Integer maxPoints;

    @Schema(description = "截止日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dueDate;

    @Schema(description = "开放日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime availableDate;

    @Schema(description = "最大尝试次数", example = "3")
    private Integer maxAttempts;

    @Schema(description = "是否已发布", example = "true")
    private Boolean isPublished;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    // Constructors
    public Assignment() {}

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public AssignmentType getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(AssignmentType assignmentType) {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assignmentType=" + assignmentType +
                ", courseId=" + courseId +
                ", moduleId=" + moduleId +
                ", maxPoints=" + maxPoints +
                ", dueDate=" + dueDate +
                ", availableDate=" + availableDate +
                ", maxAttempts=" + maxAttempts +
                ", isPublished=" + isPublished +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
