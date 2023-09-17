package com.arcadefortune.visit_counter.controller;

import com.arcadefortune.visit_counter.model.Viewer;
import com.arcadefortune.visit_counter.service.ViewerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/visit")
public class ViewerController {
    @Autowired
    private ViewerService service;

    // addIp
    @GetMapping
    public Viewer addView(HttpServletRequest httpServletRequest) {
        String ip = httpServletRequest.getRemoteAddr();
        if (service.doesViewerExistWithIp(ip)) {
            // get existing viewer
            Viewer viewer = service.getViewerByIp(ip);
            // edit existing viewer
            return service.incrementViewCount(viewer);
        } else {
            // create new viewer
            return service.addViewerWithIp(ip);
        }
    }
}
