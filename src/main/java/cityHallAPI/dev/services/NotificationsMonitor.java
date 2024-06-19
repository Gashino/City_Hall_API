package cityHallAPI.dev.services;

import cityHallAPI.dev.entitys.Change;
import cityHallAPI.dev.repository.ChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@EnableScheduling
public class NotificationsMonitor {

    @Autowired
    private ChangeRepository changeRepository;

    @Scheduled(fixedRate = 5000)
    public void checkForChanges() {
        System.out.println("Checking for changes");
        List<Change> changes = changeRepository.findAllUnnotifiedChanges();
        for (Change change : changes) {
//            notificationService.sendPushNotification(change.getExpoPushToken(), "Column Changed", "The column value has been updated.");
            change.setNotified(true);
            changeRepository.save(change);
        }
    }
}
