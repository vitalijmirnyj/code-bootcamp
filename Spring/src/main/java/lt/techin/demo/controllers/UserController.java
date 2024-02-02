package lt.techin.demo.controllers;


import lt.techin.demo.models.User;
import lt.techin.demo.repositories.UserRepository;

import lt.techin.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return this.userService.findAllUsers();
    }


    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return this.userService.findUserById(id);

    }

    @PostMapping("/users")
    public User insertUser(@RequestBody User user) {
        return this.userService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable long id) {
        if (this.userService.existsById(id)) {
            User userFromDb = this.actorService.findActorById(id);
            actorFromDb.setGender(actor.getGender());
            actorFromDb.setAge(actor.getAge());
            actorFromDb.setNationality(actor.getNationality());
            actorFromDb.setName(actor.getName());
            actorFromDb.setSurname(actor.getSurname());
            return this.actorService.saveActor(actorFromDb);
        }
        return this.actorService.saveActor(actor);
    }

    @DeleteMapping("/actors/{id}")
    public void deleteActor(@PathVariable long id) {
        this.actorService.deleteActorById(id);
    }

}
