package com.den.example.controllers;

import com.den.example.model.User;
import com.den.example.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("/saveAll")
    @ResponseStatus(HttpStatus.CREATED)
    public List<User> saveMultiple(@RequestBody List<User> list){
        return userService.saveMultiple(list);
    }

    @GetMapping
    public ResponseEntity<List<User>> select() {
        final List<User> users = userService.selectAll();

        if ( users != null &&  !users.isEmpty())
            return new ResponseEntity<>(users, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> select(@PathVariable(name = "id") int id) {
        final User user = userService.selectById(id);

        if (user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Integer> update(@PathVariable(name = "id") int id,
                                          @RequestBody User user) {
        final boolean updated = userService.update(user, id);

        if (updated)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = userService.deleteById(id);

        if (deleted)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
