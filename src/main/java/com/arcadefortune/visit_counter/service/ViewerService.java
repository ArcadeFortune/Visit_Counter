package com.arcadefortune.visit_counter.service;

import com.arcadefortune.visit_counter.model.TotalViews;
import com.arcadefortune.visit_counter.model.Viewer;
import com.arcadefortune.visit_counter.repository.TotalViewsRepository;
import com.arcadefortune.visit_counter.repository.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ViewerService {
    @Autowired
    private ViewerRepository viewerRepository;

    @Autowired
    private TotalViewsRepository totalViewsRepository;

    // get viewer by Ip
    public Viewer getViewerByIp(String viewerIp) {
        return viewerRepository.findViewerByIp(viewerIp).get(0);
    }

    // register IP address
    public Viewer addViewerWithIp(String ip) {
        Viewer viewer = new Viewer(ip);
        viewer.setId(viewerRepository.count());
        // get total views and saves it to this viewer
        TotalViews totalViews = getTotalViews();
        viewer.setTotalViewCount(totalViews.getTotalViews());

        return viewerRepository.save(viewer);
    }

    // add viewCount to existing IP address
    public Viewer incrementViewCount(Viewer viewer) {
        viewer.setViewCount(viewer.getViewCount() + 1);
        // get total views and saves it to this viewer
        TotalViews totalViews = getTotalViews();
        viewer.setTotalViewCount(totalViews.getTotalViews());
        return viewerRepository.save(viewer);
    }

    // add to total viewCount
    public void incrementTotalViewCount() {
        // get the total views
        TotalViews totalViews = getTotalViews();

        // add +1 to the total views
        totalViews.addView();

        // save totalViews
        totalViewsRepository.save(totalViews);
    }

    public TotalViews getTotalViews() {
        /**
         * get the totalViews document
         * @return TotalViews containing the total amount of views as an int.
         */
        TotalViews totalViews;

        if (totalViewsRepository.findById("0").isPresent()) {
            totalViews = totalViewsRepository.findById("0").get();
        } else {
            totalViews = new TotalViews();
        }

        return totalViews;
    }

    public boolean doesViewerExistWithIp(String ip) {
        if (viewerRepository.findViewerByIp(ip).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
