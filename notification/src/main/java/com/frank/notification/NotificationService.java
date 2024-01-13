package com.frank.notification;

import com.frank.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void notifyCustomer(NotificationRequest notificationRequest) {
        log.info("start to notify customer: {}", notificationRequest.toCustomerId());
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerEmail())
                        .message(notificationRequest.message())
                        .sender("frank")
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
