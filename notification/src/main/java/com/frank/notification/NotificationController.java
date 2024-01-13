package com.frank.notification;

import com.frank.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public void notifyCustomer(@RequestBody NotificationRequest notificationRequest) {
        notificationService.notifyCustomer(notificationRequest);
    }
}
