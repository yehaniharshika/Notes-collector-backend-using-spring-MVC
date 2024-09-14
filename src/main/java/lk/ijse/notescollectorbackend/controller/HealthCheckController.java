package lk.ijse.notescollectorbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/health")
public class HealthCheckController {
    //meke dila thiyena statement eka return karanwa.it means that this is work
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  String healthTest(){
        return "Note Controller is making";
    }
}
