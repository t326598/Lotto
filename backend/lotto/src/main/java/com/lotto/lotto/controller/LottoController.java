package com.lotto.lotto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.lotto.lotto.dto.Lotto;
import com.lotto.lotto.service.LottoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/lotto")
public class LottoController {

    @Autowired
    private LottoService lottoService;

    @GetMapping("")
    public ResponseEntity<?> getMethodName() {
           try {
        List<Lotto> lottoList = lottoService.allList();
        return new ResponseEntity<>(lottoList, HttpStatus.OK);
           } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @GetMapping("/{no}")
    public ResponseEntity<?> getMethodName(@PathVariable Long no) {
        try {
            Lotto lotto = lottoService.selectByNo(no);  
            return new ResponseEntity<>(lotto, HttpStatus.OK);
            
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
