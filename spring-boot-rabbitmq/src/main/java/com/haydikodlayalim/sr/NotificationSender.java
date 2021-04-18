package demo;

import demo.model.Notification;
import demo.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Component
public class NotificationSender {

    @Autowired
    private Producer producer;

    public void getThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                Notification notification = new Notification();
                notification.setId(UUID.randomUUID().toString());
                notification.setCreatedAt(new Date());
                notification.setMessage("New message from sofisticat...");
                notification.setSent(false);
                producer.sendToQueue(notification);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("Notification sender");
        thread.start();
    }


    @PostConstruct
    public void init() {
        getThread();

    }
}
