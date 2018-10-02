/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aj.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ajilal
 */
@Controller
@RequestMapping("api")
public class Contoller {
    
    @RequestMapping(value = "test", produces = {"application/json"})
    @ResponseBody
    @PreAuthorize("permitAll()")
    public String test(){
        return "test";
    }
    
    @RequestMapping(value = "ajilal", produces = {"application/json"})
    @ResponseBody
    @PreAuthorize("hasAuthority('AJILAL')")
    public String ajilal(){
        return "Ajilal";
    }
    
    @RequestMapping(value = "login", produces = {"application/json"})
    @ResponseBody
    @PreAuthorize("permitAll()")
    public String login(){
        return "login";
    }
}
