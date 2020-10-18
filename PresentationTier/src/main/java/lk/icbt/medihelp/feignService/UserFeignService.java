package lk.icbt.medihelp.feignService;

import lk.icbt.medihelp.dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "medihelp-business-tier")
public interface UserFeignService {

    @PostMapping("/user/save")
    boolean createUser(@RequestBody UserDto userDto);

}
