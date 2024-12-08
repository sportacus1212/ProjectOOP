package DBPakage;

import enums.LevelOfRequest;
import models.Admin;

public class Request<T> {
	private static int requestId = 0;
	private String comment;
	private boolean signed;
	private LevelOfRequest level;
	private T obj;
	
	
	public Request(String comment, LevelOfRequest level) {
		this.comment = comment;
		this.level = level;
		requestId++;
	}
	
	public Request(String comment, LevelOfRequest level, T obj) {
		this.comment = comment;
		this.level = level;
		this.obj = obj;
		requestId++;
	}
	
	
	public void sendRequest(Admin a) {
		a.getRequest(this);
		try {
			System.out.print("Status of sending . ");
			Thread.sleep(1000);
			System.out.print(". ");
			Thread.sleep(1000);
			System.out.println(". ");
			Thread.sleep(1000);
			System.out.print("Massage successfully sended!!!");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	//Getters
	public T getObj() {
		return obj;
	}
	
	public LevelOfRequest getLevel() {
		return level;
	}
	

	@Override
	public String toString() {
		return "Request [comment=" + comment + ", signed=" + signed + ", level=" + level + ", obj=" + obj + "]";
	}

	
	
	
	
}
