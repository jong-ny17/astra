package com.astra.astrabackend.controller;

import com.astra.astrabackend.dto.UsersRequestDTO;
import com.astra.astrabackend.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping
    public void newUsers(@RequestBody UsersRequestDTO dto){
        System.err.println(dto.toString());
        userService.newUsers(dto);
    }

    @GetMapping("/{pw}")
    public ResponseEntity<?> login(@RequestParam(value = "id") String id , @PathVariable String pw , HttpSession session) {
        return userService.login(id , pw , session);
    }

    @GetMapping("/checkId")
    public String isExistId(@RequestParam(value = "id")  String id){
        return userService.isExistId(id);
    }
}
