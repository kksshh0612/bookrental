package bookrental.domain;

import bookrental.domain.*;
import bookrental.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class UserLogined extends AbstractEvent {

    private Long id;
    private String loginId;
    private String password;
    private String name;

    public UserLogined(User aggregate) {
        super(aggregate);
    }

    public UserLogined() {
        super();
    }
}
//>>> DDD / Domain Event
