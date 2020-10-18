package lk.icbt.medihelp.repository;


import lk.icbt.medihelp.dtos.UserDto;

public interface UserRepository {

    boolean createUser(UserDto users);
}
