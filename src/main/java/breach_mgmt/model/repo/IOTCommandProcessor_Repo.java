package breach_mgmt.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import breach_mgmt.model.master.IOTAssetCommand;

@Transactional(propagation=Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@Repository("iotCommandProcessorRepo")
public interface IOTCommandProcessor_Repo extends JpaRepository<IOTAssetCommand, Long> 
{}