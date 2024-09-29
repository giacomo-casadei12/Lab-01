package bbomvc;

public class ModelImpl implements Model{

    private int state = 0;
    private Controller controller;

    @Override
    public void attachController(Controller controller) {
        this.controller = this.controller == null ? controller : this.controller;
    }

    @Override
    public void addValue(int value) {
        this.state = this.state + value;
        this.controller.spreadChanges(this.state);
    }
}
