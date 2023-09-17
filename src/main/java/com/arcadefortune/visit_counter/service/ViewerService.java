package com.arcadefortune.visit_counter.service;

import com.arcadefortune.visit_counter.model.Viewer;
import com.arcadefortune.visit_counter.repository.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ViewerService {
    @Autowired
    private ViewerRepository repository;

    // get viewer by Ip
    public Viewer getViewerByIp(String viewerIp) {
        return repository.findViewerByIp(viewerIp).get(0);
    }

    // register IP address
    public Viewer addViewerWithIp(String ip) {
        Viewer viewer = new Viewer(ip);
        viewer.setId(repository.count() + 1);
        return repository.save(viewer);
    }

    // add viewCount to existing IP address
    public Viewer incrementViewCount(Viewer viewer) {
        viewer.setViewCount(viewer.getViewCount() + 1);
        return repository.save(viewer);
    }

    public boolean doesViewerExistWithIp(String ip) {
        if (repository.findViewerByIp(ip).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
