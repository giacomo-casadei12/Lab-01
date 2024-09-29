package bbomvc;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {

    Model model;
    List<View> views = new ArrayList<>();
    final int BASE_INCREMENT = 1;

    public ControllerImpl(Model model) {
        this.model = model;
        this.model.attachController(this);
    }

    @Override
    public void increment() {
        this.model.addValue(BASE_INCREMENT);
    }

    @Override
    public void registerView(View view) {
        views.add(view);
    }

    @Override
    public void spreadChanges(int newValue) {
        this.views.forEach(view -> view.updateView(newValue));
    }
}
