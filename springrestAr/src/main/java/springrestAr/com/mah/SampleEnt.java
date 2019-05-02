package springrestAr.com.mah;

import org.springframework.stereotype.Component;

@Component
public class SampleEnt {

	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SampleEnt [id=" + id + ", name=" + name + "]";
	}
	
}
