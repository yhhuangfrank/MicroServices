package com.frank.customer;

import com.frank.clients.fraud.FraudCheckResponse;
import com.frank.clients.fraud.FraudClient;
import com.frank.clients.notification.NotificationClient;
import com.frank.clients.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
        // todo: check if email valid
        // todo: check if email duplicate

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse != null && fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // todo: send async with message queue
        NotificationRequest notificationRequest = new NotificationRequest(customer.getId(), customer.getEmail(), "this is notification");
        notificationClient.notifyCustomer(notificationRequest);
    }
}
