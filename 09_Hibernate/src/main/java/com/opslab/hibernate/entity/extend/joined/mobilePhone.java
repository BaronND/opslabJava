package com.opslab.hibernate.entity.extend.joined;

public class mobilePhone extends goods{
	private String cpu;
	
	private String memory;
	
	private String NetworkChip;

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getNetworkChip() {
		return NetworkChip;
	}

	public void setNetworkChip(String networkChip) {
		NetworkChip = networkChip;
	}
	
	
}
