package day11;

public class TV {
	
	String model;
	int size;
	int channel;
	
	TV(){}
	TV(String model, int size, int channel)
	{
		this.model = model;
		this.size = size;
		this.channel = channel;
	}
	
	public void channelUp()
	{
		if(getChannel() + 1 > 10)
			setChannel(1);
		else
			setChannel(getChannel() + 1);
	}
	
	public void channelDown()
	{
		if(getChannel() - 1 < 1)
			setChannel(10);
		else
			setChannel(getChannel() - 1);		
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}


	
}
