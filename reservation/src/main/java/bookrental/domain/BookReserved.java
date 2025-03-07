package bookrental.domain;

import bookrental.domain.*;
import bookrental.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookReserved extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long bookId;
    private Date reservedTime;
    private String status;
    private Date returnedTime;
    private String name;

    public BookReserved(Reservation aggregate) {
        super(aggregate);
    }

    public BookReserved() {
        super();
    }
}
//>>> DDD / Domain Event
