//Created by Ryan Severe and Sean Forman
package minirpg;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TabGUI extends JFrame {
    
    //creates tabbed pane for tabs to attach to
    static JTabbedPane jtp = new JTabbedPane();
    
    //declare panels to create tabs
    static PlayerClassPanel PCP = new PlayerClassPanel();
    static PlayerSummeryPanel PSUMP = new PlayerSummeryPanel();
    SetPlayerInfo PSP = new SetPlayerInfo();
    SingleSelectionModel model;
    int index;
    String Role, Class, Skill1, Skill2, Skill3, Skill4;
    int count  = 0;
    
    public static ArrayList<ComboSelection> comboSelection = new ArrayList<ComboSelection>();
    
    public TabGUI()
    {
        Container canvas = getContentPane();  //declare the container to hold the tabs/panels
        canvas.add(jtp);
        
        //add the panels to frames container
        jtp.addTab("Player Class", null, PCP, "Class Selection");
        jtp.addTab("Player Stat", null, PSP, "Player Stats");
        jtp.addTab("Player Summery", null, PSUMP, "Summery");
        this.setTitle("Player Creation");
        
    }
    
    static void activateSummeryPanel()
    {
        jtp.setEnabledAt(2, true);
        SummerySelected();
    }
    
    static void activateStatPanel()
    {
        jtp.setEnabledAt(1, true);
    }
    
    static void activateCreationpanels()
    {
        jtp.setEnabledAt(0, true);
        jtp.setEnabledAt(1, true);
    }
    
    static void activateClassPanel()
    {
        jtp.setEnabledAt(0, true);
    }
    
    static void disableClassPanel()
    {
        jtp.setEnabledAt(0, false);
    }
    
    static void disableSummeryPanel()
    {
        jtp.setEnabledAt(2, false);
        
    }
    
    static void disableStatPanel()
    {
        jtp.setEnabledAt(1, false);
    }
    
    static void disableCreationPanels()
    {
        jtp.setEnabledAt(0, false);
        jtp.setEnabledAt(1, false);
    }
    
    static void SummerySelected()
    {
        int x = 0, y = 1;
        int count = 0;
        PSUMP.Players[0] = "Select Player";
        while(count <= MiniRPG.players.size() - 1)
            {
                
                PSUMP.Players[y] = MiniRPG.players.get(x).getName();
                x++;
                y ++;
                count++;
            }
        PSUMP.comboPlayerList.setModel(new DefaultComboBoxModel(PSUMP.Players));
        jtp.setSelectedIndex(2);
        disableCreationPanels();
    }
    
    static void returntoClassPanel()
    {
        jtp.setEnabledAt(1, false);
        jtp.setSelectedIndex(0);
    }
    
    static void FowardStatPanel()
    {
        jtp.setSelectedIndex(1);
    }
    
    static void resetCombo()
    {
        PCP.comboRole.setSelectedItem(PCP.roles[0]);
    }
    
    public int GetSelectedTab()
    {
        index = jtp.getSelectedIndex();
        return index;
    }
    
    private void SetSelctedTab()
    {
        this.index = index;
    }
    
    public String getRole(int num) 
    {
        Role = comboSelection.get(num).getRole();
        return Role;
    }
    
    public String getclass(int num)
    {
        Class = comboSelection.get(num).getclass();
        return Class;
    }
    
    public String getSkill1(int num)
    {
        Skill1 = comboSelection.get(num).getSkill1();
        return Skill1;
    }
    
    public String getSkill2(int num)
    {
        Skill2 = comboSelection.get(num).getSkill2();
        return Skill2;
    }
    
    public String getSkill3(int num)
    {
        Skill3 = comboSelection.get(num).getSkill3();
        return Skill3;
    }
    
    public String getSkill4(int num)
    {
        Skill4 = comboSelection.get(num).getSkill4();
        return Skill4;
    }
    
    
}
