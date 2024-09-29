package bbormi;

public class ModelImpl implements Model {

    private int state = 0;
    private Controller controller;

    @Override
    public void attachController(Controller controller) {
        this.controller = this.controller == null ? controller : this.controller;
    }

    @Override
    public int addValue(int value) {
        this.state = this.state + value;
        return this.state;
    }
}
