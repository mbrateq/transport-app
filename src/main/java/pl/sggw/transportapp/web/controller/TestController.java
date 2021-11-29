package pl.sggw.transportapp.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//UNUSED
public class TestController {

    @GetMapping("/test")
    public String hello(){
        return "Hello from transport-api :)";
    }
}
