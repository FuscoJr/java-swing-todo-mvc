package controller;

import model.Task;
import model.TaskStatus;
import view.TaskView;

import javax.swing.*;
import java.awt.event.*;

public class TaskController {

    private TaskView view;

    public TaskController(TaskView view) {
        this.view = view;
        initController();
    }

    private void initController() {

        view.getAddButton().addActionListener(e -> {
            addTask();
        });

        view.getTaskInputField().addActionListener(e -> {
            addTask();
        });

        view.getDeleteButton().addActionListener(e -> {

            clearDoneTasks();
        });

        view.getTaskList().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {

                    toggleSelectedTask();
                }
            }
        });

        view.getShortcutItems().addActionListener(e -> {
            JOptionPane.showMessageDialog(
                    view,
                    """
                            SHORTCUTS
                            
                            Enter in TextField -> Add Task
                            Tab -> Navigate Components
                            Arrow Keys -> Navigate Task List
                            Enter in Task List -> Toggle Open/Done
                            Double Click -> Toggle Open/Done
                            Delete -> Remove Selected Task
                            Enter on Clear Done Button -> Remove All Done Tasks
                            """,
                    "Shortcuts",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        view.getTaskList().getInputMap().put(
                KeyStroke.getKeyStroke("DELETE"),
                "deleteSelectedTask"
        );

        view.getTaskList().getActionMap().put(
                "deleteSelectedTask",
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteSelectedTask();
                    }
                }
        );

        view.getTaskList().getInputMap().put(
                KeyStroke.getKeyStroke("ENTER"),
                "toggleSelectedTask"
        );

        view.getTaskList().getActionMap().put(
                "toggleSelectedTask",
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        toggleSelectedTask();
                    }
                }
        );


//        view.getDoneButton().addActionListener(e -> {
//
//            Task selectedTask = view.getTaskList().getSelectedValue();
//
//            if(selectedTask == null){
//                return;
//            }
//
//            int selectedIndex = view.getTaskList().getSelectedIndex();
//
//            selectedTask.setStatus(TaskStatus.DONE);
//
//            view.getListModel().setElementAt(selectedTask, selectedIndex);
//        });
    }

    private void addTask() {
        String title = view.getTaskInputField().getText().trim();

        if (title.isEmpty()) {
            return;
        }

        Task task = new Task(title);

        view.getListModel().addElement(task);
        view.getTaskInputField().setText("");

    }

    private void deleteSelectedTask() {
        Task selectedTask = view.getTaskList().getSelectedValue();

        if (selectedTask == null) {
            return;
        }

        view.getListModel().removeElement(selectedTask);
    }

    private void toggleSelectedTask() {
        Task selectedTask = view.getTaskList().getSelectedValue();

        if (selectedTask == null) {
            return;
        }

        if (selectedTask.getStatus() == TaskStatus.OPEN) {
            selectedTask.setStatus(TaskStatus.DONE);
        } else {
            selectedTask.setStatus(TaskStatus.OPEN);
        }

        int selectedIndex = view.getTaskList().getSelectedIndex();

        view.getListModel().setElementAt(selectedTask, selectedIndex);
    }

    private void clearDoneTasks() {
        for (int i = view.getListModel().size() - 1; i >= 0; i--) {
            Task task = view.getListModel().get(i);

            if (task.getStatus().equals(TaskStatus.DONE)) {
                view.getListModel().removeElementAt(i);
            }
        }
    }
}
