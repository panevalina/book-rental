package mk.ukim.finki.emt_labs.service.application.impl;

import mk.ukim.finki.emt_labs.model.domain.User;
import mk.ukim.finki.emt_labs.model.dto.create.CreateUserDto;
import mk.ukim.finki.emt_labs.model.dto.display.DisplayUserDto;
import mk.ukim.finki.emt_labs.model.dto.login.LoginResponseDto;
import mk.ukim.finki.emt_labs.model.dto.login.LoginUserDto;
import mk.ukim.finki.emt_labs.model.projections.UserProjection;
import mk.ukim.finki.emt_labs.security.JwtHelper;
import mk.ukim.finki.emt_labs.service.application.IUserApplicationService;
import mk.ukim.finki.emt_labs.service.domain.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserApplicationService implements IUserApplicationService {
    private final IUserService userService;
    private final JwtHelper jwtHelper;

    public UserApplicationService(IUserService userService, JwtHelper jwtHelper) {
        this.userService = userService;
        this.jwtHelper = jwtHelper;
    }


    @Override
    public Optional<DisplayUserDto> register(CreateUserDto createUserDto) {
        User user = userService.register(
                createUserDto.username(),
                createUserDto.password(),
                createUserDto.repeatPassword(),
                createUserDto.name(),
                createUserDto.role()
        );
        return Optional.of(DisplayUserDto.from(user));    }

    @Override
    public Optional<LoginResponseDto> login(LoginUserDto loginUserDto) {
        User user = userService.login(loginUserDto.username(),loginUserDto.password());

        String token = jwtHelper.generateToken(user);
        return Optional.of(new LoginResponseDto(token));
    }


    @Override
    public Optional<DisplayUserDto> findByUsername(String username) {
        return Optional.of(DisplayUserDto.from(userService.findByUsername(username)));
    }

    @Override
    public List<UserProjection> getAllUserNames() {
        return userService.getAllUserNames();
    }
}


