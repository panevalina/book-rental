package mk.ukim.finki.emt_labs.service.application;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.emt_labs.model.dto.create.CreateUserDto;
import mk.ukim.finki.emt_labs.model.dto.display.DisplayUserDto;
import mk.ukim.finki.emt_labs.model.dto.login.LoginResponseDto;
import mk.ukim.finki.emt_labs.model.dto.login.LoginUserDto;
import mk.ukim.finki.emt_labs.model.projections.UserProjection;

import java.util.List;
import java.util.Optional;

public interface IUserApplicationService {
    Optional<DisplayUserDto> register(CreateUserDto createUserDto);
    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);
    Optional<DisplayUserDto> findByUsername(String username);
    List<UserProjection> getAllUserNames();
}