package com.sweetmart.controller;


import com.sweetmart.model.SweetItem;
import com.sweetmart.service.SweetItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sweetitem")
public class SweetItemController {

    @Autowired
    private SweetItemService sweetItemService ;


    @PostMapping("/add/{key}")
    public ResponseEntity<SweetItem> addSweetItemcon(@RequestBody SweetItem sweetItem , @PathVariable String key){

        SweetItem s = sweetItemService.addSweetItem(sweetItem ,key) ;
        return new ResponseEntity<>(s, HttpStatus.CREATED) ;

    }


    @PutMapping("/update/{key}")
    public ResponseEntity<SweetItem> updateSweetItemcon(@RequestBody SweetItem sweetItem , @PathVariable String key){

        SweetItem s = sweetItemService.UpdateSweetItem(sweetItem,key) ;
        return new ResponseEntity<>(s, HttpStatus.CREATED) ;

    }


    @DeleteMapping("/Delete/{key}/{id}")
    public ResponseEntity<SweetItem> deleteSweetItemcon(@PathVariable Integer id , @PathVariable String key){

        SweetItem s = sweetItemService.DeleteSweetItem(id,key) ;
        return new ResponseEntity<>(s, HttpStatus.CREATED) ;

    }

    @GetMapping("/getall/{key}")
    public ResponseEntity<List<SweetItem>> getAllSweetItem( @PathVariable String key ){

        List s = sweetItemService.AllSweetItem(key) ;
        return new ResponseEntity<>(s, HttpStatus.CREATED) ;

    }




}
