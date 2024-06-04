package com.app.SpringBootSeleniumCucumberProj.model.tests_data.feature.login_registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRegistrationCredentials {
    private String email;
    private String password;
    private String errorMessage;
}
