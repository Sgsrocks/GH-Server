package godzhell;

public enum ServerState {

	PUBLIC_PRIMARY(5555), PUBLIC_SECONDARY(5555), PRIVATE(5555);

	private int port;

	ServerState(int port) {
		this.port = port;
	}

	public int getPort() {
		return port;
	}

}
