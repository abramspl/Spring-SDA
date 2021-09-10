package pl.sda.bcrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncoderMain {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("12345"));

        System.out.println(encoder.matches("12345","$2a$10$cF9CuRh1ce8qUTpgrzzbV.LYvVKH1rd18BrrM4zmRwMyhB9bWDTde"));
    }
}
