package bookrental.infra;

import bookrental.config.kafka.KafkaProcessor;
import bookrental.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookReserved'"
    )
    public void wheneverBookReserved_BookReserveNotificationRequest(
        @Payload BookReserved bookReserved
    ) {
        BookReserved event = bookReserved;
        System.out.println(
            "\n\n##### listener BookReserveNotificationRequest : " +
            bookReserved +
            "\n\n"
        );

        // Sample Logic //
        Notification.bookReserveNotificationRequest(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReservationCanceled'"
    )
    public void wheneverReservationCanceled_BookReservationCancelNotificationRequest(
        @Payload ReservationCanceled reservationCanceled
    ) {
        ReservationCanceled event = reservationCanceled;
        System.out.println(
            "\n\n##### listener BookReservationCancelNotificationRequest : " +
            reservationCanceled +
            "\n\n"
        );

        // Sample Logic //
        Notification.bookReservationCancelNotificationRequest(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
