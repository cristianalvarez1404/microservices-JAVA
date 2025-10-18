package com.zosh.zosh.pos.system.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
@Embeddable
public class StoreContact {
    private String address;
    private String phone;

    @Email(message = "Invalid email format")
    private String email;
}
