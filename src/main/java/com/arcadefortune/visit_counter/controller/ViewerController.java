package com.arcadefortune.visit_counter.controller;

import com.arcadefortune.visit_counter.model.Viewer;
import com.arcadefortune.visit_counter.service.ImageService;
import com.arcadefortune.visit_counter.service.ViewerService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

import java.io.IOException;
import javax.imageio.ImageIO;


@RestController
@RequestMapping("/")
public class ViewerController {
    @Autowired
    private ViewerService service;

    @Autowired
    private ImageService imageService;
    // hello world (not important)
    @GetMapping
    public String hello() {
        return "Hello World. | Current Version: 1.2.2 | made by ArcadeFortune / Alessio Lama | watch Date A Live";
    }

    // addIp
    @GetMapping("/visit")
    public Viewer setViewer(HttpServletRequest httpServletRequest) {
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

    @GetMapping(value = "/totalviewcount", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getTotalViewCount(HttpServletRequest httpServletRequest) throws IOException {
        int totalViewCount = setViewer(httpServletRequest).getTotalViewCount();

        BufferedImage generatedImage = imageService.generateImage("A total of " + totalViewCount + " people have visited me!");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(generatedImage, "png", baos);
        return baos.toByteArray();
    }


    @GetMapping(value = "/viewcount", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getViewCount(HttpServletRequest httpServletRequest) throws IOException {
        int viewCount = setViewer(httpServletRequest).getViewCount();

        BufferedImage generatedImage = imageService.generateImage("You visited me " + viewCount + " times!");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(generatedImage, "png", baos);
        return baos.toByteArray();
    }
}
