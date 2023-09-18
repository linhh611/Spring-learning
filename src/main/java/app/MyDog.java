package app;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyDog {

    @EventListener
    public void doorBellEventListener(DoorBellEvent doorBellEvent) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + ": Cho ngủ dậy!!");
        System.out.printf("%s: Go go!! Có người tên là %s gõ cửa!!!%n", Thread.currentThread().getName(), doorBellEvent.getGuestName());
    }
}

