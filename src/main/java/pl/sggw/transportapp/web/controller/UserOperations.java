package pl.sggw.transportapp.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.sggw.transportapp.model.CreateUserDto;
import pl.sggw.transportapp.model.entity.User;

import java.util.List;

@Tag(name = "UŻYTKOWNICY", description = "Zarządzanie użytkownikami aplikacji")
public interface UserOperations {

    @Operation(summary = "Pobranie listy użytkowników")
    Page<User> listUsers(int pageSize, int page);

    @Operation(summary = "Usunięcie użytkownika")
    Boolean deleteUser(long userId);

    @Operation(summary = "Pobranie użytkownika po nazwie")
    User getUser(String userName);

    @Operation(summary = "Dodanie nowego użytkownika")
    User addUser(CreateUserDto createUserDto);
}
