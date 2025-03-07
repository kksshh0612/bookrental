package bookrental.domain;

import bookrental.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class BookRegistered extends AbstractEvent {

    private Long id;
    private String stock;
}
