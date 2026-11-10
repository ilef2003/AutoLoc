package tn.esprit.tp_autoloc.service.factory;

import org.springframework.stereotype.Component;
import tn.esprit.tp_autoloc.observer.EmailNotificationObserver;
import tn.esprit.tp_autoloc.observer.IReservationObserver;
import tn.esprit.tp_autoloc.observer.SmsNotificationObserver;

@Component
public class NotificationFactory {

    private final EmailNotificationObserver emailNotificationObserver;
    private final SmsNotificationObserver smsNotificationObserver;

    public NotificationFactory(EmailNotificationObserver emailNotificationObserver,
                               SmsNotificationObserver smsNotificationObserver) {
        this.emailNotificationObserver = emailNotificationObserver;
        this.smsNotificationObserver = smsNotificationObserver;
    }

    public IReservationObserver creerObservateur(String canal) {
        if ("SMS".equalsIgnoreCase(canal)) {
            return smsNotificationObserver;
        }
        return emailNotificationObserver;
    }
}