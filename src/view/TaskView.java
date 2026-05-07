package view;

import model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TaskView extends JFrame {

    //    COMPONENTS
    private JTextField taskInputField;
    private JButton addButton;
    private JButton deleteButton;
    private JMenuBar menuBar;
    private JMenu helpMenu;
    private JMenuItem shortcutItems;
    //    private JButton doneButton;
    private JList<Task> taskList;
    private DefaultListModel<Task> listModel;

    public TaskView() {
        init();
    }

    private void init() {

//        FRAME
        setTitle("Todo App MVC");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

//        LIST MODEL
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setToolTipText("Double click a task to toggle Open/Done");
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//        FOCUS
        taskList.setFocusable(true);

//        INPUT FIELD
        taskInputField = new JTextField();
        taskInputField.setToolTipText("Write a task and press Enter or Add");

//        BUTTONS
        addButton = new JButton("Add");
        deleteButton = new JButton("Clear Done");
        deleteButton.getInputMap(JComponent.WHEN_FOCUSED).put(
                KeyStroke.getKeyStroke("ENTER"),
                "pressed"
        );

        deleteButton.getActionMap().put(
                "pressed", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteButton.doClick();
                    }
                });

        deleteButton.setToolTipText("Remove all tasks marked as Done");
//        doneButton = new JButton("Done");

//        PANELS
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.add(taskInputField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(deleteButton);
//        bottomPanel.add(doneButton);

        JScrollPane scrollPane = new JScrollPane(taskList);

//        ADD PANE TO FRAME
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

//        MENU BAR
        menuBar = new JMenuBar();
        helpMenu = new JMenu("Help");
        shortcutItems = new JMenuItem("Shortcuts");
        helpMenu.add(shortcutItems);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

    }

//    GETTERS

    public JTextField getTaskInputField() {
        return taskInputField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JList<Task> getTaskList() {
        return taskList;
    }

    public DefaultListModel<Task> getListModel() {
        return listModel;
    }

    public JMenuItem getShortcutItems() {
        return shortcutItems;
    }

    //    public JButton getDoneButton() {
//        return doneButton;
//    }
}
