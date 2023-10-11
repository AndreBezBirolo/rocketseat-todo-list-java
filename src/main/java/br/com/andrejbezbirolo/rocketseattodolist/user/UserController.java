package br.com.andrejbezbirolo.rocketseattodolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var alreadyHasUser = this.userRepository.findByUsername(userModel.getUsername());
        if (alreadyHasUser != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Usuário já existe.");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(userModel);
        }
    }
}
