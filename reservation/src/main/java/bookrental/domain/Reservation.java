package bookrental.domain;

import bookrental.ReservationApplication;
import bookrental.domain.BookReserved;
import bookrental.domain.ReservationCanceled;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Reservation_table")
@Data
//<<< DDD / Aggregate Root
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long bookId;

    private Date reservedTime;

    private String status;

    private Date returnedTime;

    private String bookName;

    @PostPersist
    public void onPostPersist() {
        BookReserved bookReserved = new BookReserved(this);
        bookReserved.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        ReservationCanceled reservationCanceled = new ReservationCanceled(this);
        reservationCanceled.publishAfterCommit();
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }
}
//>>> DDD / Aggregate Root
