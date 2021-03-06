package com.example.demo.ws;

import com.example.demo.bean.Client;
import com.example.demo.service.facade.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demo/Client")
public class ClientRest {
    @Autowired
    private ClientService clientService;
    @GetMapping("/cin/{cin}")
    public Client findByCin(@PathVariable String cin){
        return clientService.findBycin(cin);
    }
    @PostMapping("/save")
    public int save(@RequestBody Client client){
        return clientService.save(client);
    }
}
