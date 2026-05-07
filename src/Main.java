import controller.TaskController;
import view.TaskView;

public class Main {

    public static void main(String[] args) {

        TaskView view = new TaskView();
        TaskController controller = new TaskController(view);

        view.setVisible(true);
    }
}

