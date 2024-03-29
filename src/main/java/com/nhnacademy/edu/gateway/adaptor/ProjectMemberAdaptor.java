package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.domain.ProjectMember;

import java.util.List;

public interface ProjectMemberAdaptor {
    List<ProjectMember> getProjectMembers(Long projectId);

    ProjectMember getProjectMember(String userName);

    void createProjectMember(ProjectMember projectMember);
}
