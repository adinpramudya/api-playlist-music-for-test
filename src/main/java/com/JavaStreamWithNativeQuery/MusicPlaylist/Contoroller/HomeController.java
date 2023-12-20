package com.JavaStreamWithNativeQuery.MusicPlaylist.Contoroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // This assumes you have an "index.html" template in your "src/main/resources/templates" directory
    }
}