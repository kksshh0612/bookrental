package bookrental.infra;

import bookrental.config.kafka.KafkaProcessor;
import bookrental.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class BookDashboardViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private BookDashboardRepository bookDashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookRegistered_then_CREATE_1(
        @Payload BookRegistered bookRegistered
    ) {
        try {
            if (!bookRegistered.validate()) return;

            // view 객체 생성
            BookDashboard bookDashboard = new BookDashboard();
            // view 객체에 이벤트의 Value 를 set 함
            // view 레파지 토리에 save
            bookDashboardRepository.save(bookDashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookReserved_then_UPDATE_1(
        @Payload BookReserved bookReserved
    ) {
        try {
            if (!bookReserved.validate()) return;
            // view 객체 조회
            Optional<BookDashboard> bookDashboardOptional = bookDashboardRepository.findById(
                bookReserved.getBookId()
            );

            if (bookDashboardOptional.isPresent()) {
                BookDashboard bookDashboard = bookDashboardOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                bookDashboard.setId(bookReserved.getBookId());
                bookDashboard.setBookName(bookReserved.getBookName());
                // view 레파지 토리에 save
                bookDashboardRepository.save(bookDashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCanceled_then_UPDATE_2(
        @Payload ReservationCanceled reservationCanceled
    ) {
        try {
            if (!reservationCanceled.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
