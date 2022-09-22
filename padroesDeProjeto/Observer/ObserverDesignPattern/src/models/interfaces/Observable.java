package models.interfaces;

public interface Observable {
	
	public void notificarObservers();
	public void addObserver(Observer observer);
}
