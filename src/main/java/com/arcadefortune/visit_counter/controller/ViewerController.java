package com.arcadefortune.visit_counter.controller;

import com.arcadefortune.visit_counter.model.Viewer;
import com.arcadefortune.visit_counter.service.ViewerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class ViewerController {
    @Autowired
    private ViewerService service;

    // hello world (not important)
    @GetMapping
    public String hello() {
        return "Hello World.";
    }

    // addIp
    @GetMapping("/visit")
    public Viewer addView(HttpServletRequest httpServletRequest) {
        String ip = httpServletRequest.getRemoteAddr();

        // add to total views
        service.incrementTotalViewCount();

        if (service.doesViewerExistWithIp(ip)) {
            // get existing viewer
            Viewer viewer = service.getViewerByIp(ip);
            // edit existing viewer
            return service.incrementViewCount(viewer);
        } else {
            // register new viewer
            return service.addViewerWithIp(ip);
        }
    }
}
