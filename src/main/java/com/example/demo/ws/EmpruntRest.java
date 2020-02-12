package com.example.demo.ws;

import com.example.demo.bean.Emprunt;
import com.example.demo.service.facade.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("demo/Emprunt")
public class EmpruntRest {
    @Autowired
    private EmpruntService empruntService;
    @GetMapping("/isbn/{isbn}")
    public List<Emprunt> findByLivreIsbn(@PathVariable String isbn){
        return empruntService.findByLivreIsbn(isbn);
    }
    @GetMapping("/cin/{cin}")
    public List<Emprunt> findByClientCin(@PathVariable String cin){
        return empruntService.findByClientCin(cin);
    }
    @GetMapping("/findNonRestituee")
    public List<Emprunt> findNonRestituee(){
        return empruntService.findNonRestituee();
    }
    @PostMapping("/save")
    public int save(@RequestBody Emprunt emprunt){
        return empruntService.save(emprunt);
    }
    @PutMapping("/restituer")
    public int restituer(@RequestBody Long id, @RequestBody Date dateRestitution){
        return empruntService.restituer(id,dateRestitution);
    }

}
