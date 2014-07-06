package eventmanager.events;

public interface IEvent{
	public void registerID(Object id);
	public Object pullID();
	public boolean validate(Object id);
	public void run();
}
