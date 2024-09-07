package by.alst.project.jdbc.dto;

import java.time.LocalDateTime;

public record UserDto(Integer id, String email, String password, LocalDateTime registrationDate, Integer roleId,
                      Integer genderId) {
}
