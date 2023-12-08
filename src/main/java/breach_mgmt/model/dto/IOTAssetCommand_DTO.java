package breach_mgmt.model.dto;

import java.io.Serializable;

public class IOTAssetCommand_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3239014500908958634L;
	private Long commandSeqNo;
	private String command;
	private String doneflag;
	private String onDttm;
	private String processedflag;
	private Long sensorAssetSeqNo;

	public Long getCommandSeqNo() {
		return commandSeqNo;
	}

	public void setCommandSeqNo(Long commandSeqNo) {
		this.commandSeqNo = commandSeqNo;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getDoneflag() {
		return doneflag;
	}

	public void setDoneflag(String doneflag) {
		this.doneflag = doneflag;
	}

	public String getOnDttm() {
		return onDttm;
	}

	public void setOnDttm(String onDttm) {
		this.onDttm = onDttm;
	}

	public String getProcessedflag() {
		return processedflag;
	}

	public void setProcessedflag(String processedflag) {
		this.processedflag = processedflag;
	}

	public Long getSensorAssetSeqNo() {
		return sensorAssetSeqNo;
	}

	public void setSensorAssetSeqNo(Long sensorAssetSeqNo) {
		this.sensorAssetSeqNo = sensorAssetSeqNo;
	}

	public IOTAssetCommand_DTO(Long commandSeqNo, String command, String doneflag, String onDttm, String processedflag,
			Long sensorAssetSeqNo) {
		super();
		this.commandSeqNo = commandSeqNo;
		this.command = command;
		this.doneflag = doneflag;
		this.onDttm = onDttm;
		this.processedflag = processedflag;
		this.sensorAssetSeqNo = sensorAssetSeqNo;
	}

	public IOTAssetCommand_DTO() {
		super();
	}

}