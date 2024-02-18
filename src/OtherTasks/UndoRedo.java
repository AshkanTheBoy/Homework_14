package OtherTasks;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class UndoRedo extends JFrame {
    List<String> commands = Arrays.asList("Open", "Edit", "Save", "Quit", "Copy",
            "Paste", "Insert", "Append", "Delete", "Move");
    private Deque<String> history = new ArrayDeque<>();
    private JList<String> list;
    private int index = 0;

    public static void main(String[] args) {
        UndoRedo undoRedo = new UndoRedo();
    }

    public UndoRedo(){
        setVisible(true);
        setTitle("Commands History");
        setResizable(false);
        setSize(600, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultListModel<String> model = new DefaultListModel<>();
        list = new JList<>(model);

        list.setBounds(300, 20, 200, 300);
        add(list);
        setLayout(null);
        repaint();

        JButton bUndo = new JButton();
        add(bUndo);
        bUndo.setText("Undo");
        bUndo.setBounds(200, 340, 80, 25);
        bUndo.addActionListener(new UndoListener());


        JButton bRedo = new JButton();
        add(bRedo);
        bRedo.setText("Redo");
        bRedo.setBounds(300, 340, 80, 25);
        bRedo.addActionListener(new RedoListener());


        for (int i = 0; i < commands.size(); i++) {
            JButton button = new JButton();
            add(button);
            button.setText(commands.get(i));
            button.setBounds(10, 20 + i * 30, 200, 25);
            String s = commands.get(i);
            button.addActionListener(e -> {
                if (history.size() >= 5)
                    history.pollLast();
                history.addFirst(s);
                model.clear();
                Object[] items = history.toArray();
                String[] sitems = Arrays.copyOf(items, items.length, String[].class);
                model.addAll(Arrays.asList(sitems));
                ListSelectionModel sm = list.getSelectionModel();
                sm.clearSelection();                     // clears the selection
                sm.setSelectionInterval(0, 0);
            });

        }
        validate();


    }

    class UndoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ListSelectionModel sm = list.getSelectionModel();
            int count = list.getModel().getSize();
            index++;
            if (index>count-1) index = count-1;
            System.out.println(index);
            sm.clearSelection();                     // clears the selection
            sm.setSelectionInterval(index, index);
        }
    }

    class RedoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ListSelectionModel sm = list.getSelectionModel();
            index--;
            if (index<0) index = 0;
            System.out.println(index);
            sm.clearSelection();                     // clears the selection
            sm.setSelectionInterval(index, index);
        }
    }




}