package breach_mgmt.service;

import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import breach_mgmt.model.master.IOTAssetReadingBreach;
import breach_mgmt.model.repo.IOTBreachProcessor_Repo;

@Service("IOTBreachProcessorServ")
public class IOTBreachProcessor_Service {
	private static final Logger logger = LoggerFactory.getLogger(IOTBreachProcessor_Service.class);

	@Autowired
	private IOTBreachProcessor_Repo iotBreachProcessorRepo;

	@Autowired
	private IOTCommandProcessor_Service iotCommandProcessorServ;

	@Scheduled(fixedRate = 3000)
	public void inputReading() 
	{
		CopyOnWriteArrayList<IOTAssetReadingBreach> iotAssetReadingBreachs = iotBreachProcessorRepo.getBadCtrs();

		if (iotAssetReadingBreachs != null && iotAssetReadingBreachs.size() > 0) {

			for (int i = 0; i < iotAssetReadingBreachs.size(); i++) {
				iotCommandProcessorServ.insertCommand(iotAssetReadingBreachs.get(i));
			}
		}
		return;

	}

}