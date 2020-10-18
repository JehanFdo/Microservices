package lk.icbt.medihelp.service;

import lk.icbt.medihelp.dtos.UserDto;
import lk.icbt.medihelp.feignService.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Service
public class UserService {

    private UserFeignService userFeignService;

    @Autowired
    public void setUserFeignService(UserFeignService userFeignService) {
        this.userFeignService = userFeignService;
    }

    @PostMapping("/save")
    public boolean createUser(@RequestBody UserDto userDto ) {
        System.out.println(userDto);
        return userFeignService.createUser(userDto);

    }

}
