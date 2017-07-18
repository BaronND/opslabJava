package com.opslab.hibernate.entity.extend.joined;

public class computer extends goods {
	private String cpu;
	
	private String mainboard;
	
	private String gpu;
	
	private String memory;

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMainboard() {
		return mainboard;
	}

	public void setMainboard(String mainboard) {
		this.mainboard = mainboard;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}
	
}
