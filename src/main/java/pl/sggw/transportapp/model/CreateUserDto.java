package pl.sggw.transportapp.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CreateUserDto {
    private String username;
    private char[] password;
}
