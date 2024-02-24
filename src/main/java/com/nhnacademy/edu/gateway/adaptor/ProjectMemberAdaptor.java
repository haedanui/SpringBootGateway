package com.nhnacademy.edu.gateway.adaptor;

import com.nhnacademy.edu.gateway.domain.ProjectMember;

import java.util.List;

public interface ProjectMemberAdaptor {
    List<ProjectMember> getProjectMembers(String userName);

    ProjectMember getProjectMember(String userName);

    void createProjectMember(ProjectMember projectMember);
}
