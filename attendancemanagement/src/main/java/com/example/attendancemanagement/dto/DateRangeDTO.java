package com.example.attendancemanagement.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DateRangeDTO {
    private Long id;
    private String startDate;
    private String endDate;
}
