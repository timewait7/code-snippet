package com.tw.codesnippet;

import com.tw.codesnippet.validtor.Phone;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

    @NotBlank(groups = Update.class)
    private String userId;

    @NotBlank(groups = {Save.class, Update.class})
    @Length(min = 2, max = 10, groups = {Save.class, Update.class})
    private String username;

    @NotBlank(groups = {Save.class, Update.class})
    @Length(min = 6, max = 10, groups = {Save.class, Update.class})
    private String password;

    @NotNull(groups = {Save.class, Update.class})
    @Valid
    private Address address;

    @NotBlank
    @Phone
    private String phone;

    @Data
    public class Address {

        @NotBlank(groups = {Save.class, Update.class})
        private String country;

        @NotBlank(groups = {Save.class, Update.class})
        private String state;

        @NotBlank(groups = {Save.class, Update.class})
        private String city;

        @NotBlank(groups = {Save.class, Update.class})
        private String street;
    }

    public interface Save {

    }

    public interface Update {

    }
}
