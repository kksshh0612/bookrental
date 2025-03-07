package bookrental.domain;

import bookrental.domain.*;
import bookrental.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class BookReserved extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long bookId;
    private Date reservedTime;
    private String status;
    private Date returnedTime;
    private String bookName;
}
