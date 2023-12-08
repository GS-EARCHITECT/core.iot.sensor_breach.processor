package breach_mgmt.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import breach_mgmt.model.master.IOTAssetReadingBreach;
import breach_mgmt.model.master.IOTAssetReadingBreachPK;

@Transactional(propagation=Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
@Repository("iotBreachProcessorRepo")
public interface IOTBreachProcessor_Repo extends JpaRepository<IOTAssetReadingBreach, IOTAssetReadingBreachPK> 
{
	@Query(value = "select * from IOT_ASSETREADING_BREACH where actual_badctr >= breach_badctr orderby SENSOR_ASSET_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<IOTAssetReadingBreach> getBadCtrs();

}