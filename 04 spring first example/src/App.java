public class App {

    DBInterface db;

    public App(DBInterface db) {
        this.db = db;
    }

    public void connectToDB() {
        db.connect();
    }
}
