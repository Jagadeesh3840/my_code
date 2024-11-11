package com.employee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class EmployeeDTO {

    private Long employeeId;

    @NotBlank(message = "firstName should not be empty")
    private String firstName;

    @NotBlank(message = "lastName should not be empty")
    private String lastName;

    @NotBlank(message = "email should not be empty")
    private String email;

    @Min(value = 0, message = "Value must be non-negative")
    private Double salary;

    @NotNull(message = "Date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate doj;

    @Size(min = 1, message = "mobileNumbers should not be empty")
    private List<String> mobileNumbers;

    private Double taxAmount;

    private Double cessAmount;
}
