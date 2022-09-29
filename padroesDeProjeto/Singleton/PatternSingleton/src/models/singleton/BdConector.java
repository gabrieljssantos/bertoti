package models.singleton;

public class BdConector {

	private static BdConector connection = null;

	private BdConector() {}

	public static BdConector bdConnection() {
		if (connection == null) {
			connection = new BdConector();
		}
		return connection;
	}

}