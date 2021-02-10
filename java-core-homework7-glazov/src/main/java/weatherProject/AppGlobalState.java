package weatherProject;

public class AppGlobalState {

    private static AppGlobalState instance;

    private String cityKey;

    public String getCityKey() {
        return cityKey;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }

    public String getApiKey() {

       // return "iBdSz7vFYu9q9RUZHkKpqQ4jLsWy0oF1";  API от первого аккаунта
        return "foUcQALICuRLzXXM2TAG7GV7pO6WXKrV";
    }

    private AppGlobalState() {
    }

    public static AppGlobalState getInstance() {
        if (instance == null) {
            instance = new AppGlobalState();
        }
        return instance;
    }
}
