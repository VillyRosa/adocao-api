package com.adocao.api.utils.dto;

import com.adocao.api.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "CPF is mandatory")
    @CPF(message = "Invalid CPF")
    private String cpf;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
