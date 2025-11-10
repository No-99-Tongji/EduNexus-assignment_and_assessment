package com.no99.edunexusassignment_and_assessment.controller;

import com.no99.edunexusassignment_and_assessment.dto.CreateAssignmentRequest;
import com.no99.edunexusassignment_and_assessment.entity.Assignment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 作业控制器
 */
@RestController
@RequestMapping("/api/assignments")
@Tag(name = "作业管理", description = "作业相关的API接口")
public class AssignmentController {

    @Operation(summary = "创建作业", description = "创建一个新的作业")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "作业创建成功"),
            @ApiResponse(responseCode = "400", description = "请求参数有误"),
            @ApiResponse(responseCode = "500", description = "服务器内部错误")
    })
    @PostMapping
    public ResponseEntity<com.no99.edunexusassignment_and_assessment.dto.ApiResponse<Assignment>> createAssignment(
            @Parameter(description = "创建作业的请求数据", required = true)
            @Valid @RequestBody CreateAssignmentRequest request) {
        try {
            // TODO: 实现创建作业逻辑
            Assignment assignment = new Assignment();
            assignment.setTitle(request.getTitle());
            assignment.setDescription(request.getDescription());
            assignment.setAssignmentType(request.getAssignmentType());
            assignment.setCourseId(request.getCourseId());
            assignment.setModuleId(request.getModuleId());
            assignment.setMaxPoints(request.getMaxPoints());
            assignment.setDueDate(request.getDueDate());
            assignment.setAvailableDate(request.getAvailableDate());
            assignment.setMaxAttempts(request.getMaxAttempts());
            assignment.setIsPublished(request.getIsPublished());

            return ResponseEntity.ok(com.no99.edunexusassignment_and_assessment.dto.ApiResponse.success("作业创建成功", assignment));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(com.no99.edunexusassignment_and_assessment.dto.ApiResponse.error(400, e.getMessage()));
        }
    }

    @Operation(summary = "获取作业详情", description = "根据作业ID获取作业的详细信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "获取成功"),
            @ApiResponse(responseCode = "404", description = "作业不存在")
    })
    @GetMapping("/{id}")
    public ResponseEntity<com.no99.edunexusassignment_and_assessment.dto.ApiResponse<Assignment>> getAssignment(
            @Parameter(description = "作业ID", required = true, example = "1")
            @PathVariable Integer id) {
        // TODO: 实现获取作业逻辑
        Assignment assignment = new Assignment();
        assignment.setId(id);
        assignment.setTitle("示例作业");

        return ResponseEntity.ok(com.no99.edunexusassignment_and_assessment.dto.ApiResponse.success(assignment));
    }

    @Operation(summary = "更新作业", description = "更新指定ID的作业信息")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "更新成功"),
            @ApiResponse(responseCode = "400", description = "请求参数有误"),
            @ApiResponse(responseCode = "404", description = "作业不存在")
    })
    @PutMapping("/{id}")
    public ResponseEntity<com.no99.edunexusassignment_and_assessment.dto.ApiResponse<Assignment>> updateAssignment(
            @Parameter(description = "作业ID", required = true, example = "1")
            @PathVariable Integer id,
            @Parameter(description = "更新作业的请求数据", required = true)
            @Valid @RequestBody CreateAssignmentRequest request) {
        try {
            // TODO: 实现更新作业逻辑
            Assignment assignment = new Assignment();
            assignment.setId(id);
            assignment.setTitle(request.getTitle());
            assignment.setDescription(request.getDescription());
            assignment.setAssignmentType(request.getAssignmentType());

            return ResponseEntity.ok(com.no99.edunexusassignment_and_assessment.dto.ApiResponse.success("作业更新成功", assignment));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(com.no99.edunexusassignment_and_assessment.dto.ApiResponse.error(400, e.getMessage()));
        }
    }

    @Operation(summary = "删除作业", description = "根据作业ID删除作业")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "删除成功"),
            @ApiResponse(responseCode = "404", description = "作业不存在")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<com.no99.edunexusassignment_and_assessment.dto.ApiResponse<Void>> deleteAssignment(
            @Parameter(description = "作业ID", required = true, example = "1")
            @PathVariable Integer id) {
        try {
            // TODO: 实现删除作业逻辑
            return ResponseEntity.ok(com.no99.edunexusassignment_and_assessment.dto.ApiResponse.success("作业删除成功"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(com.no99.edunexusassignment_and_assessment.dto.ApiResponse.error(400, e.getMessage()));
        }
    }

    @Operation(summary = "获取课程作业列表", description = "获取指定课程下的所有作业")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "获取成功")
    })
    @GetMapping("/course/{courseId}")
    public ResponseEntity<com.no99.edunexusassignment_and_assessment.dto.ApiResponse<List<Assignment>>> getAssignmentsByCourse(
            @Parameter(description = "课程ID", required = true, example = "1")
            @PathVariable Integer courseId) {
        // TODO: 实现获取课程作业列表逻辑
        List<Assignment> assignments = List.of();
        return ResponseEntity.ok(com.no99.edunexusassignment_and_assessment.dto.ApiResponse.success(assignments));
    }

    @Operation(summary = "搜索作业", description = "根据条件搜索作业")
    @GetMapping("/search")
    public ResponseEntity<com.no99.edunexusassignment_and_assessment.dto.ApiResponse<List<Assignment>>> searchAssignments(
            @Parameter(description = "课程ID") @RequestParam(required = false) Integer courseId,
            @Parameter(description = "模块ID") @RequestParam(required = false) Integer moduleId,
            @Parameter(description = "是否已发布") @RequestParam(required = false) Boolean isPublished,
            @Parameter(description = "作业类型") @RequestParam(required = false) Assignment.AssignmentType assignmentType,
            @Parameter(description = "每页数量", example = "10") @RequestParam(defaultValue = "10") Integer limit,
            @Parameter(description = "偏移量", example = "0") @RequestParam(defaultValue = "0") Integer offset) {

        // TODO: 实现搜索作业逻辑
        List<Assignment> assignments = List.of();
        return ResponseEntity.ok(com.no99.edunexusassignment_and_assessment.dto.ApiResponse.success(assignments));
    }

    @Operation(summary = "发布作业", description = "发布指定的作业")
    @PostMapping("/{id}/publish")
    public ResponseEntity<com.no99.edunexusassignment_and_assessment.dto.ApiResponse<Assignment>> publishAssignment(
            @Parameter(description = "作业ID", required = true, example = "1")
            @PathVariable Integer id) {
        try {
            // TODO: 实现发布作业逻辑
            Assignment assignment = new Assignment();
            assignment.setId(id);
            assignment.setIsPublished(true);

            return ResponseEntity.ok(com.no99.edunexusassignment_and_assessment.dto.ApiResponse.success("作业发布成功", assignment));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(com.no99.edunexusassignment_and_assessment.dto.ApiResponse.error(400, e.getMessage()));
        }
    }

    @Operation(summary = "取消发布作业", description = "取消发布指定的作业")
    @PostMapping("/{id}/unpublish")
    public ResponseEntity<com.no99.edunexusassignment_and_assessment.dto.ApiResponse<Assignment>> unpublishAssignment(
            @Parameter(description = "作业ID", required = true, example = "1")
            @PathVariable Integer id) {
        try {
            // TODO: 实现取消发布作业逻辑
            Assignment assignment = new Assignment();
            assignment.setId(id);
            assignment.setIsPublished(false);

            return ResponseEntity.ok(com.no99.edunexusassignment_and_assessment.dto.ApiResponse.success("作业取消发布成功", assignment));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(com.no99.edunexusassignment_and_assessment.dto.ApiResponse.error(400, e.getMessage()));
        }
    }
}
