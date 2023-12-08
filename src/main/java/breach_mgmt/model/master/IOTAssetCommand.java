package breach_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the IOT_ASSET_COMMANDS database table.
 * 
 */
@Entity
@Table(name = "IOT_ASSET_COMMANDS")
public class IOTAssetCommand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SENSOR_COMMAND_SEQUENCE")
	@SequenceGenerator(name = "SENSOR_COMMAND_SEQUENCE", sequenceName = "SENSOR_COMMAND_SEQUENCE", allocationSize = 1)
	@Column(name = "COMMAND_SEQ_NO")
	private Long commandSeqNo;

	@Column(name = "COMMAND")
	private String command;

	@Column(name = "DONEFLAG")
	private Character doneflag;

	@Column(name = "ON_DTTM")
	private Timestamp onDttm;

	@Column(name = "PROCESSEDFLAG")
	private Character processedflag;

	@Column(name = "SENSOR_ASSET_SEQ_NO")
	private Long sensorAssetSeqNo;

	public IOTAssetCommand() {
	}

	public Long getCommandSeqNo() {
		return this.commandSeqNo;
	}

	public void setCommandSeqNo(Long commandSeqNo) {
		this.commandSeqNo = commandSeqNo;
	}

	public String getCommand() {
		return this.command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Character getDoneflag() {
		return this.doneflag;
	}

	public void setDoneflag(Character doneflag) {
		this.doneflag = doneflag;
	}

	public Timestamp getOnDttm() {
		return this.onDttm;
	}

	public void setOnDttm(Timestamp onDttm) {
		this.onDttm = onDttm;
	}

	public Character getProcessedflag() {
		return this.processedflag;
	}

	public void setProcessedflag(Character processedflag) {
		this.processedflag = processedflag;
	}

	public Long getSensorAssetSeqNo() {
		return this.sensorAssetSeqNo;
	}

	public void setSensorAssetSeqNo(Long sensorAssetSeqNo) {
		this.sensorAssetSeqNo = sensorAssetSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commandSeqNo == null) ? 0 : commandSeqNo.hashCode());
		result = prime * result + ((sensorAssetSeqNo == null) ? 0 : sensorAssetSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IOTAssetCommand other = (IOTAssetCommand) obj;
		if (commandSeqNo == null) {
			if (other.commandSeqNo != null)
				return false;
		} else if (!commandSeqNo.equals(other.commandSeqNo))
			return false;
		if (sensorAssetSeqNo == null) {
			if (other.sensorAssetSeqNo != null)
				return false;
		} else if (!sensorAssetSeqNo.equals(other.sensorAssetSeqNo))
			return false;
		return true;
	}

	public IOTAssetCommand(Long commandSeqNo, String command, Character doneflag, Timestamp onDttm,
			Character processedflag, Long sensorAssetSeqNo) {
		super();
		this.commandSeqNo = commandSeqNo;
		this.command = command;
		this.doneflag = doneflag;
		this.onDttm = onDttm;
		this.processedflag = processedflag;
		this.sensorAssetSeqNo = sensorAssetSeqNo;
	}

}