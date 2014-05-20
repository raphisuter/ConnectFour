/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour.ui.searchServer;

import connectfour.ui.util.CenterWindowUtil;
import connectfour.ui.util.Icon;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Markus
 */
public class SearchServerView {
    
    private JFrame frame;
    private final String FRAME_TITLE = "Search Server";
    
    private JLabel textLabel;
    private final String LABEL_TEXT = "Verfügbare Server:";
    
    private JButton actual;
    private final String BUTTON_ACTUAL = "Aktualisieren";
    
    private JButton connect;
    private final String BUTTON_CONNECT = "Verbinden";
    
    private JButton back;
    private final String BUTTON_BACK = "Zurück";
    
    private JList list;
    
    
public SearchServerView(Object[] ips){
    
    createFrame();
    
    createTextLabel();
    createActualButton();
    createList(ips);
    createConnectButton();
    createBackButton();
    
    createLayout();
    setupLayout();
    
}

 public void show() {
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
        frame.dispose();
    }
 
private void createFrame() {
        frame = new JFrame(FRAME_TITLE);
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CenterWindowUtil.center(frame);
        frame.setResizable(false);
        frame.setIconImages(Icon.getIconListGamepad());
}

private void createLayout() {
        frame.setLayout(null);
    }

private void setupLayout() {
        

        textLabel.setBounds(50, 20, 200, 30);
        
        list.setBounds(50, 60, 365, 250);
        
        connect.setBounds(240, 320, 170, 30);

        back.setBounds(50, 320, 150, 30);
        
        actual.setBounds(180, 20, 150, 30);
       

        frame.getContentPane().add(textLabel);
        
        frame.getContentPane().add(list);
        
        frame.getContentPane().add(connect);
        frame.getContentPane().add(back);
        frame.getContentPane().add(actual);
        
       
        

    }

    private void createList(Object[] ips){
        list = new JList(ips);
        
    }

    private void createTextLabel() {
        textLabel = new JLabel(LABEL_TEXT);
    }
    
    

    private void createConnectButton() {
        connect = new JButton(BUTTON_CONNECT);
        back = new JButton(BUTTON_BACK);
    }

    private void createBackButton() {
        back = new JButton(BUTTON_BACK);
    }
    
    
    
    private void createActualButton() {
        actual = new JButton(BUTTON_ACTUAL);
    }

    public void addActionConnectButton(ActionListener Listener) {
        connect.addActionListener(Listener);
    }

    public void addActionListenerBackButton(ActionListener Listener) {
        back.addActionListener(Listener);
    }
    
    public void addActionListenerActualButton(ActionListener Listener) {
        actual.addActionListener(Listener);
    }
    
   public void addListSelectionListener(ListSelectionListener listener)  {
        list.addListSelectionListener(listener);
     }
   
   public void setIPadresses(Object[] ips){
       list.setListData(ips);
   }

   public String getSelectedIPaddress() {
       return (String) list.getSelectedValue();
   }

   
    
    


}
