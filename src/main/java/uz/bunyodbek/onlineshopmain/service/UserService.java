package uz.bunyodbek.onlineshopmain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bunyodbek.onlineshopmain.dto.UserDto;
import uz.bunyodbek.onlineshopmain.model.Result;
import uz.bunyodbek.onlineshopmain.model.User;
import uz.bunyodbek.onlineshopmain.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getALlUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public User getBYIDUser(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.get();
    }

    public Result create(UserDto userDto) {

        boolean existsedByPhonenumber = userRepository.existsByPhonenumber(userDto.getPhonenumber());

        if (existsedByPhonenumber) {
            return new Result(false, "Bunday raqamli user mavjud");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setPhonenumber(userDto.getPhonenumber());
        userRepository.save(user);

        return new Result(true, "User saqlandi");
    }

    public Result update(Integer id, UserDto userDto) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            user.setName(userDto.getName());
            user.setPassword(userDto.getPassword());
            user.setPhonenumber(userDto.getPhonenumber());
            userRepository.save(user);
            return new Result(true, "O'zgartirildi");
        }
        return new Result(false, "User topilmadi");
    }


    public Result delete(Integer id) {
        try {
            userRepository.deleteById(id);
            return new Result(true, "O'chirildi");
        } catch (Exception e) {
            return new Result(false, "Xato");
        }

    }


}
