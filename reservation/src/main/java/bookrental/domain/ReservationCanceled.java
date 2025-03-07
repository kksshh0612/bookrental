package bookrental.domain;

import bookrental.domain.*;
import bookrental.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ReservationCanceled extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long bookId;
    private Date cancelTime;
    private Date reservedTime;
    private String status;
    private Date returnedTime;
    private String bookName;

    public ReservationCanceled(Reservation aggregate) {
        super(aggregate);
    }

    public ReservationCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
