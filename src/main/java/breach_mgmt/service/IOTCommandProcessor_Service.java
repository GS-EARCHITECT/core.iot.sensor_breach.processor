package breach_mgmt.service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import breach_mgmt.model.master.IOTAssetCommand;
import breach_mgmt.model.master.IOTAssetReadingBreach;
import breach_mgmt.model.repo.IOTCommandProcessor_Repo;

@Service("iotCommandProcessorServ")
public class IOTCommandProcessor_Service {
	// private static final Logger logger =
	// LoggerFactory.getLogger(KafkaIOTProcessListener_Service.class);

	@Autowired
	private IOTCommandProcessor_Repo iotCommandProcessorRepo;

	@Async
	public synchronized void insertCommand(IOTAssetReadingBreach iotAssetReadingBreach) 
	{
		String commandString = iotAssetReadingBreach.getCommandString();
		Long sensorAssetSeqNo = iotAssetReadingBreach.getId().getSensorAssetSeqNo();
		CopyOnWriteArrayList<String> commmandList = (CopyOnWriteArrayList<String>) Arrays
				.asList(commandString.split(","));

		for (int i = 0; i < commmandList.size(); i++) {
			iotCommandProcessorRepo.save(setAssetReading(sensorAssetSeqNo, commmandList.get(i)));
		}

		return;
	}

	private synchronized IOTAssetCommand setAssetReading(Long sensorAssetSeqNo, String commandMessage) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		IOTAssetCommand iotAssetCommand = new IOTAssetCommand();
		iotAssetCommand.setOnDttm(ts);
		iotAssetCommand.setSensorAssetSeqNo(sensorAssetSeqNo);
		iotAssetCommand.setCommand(commandMessage);
		iotAssetCommand.setDoneflag('Y');
		iotAssetCommand.setProcessedflag('N');
		return iotAssetCommand;
	}
}