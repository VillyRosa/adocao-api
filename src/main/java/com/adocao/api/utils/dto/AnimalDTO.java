package com.adocao.api.utils.dto;

import com.adocao.api.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AnimalDTO {

    @NotBlank(message = "Name is mandatory")
    private String petName;
    private String breed;
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
