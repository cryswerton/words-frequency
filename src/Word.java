
public class Word {
	
	private String name;
	private int frequency;
	
	public Word(String name) {
		super();
		this.name = name;
		this.frequency = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	
}
