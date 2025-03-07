package bookrental.infra;

import bookrental.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "bookDashboards",
    path = "bookDashboards"
)
public interface BookDashboardRepository
    extends PagingAndSortingRepository<BookDashboard, Long> {}
