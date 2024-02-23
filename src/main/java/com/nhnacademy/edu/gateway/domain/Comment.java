package com.nhnacademy.edu.gateway.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long commentNumber;
    private String commentContent;
    private String userName;
    private Long taskNumber;
}
