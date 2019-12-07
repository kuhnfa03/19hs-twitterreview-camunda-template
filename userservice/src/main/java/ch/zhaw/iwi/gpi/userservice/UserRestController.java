package ch.zhaw.iwi.gpi.userservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserRestController
 */
@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/userapi/v1/users/{userName}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUser(@PathVariable String userName){
        Optional<UserEntity> user = userRepository.findById(userName);

        if(user.isPresent()){
            return new ResponseEntity<UserEntity>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}