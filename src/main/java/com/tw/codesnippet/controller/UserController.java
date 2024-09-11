package com.tw.codesnippet.controller;

import com.tw.codesnippet.UserDTO;
import com.tw.codesnippet.validtor.Phone;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("user")
@Validated
public class UserController {

    @PostMapping("save")
    public UserDTO saveUser(@RequestBody @Validated(UserDTO.Save.class) UserDTO userDTO) { // 也可以使用 @Valid
        return userDTO;
    }

    @PutMapping("update")
    public UserDTO updateUser(@RequestBody @Validated(UserDTO.Update.class) UserDTO userDTO) { // 也可以使用 @Valid
        return userDTO;
    }

    @GetMapping
    public UserDTO getUser(@RequestParam("userId") @NotBlank String userId) {
        return new UserDTO();
    }

    @GetMapping("phone")
    public String validatePhone(@RequestParam("phone") @Phone String phone) {
        return phone;
    }
}
