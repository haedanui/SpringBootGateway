package com.nhnacademy.edu.gateway.request;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagRequest {
    private Long tagNumber;
    private String tagName;
    private Long projectId;
}
