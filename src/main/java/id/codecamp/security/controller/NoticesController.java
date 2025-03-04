package id.codecamp.security.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import id.codecamp.security.model.Notice;
import id.codecamp.security.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NoticesController {

    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getNotices() {
        final List<Notice> notices = noticeRepository.findAllActiveNotices();
        if (notices.isEmpty()) {
            return null;
        }
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(notices);
    }
}