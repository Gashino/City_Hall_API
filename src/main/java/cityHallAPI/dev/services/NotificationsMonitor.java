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

    @Autowired
    private NotificationService notificationService;

    @Scheduled(fixedRate = 10000)
    public void checkForChanges() {
        System.out.println("Checking for changes");
        List<Change> changes = changeRepository.findAllUnnotifiedChanges();
        for (Change change : changes) {
            String tipoReclamo = change.getType();
            notificationService.sendPushNotification(change.getExpoPushToken(), "Actualizacion en " + tipoReclamo, "Su " +
                    tipoReclamo + " con ID #"+ change.getIdType() + " ha sido actualizado");
            change.setNotified(true);
            changeRepository.save(change);
        }
    }
}