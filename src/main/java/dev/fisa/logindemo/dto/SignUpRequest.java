package dev.fisa.logindemo.dto;

import java.util.List;

public record SignUpRequest(
    String username,
    String password,
    List<String> authorities
) {

}
