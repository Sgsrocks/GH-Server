package godzhell.event;

public interface Event2 {
    /**
     * Called when the event is executed.
     *
     * @param container
     *            The event container, so the event can dynamically change the
     *            tick time etc.
     */
    public void execute(EventContainer container);

}
