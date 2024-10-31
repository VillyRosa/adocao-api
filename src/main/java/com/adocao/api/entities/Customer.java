package com.adocao.api.entities;

import com.adocao.api.utils.dto.CustomerDTO;
import com.adocao.api.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@Setter
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String cpf;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Customer(CustomerDTO customerDTO) {
        this.name = customerDTO.getName();
        this.cpf = customerDTO.getCpf();
        this.email = customerDTO.getEmail();
        this.phone = customerDTO.getPhone();
        this.gender = customerDTO.getGender();
    }

}
