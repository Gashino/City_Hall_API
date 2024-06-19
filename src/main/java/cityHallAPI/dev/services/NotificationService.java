package cityHallAPI.dev.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class NotificationService {

    private static final String EXPO_PUSH_URL = "https://exp.host/--/api/v2/push/send";

    public void sendPushNotification(String expoPushToken, String title, String body) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Accept-Encoding", "gzip, deflate");
        headers.set("Content-Type", "application/json");

        Map<String, Object> notificationData = new HashMap<>();
        notificationData.put("to", expoPushToken);
        notificationData.put("sound", "default");
        notificationData.put("title", title);
        notificationData.put("body", body);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(notificationData, headers);

        ResponseEntity<String> response = restTemplate.exchange(EXPO_PUSH_URL, HttpMethod.POST, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Notification sent successfully");
        } else {
            System.out.println("Failed to send notification: " + response.getBody());
        }
    }
}