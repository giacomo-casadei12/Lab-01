package bbomvc;

public interface Controller {

    void increment();

    void registerView(View view);

    void spreadChanges(int newValue);
}
