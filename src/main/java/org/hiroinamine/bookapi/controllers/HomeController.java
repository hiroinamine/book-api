package org.hiroinamine.bookapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @ResponseBody
    @RequestMapping("/")
    public Map<String, String> status() {
        Map<String, String> map = new HashMap<>();
        map.put("status", "ok");
        return map;
    }
}
