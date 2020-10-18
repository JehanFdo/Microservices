package lk.icbt.medihelp.controller;

import lk.icbt.medihelp.dtos.UserDto;
import lk.icbt.medihelp.feignService.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private UserFeignService userFeignService;

    @Autowired
    public void setUserFeignService(UserFeignService userFeignService) {
        this.userFeignService = userFeignService;
    }

    @PostMapping("/create-user")
    public String createUser(@RequestBody UserDto userDto) {

        boolean user = userFeignService.createUser(userDto);

        if (user) {
            return "User Has Successfully Created";
        } else {
            return "Something Wrong With the User Creation";
        }
    }
}
