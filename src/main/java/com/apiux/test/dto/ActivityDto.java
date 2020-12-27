package com.apiux.test.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDto {

    private int id;
    @NotNull
    private String description;
    @NotNull
    private Date creation_date;
    @NotNull
    private Boolean is_active;
}
