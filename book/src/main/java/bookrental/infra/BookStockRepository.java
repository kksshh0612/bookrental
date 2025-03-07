package bookrental.infra;

import bookrental.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "bookStocks",
    path = "bookStocks"
)
public interface BookStockRepository
    extends PagingAndSortingRepository<BookStock, Long> {}
