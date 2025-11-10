package com.no99.edunexusassignment_and_assessment.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 提交实体类
 */
@Schema(description = "作业提交实体")
public class Submission {

    @Schema(description = "提交ID", example = "1")
    private Integer id;

    @Schema(description = "作业ID", example = "1")
    private Integer assignmentId;

    @Schema(description = "用户ID", example = "1")
    private Integer userId;

    @Schema(description = "提交内容")
    private String content;

    @Schema(description = "提交时间")
    private LocalDateTime submissionDate;

    @Schema(description = "尝试次数", example = "1")
    private Integer attemptNumber;

    @Schema(description = "提交状态")
    private SubmissionStatus status;

    @Schema(description = "评分", example = "85.5")
    private BigDecimal grade;

    @Schema(description = "反馈意见")
    private String feedback;

    @Schema(description = "评分者ID", example = "2")
    private Integer gradedBy;

    @Schema(description = "评分时间")
    private LocalDateTime gradedAt;

    /**
     * 提交状态枚举
     */
    public enum SubmissionStatus {
        @Schema(description = "已提交")
        SUBMITTED,
        @Schema(description = "已评分")
        GRADED,
        @Schema(description = "需要重新提交")
        NEEDS_REVISION,
        @Schema(description = "草稿")
        DRAFT
    }

    // Constructors
    public Submission() {}

    public Submission(Integer id, Integer assignmentId, Integer userId, String content) {
        this.id = id;
        this.assignmentId = assignmentId;
        this.userId = userId;
        this.content = content;
        this.submissionDate = LocalDateTime.now();
        this.attemptNumber = 1;
        this.status = SubmissionStatus.SUBMITTED;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Integer getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(Integer attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public SubmissionStatus getStatus() {
        return status;
    }

    public void setStatus(SubmissionStatus status) {
        this.status = status;
    }

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

    public Integer getGradedBy() {
        return gradedBy;
    }

    public void setGradedBy(Integer gradedBy) {
        this.gradedBy = gradedBy;
    }

    public LocalDateTime getGradedAt() {
        return gradedAt;
    }

    public void setGradedAt(LocalDateTime gradedAt) {
        this.gradedAt = gradedAt;
    }
}
