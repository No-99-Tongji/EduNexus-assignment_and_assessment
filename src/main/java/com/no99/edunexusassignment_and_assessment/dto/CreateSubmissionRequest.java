package com.no99.edunexusassignment_and_assessment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * 创建提交请求DTO
 */
@Schema(description = "创建作业提交请求")
public class CreateSubmissionRequest {

    @Schema(description = "作业ID", required = true, example = "1")
    @NotNull(message = "作业ID不能为空")
    private Integer assignmentId;

    @Schema(description = "用户ID", required = true, example = "1")
    @NotNull(message = "用户ID不能为空")
    private Integer userId;

    @Schema(description = "提交内容", required = true, example = "这是我的作业答案...")
    @NotBlank(message = "提交内容不能为空")
    private String content;

    @Schema(description = "尝试次数", example = "1")
    private Integer attemptNumber;

    // Constructors
    public CreateSubmissionRequest() {}

    public CreateSubmissionRequest(Integer assignmentId, Integer userId, String content) {
        this.assignmentId = assignmentId;
        this.userId = userId;
        this.content = content;
        this.attemptNumber = 1;
    }

    // Getters and Setters
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

    public Integer getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(Integer attemptNumber) {
        this.attemptNumber = attemptNumber;
    }
}
