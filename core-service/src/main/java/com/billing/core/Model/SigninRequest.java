package com.billing.core.Model;

import lombok.Data;

@Data
public class SigninRequest {
    private String username;
    private String password;
}