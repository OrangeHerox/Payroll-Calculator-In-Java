package paycalc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.PrintWriter;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

@SuppressWarnings("unchecked")
public class PayCalc {

    JFrame mainframe, othersframe, resultframe, histoframe;
    JPanel mainpanel, sidepanel, toppanel, midpanel, botpanel, otherspanel;
    JPanel ressidepanel, resmainpanel, restoppanel, ressubmainpanel;
    JLabel pclbl, inputlbl, namelbl, ratelbl, dowlbl, contriblbl, ssslbl, pagiblbl, phlbl;
    JLabel taxlbl, otlbl, otratelbl, otherslbl, org1lbl, org2lbl, org3lbl;
    JLabel resultlbl, resinputlbl, resnamelbl, resdatelbl, resline, resline2;
    JLabel grosslbl, netlbl, totaldedcont, resotherslbl, resssslbl, respagiblbl, resphlbl;
    JLabel pagibval, phval, orgded1, orgded2, orgded3, otherdedlbl;
    JTextField nametxt, ratetxt, dowtxt, ssstxt, pagibtxt, phtxt, otherdedtxt;
    JTextField ottxt, otratetxt, org1txt, org2txt, org3txt, orgded1txt, orgded2txt, orgded3txt;
    JTextField resnametxt, resdatetxt, grosstxt, nettxt, totaldedconttxt, resotherstxt, resssstxt, respagibtxt, resphtxt;
    JButton othersbtn, calcbtn, historybtn, exitbtn, clearbtn;
    JButton continuebtn, cancelbtn, reshistorybtn, resexitbtn, printbtn, addcalcbtn;
    JComboBox ratecb, ssscb;
    JCheckBox manualcheck;
    JTextArea calculate1txta, histo1ta, histo2ta, histo3ta, histo4ta, histo5ta;
    JPanel histomainpanel, histosubpanel, histotoppanel;
    JLabel histolbl;
    JButton histobackbtn, moveleftbtn, moverightbtn;

    Date date;
    SimpleDateFormat formatter;
    String str;

    String[] ratecombo = {"PER HOUR", "PER DAY"};
    String[] ssscombo = {"11", "3.63", "7.33"};
    String name, strdow, strot, sssStr;

    double gross, net, totaldedcontrib, manualded, automated, allded, otrate, rate;
    int ot, dow, countercheck, maincount, rescount, histocounter, filecounter;
    double org1val, org2val, org3val, othersded, sssval2, pagibval2, phval2;
    double sssval1, pagibval1, phval1, sssval3, pagibval3, phval3;

    public PayCalc() {
        mainframe = new JFrame();
        mainpanel = new JPanel();
        sidepanel = new JPanel();
        toppanel = new JPanel();
        botpanel = new JPanel();
        midpanel = new JPanel();
        pclbl = new JLabel();
        namelbl = new JLabel();
        ratelbl = new JLabel();
        dowlbl = new JLabel();
        nametxt = new JTextField();
        ratetxt = new JTextField();
        dowtxt = new JTextField();
        contriblbl = new JLabel();
        ssslbl = new JLabel();
        pagiblbl = new JLabel();
        phlbl = new JLabel();
        ssstxt = new JTextField();
        pagibtxt = new JTextField();
        phtxt = new JTextField();
        othersbtn = new JButton();
        taxlbl = new JLabel();
        calcbtn = new JButton();
        inputlbl = new JLabel();
        historybtn = new JButton();
        exitbtn = new JButton();
        clearbtn = new JButton();
        ratecb = new JComboBox(ratecombo);
        otlbl = new JLabel();
        otratelbl = new JLabel();
        ottxt = new JTextField();
        otratetxt = new JTextField();
        ssscb = new JComboBox(ssscombo);
        pagibval = new JLabel();
        phval = new JLabel();
        manualcheck = new JCheckBox();

        //others
        othersframe = new JFrame();
        otherspanel = new JPanel();
        otherslbl = new JLabel();
        org1lbl = new JLabel();
        org2lbl = new JLabel();
        org3lbl = new JLabel();
        org1txt = new JTextField();
        org2txt = new JTextField();
        org3txt = new JTextField();
        orgded1 = new JLabel();
        orgded2 = new JLabel();
        orgded3 = new JLabel();
        orgded1txt = new JTextField();
        orgded2txt = new JTextField();
        orgded3txt = new JTextField();
        continuebtn = new JButton();
        cancelbtn = new JButton();
        otherdedlbl = new JLabel();
        otherdedtxt = new JTextField();

        //resultframe
        resinputlbl = new JLabel();
        reshistorybtn = new JButton();
        resexitbtn = new JButton();
        resultlbl = new JLabel();
        resultframe = new JFrame();
        ressidepanel = new JPanel();
        resmainpanel = new JPanel();
        restoppanel = new JPanel();
        ressubmainpanel = new JPanel();
        resnamelbl = new JLabel();
        resdatelbl = new JLabel();
        resline = new JLabel();
        resline2 = new JLabel();
        grosslbl = new JLabel();
        netlbl = new JLabel();
        totaldedcont = new JLabel();
        resotherslbl = new JLabel();
        resssslbl = new JLabel();
        respagiblbl = new JLabel();
        resphlbl = new JLabel();
        resnametxt = new JTextField();
        resdatetxt = new JTextField();
        grosstxt = new JTextField();
        nettxt = new JTextField();
        totaldedconttxt = new JTextField();
        resotherstxt = new JTextField();
        resssstxt = new JTextField();
        respagibtxt = new JTextField();
        resphtxt = new JTextField();
        printbtn = new JButton();
        addcalcbtn = new JButton();
        calculate1txta = new JTextArea();

        date = new Date();
        formatter = new SimpleDateFormat("dd/MM/yy");
        str = formatter.format(date);

        //history panel
        histoframe = new JFrame();
        histomainpanel = new JPanel();
        histosubpanel = new JPanel();
        histotoppanel = new JPanel();
        histolbl = new JLabel();
        histobackbtn = new JButton();
        moveleftbtn = new JButton();
        moverightbtn = new JButton();
        histo1ta = new JTextArea();
        histo2ta = new JTextArea();
        histo3ta = new JTextArea();
        histo4ta = new JTextArea();
        histo5ta = new JTextArea();
        maincount = 0;
        rescount = 0;
        histocounter = 0;

        //values
        name = "";
        strdow = "";
        rate = 0;
        otrate = 0;
        strot = "";
        gross = 0;
        net = 0;
        totaldedcontrib = 0;
        manualded = 0;
        automated = 0;
        allded = 0;
        ot = 0;
        dow = 0;
        othersded = 0;
        org1val = 0;
        org2val = 0;
        org3val = 0;
        othersded = 0;
        sssval2 = 0;
        pagibval2 = 0;
        phval2 = 0;
        sssval1 = 0;
        pagibval1 = 0;
        phval1 = 0;
        sssval3 = 0;
        pagibval3 = 0;
        phval3 = 0;
        sssStr = "";
        countercheck = 0;

        //MAKING A FILECOUNTER FILE
        filecounter = 0;
        File obj = new File("filecounter.txt");
        PrintWriter outp = null;
        try {
            if (obj.createNewFile()) {
                if (filecounter == 0) {
                    try {
                        String outt = "filecounter.txt";
                        outp = new PrintWriter(new FileWriter(outt));
                        outp.println(filecounter);
                        outp.close();
                    } catch (Exception A) {
                        System.out.println("ERROR WRITING DATA ON FILECOUNTER");
                    }

                    System.out.println("FILECOUNTER CREATED!");
                }
            } else {
                System.out.println("FILECOUNTER ALREADY EXIST!");
            }
        } catch (IOException j) {
            System.out.println("AN ERROR OCCURED.");
            //j.printStackTrace();
        }

        //GETTING DATA ON FILE COUNTER AND ASSIGNING TO VALUE
        BufferedReader input = null;
        String a = "";
        String in = "fIlecounter.txt";
        try {
            input = new BufferedReader(new FileReader(in));
            a = input.readLine();
            input.close();
        } catch (Exception e) {
            System.out.println("ERROR GETTING VALUE IN FILECOUNTER FILE");
        }
        filecounter = Integer.parseInt(a);

        //for validating inputs
        ratetxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!(Character.isDigit(input) || input == '.')) {
                    e.consume();
                }
            }
        });

        ottxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!(Character.isDigit(input) || input == '.')) {
                    e.consume();
                }
            }
        });

        dowtxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!(Character.isDigit(input))) {
                    e.consume();
                }
            }
        });

        otratetxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!(Character.isDigit(input))) {
                    e.consume();
                }
            }
        });

        orgded1txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!(Character.isDigit(input) || input == '.')) {
                    e.consume();
                }
            }
        });

        orgded2txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!(Character.isDigit(input) || input == '.')) {
                    e.consume();
                }
            }
        });

        orgded3txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!(Character.isDigit(input) || input == '.')) {
                    e.consume();
                }
            }
        });

        ssstxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!(Character.isDigit(input) || input == '.')) {
                    e.consume();
                }
            }
        });

        pagibtxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!(Character.isDigit(input) || input == '.')) {
                    e.consume();
                }
            }
        });

        phtxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char input = e.getKeyChar();
                if (!(Character.isDigit(input) || input == '.')) {
                    e.consume();
                }
            }
        });

    }

    public void setGUI() {
        //CHECKBOX
        manualcheck.setText("MANUAL INPUT");
        manualcheck.setBounds(550, 5, 120, 30);

        //LABEL2      
        phval.setText("3.50% of INCOME");
        phval.setBounds(860, 390, 300, 100);
        phval.setForeground(Color.WHITE);
        phval.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        pagibval.setText("100");
        pagibval.setBounds(640, 390, 300, 100);
        pagibval.setForeground(Color.WHITE);
        pagibval.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        //COMBOBOX
        ratecb.setBounds(770, 205, 90, 30);
        ssscb.setBounds(405, 425, 90, 30);

        //BUTTON
        othersbtn.setText("OTHERS");
        othersbtn.setBounds(350, 470, 120, 30);
        othersbtn.setBackground(new Color(153, 0, 0));
        othersbtn.setForeground(Color.white);
        othersbtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        calcbtn.setText("CALCULATE");
        calcbtn.setBounds(460, 510, 300, 40);
        calcbtn.setBackground(new Color(0, 103, 0));
        calcbtn.setForeground(Color.white);
        calcbtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        clearbtn.setText("RESET");
        clearbtn.setBounds(870, 510, 80, 40);
        clearbtn.setBackground(new Color(153, 0, 0));
        clearbtn.setForeground(Color.white);
        clearbtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        historybtn.setText("HISTORY");
        historybtn.setBounds(0, 185, 300, 80);
        historybtn.setBackground(null);
        historybtn.setForeground(Color.DARK_GRAY);
        historybtn.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        exitbtn.setText("EXIT");
        exitbtn.setBounds(20, 510, 100, 40);
        exitbtn.setBackground(Color.DARK_GRAY/*new Color(153,0,0)*/);
        exitbtn.setForeground(Color.white);
        exitbtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        //LABEL
        otherdedlbl.setText("OTHER : ");
        otherdedlbl.setBounds(550, 430, 300, 100);
        otherdedlbl.setForeground(Color.WHITE);
        otherdedlbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        otherdedlbl.setVisible(false);

        inputlbl.setText("           INPUT ");
        inputlbl.setBounds(0, 85, 300, 80);
        inputlbl.setBackground(Color.DARK_GRAY);
        inputlbl.setForeground(Color.WHITE);
        inputlbl.setOpaque(true);
        inputlbl.setFont(new Font("Times New Roman", Font.PLAIN, 35));

        otlbl.setText("NUMBER OF OVER TIME : ");
        otlbl.setBounds(350, 260, 250, 100);
        otlbl.setForeground(Color.WHITE);
        otlbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        otratelbl.setText("OVER TIME RATE : ");
        otratelbl.setBounds(700, 215, 300, 100);
        otratelbl.setForeground(Color.WHITE);
        otratelbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        phlbl.setText("PHIL-HEALTH : ");
        phlbl.setBounds(720, 390, 300, 100);
        phlbl.setForeground(Color.WHITE);
        phlbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        pagiblbl.setText("PAG-IBIG : ");
        pagiblbl.setBounds(530, 390, 300, 100);
        pagiblbl.setForeground(Color.WHITE);
        pagiblbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        ssslbl.setText("SSS : ");
        ssslbl.setBounds(350, 390, 300, 100);
        ssslbl.setForeground(Color.WHITE);
        ssslbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        contriblbl.setText("CONTRIBUTIONS");
        contriblbl.setBounds(200, -25, 700, 100);
        contriblbl.setForeground(Color.DARK_GRAY);
        contriblbl.setFont(new Font("Times New Roman", Font.PLAIN, 35));

        dowlbl.setText("DAYS/HOURS OF WORK :");
        dowlbl.setBounds(350, 215, 300, 100);
        dowlbl.setForeground(Color.WHITE);
        dowlbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        ratelbl.setText("RATE : ");
        ratelbl.setBounds(700, 170, 300, 100);
        ratelbl.setForeground(Color.WHITE);
        ratelbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        namelbl.setText("NAME : ");
        namelbl.setBounds(350, 170, 300, 100);
        namelbl.setForeground(Color.WHITE);
        namelbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        pclbl.setText("PAYROLL CALCULATOR");
        pclbl.setBounds(20, 5, 700, 100);
        pclbl.setForeground(Color.WHITE);
        pclbl.setFont(new Font("Times New Roman", Font.PLAIN, 55));

        //TEXT
        otherdedtxt.setBounds(640, 465, 70, 30);
        otherdedtxt.setBackground(Color.WHITE);
        otherdedtxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        otherdedtxt.setVisible(false);
        otherdedtxt.setEditable(false);

        ottxt.setBounds(890, 247, 50, 30);
        ottxt.setBackground(Color.WHITE);
        ottxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        otratetxt.setBounds(590, 290, 50, 30);
        otratetxt.setBackground(Color.WHITE);
        otratetxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        phtxt.setBounds(865, 425, 50, 30);
        phtxt.setBackground(Color.WHITE);
        phtxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        phtxt.setVisible(false);

        pagibtxt.setBounds(640, 425, 50, 30);
        pagibtxt.setBackground(Color.WHITE);
        pagibtxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        pagibtxt.setVisible(false);

        ssstxt.setBounds(410, 425, 50, 30);
        ssstxt.setBackground(Color.WHITE);
        ssstxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        nametxt.setBounds(430, 205, 210, 30);
        nametxt.setBackground(Color.WHITE);
        nametxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        ratetxt.setBounds(870, 205, 70, 30);
        ratetxt.setBackground(Color.WHITE);
        ratetxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        dowtxt.setBounds(590, 250, 50, 30);
        dowtxt.setBackground(Color.WHITE);
        dowtxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        //PANELS
        mainpanel.setBounds(0, 0, 1000, 600);
        mainpanel.setBackground(Color.DARK_GRAY);
        sidepanel.setBounds(0, 0, 300, 600);
        sidepanel.setBackground(Color.orange);
        toppanel.setBounds(300, 70, 700, 100);
        toppanel.setBackground(new Color(153, 0, 0));
        midpanel.setBounds(300, 345, 700, 45);
        midpanel.setBackground(Color.LIGHT_GRAY);

        //LAYOUT
        toppanel.setLayout(null);
        mainpanel.setLayout(null);
        sidepanel.setLayout(null);
        midpanel.setLayout(null);

        //ADDING TO PANEL/FRAME
        mainpanel.add(otherdedlbl);
        mainpanel.add(otherdedtxt);
        midpanel.add(manualcheck);

        mainpanel.add(pagibval);
        mainpanel.add(phval);

        mainpanel.add(ssscb);
        mainpanel.add(ottxt);
        mainpanel.add(otratetxt);
        mainpanel.add(otlbl);
        mainpanel.add(otratelbl);

        mainpanel.add(ratecb);

        sidepanel.add(inputlbl);
        sidepanel.add(historybtn);
        sidepanel.add(exitbtn);

        //botpanel.add(taxlbl);
        toppanel.add(pclbl);
        midpanel.add(contriblbl);

        mainpanel.add(othersbtn);
        mainpanel.add(clearbtn);
        mainpanel.add(calcbtn);

        mainpanel.add(phlbl);
        mainpanel.add(phtxt);

        mainpanel.add(pagiblbl);
        mainpanel.add(pagibtxt);

        mainpanel.add(ssslbl);
        mainpanel.add(ssstxt);

        mainpanel.add(dowtxt);
        mainpanel.add(dowlbl);

        mainpanel.add(ratetxt);
        mainpanel.add(ratelbl);

        mainpanel.add(namelbl);
        mainpanel.add(nametxt);

        mainframe.add(botpanel);
        mainframe.add(midpanel);
        mainframe.add(toppanel);
        mainframe.add(sidepanel);
        mainframe.add(mainpanel);

        mainframe.setLayout(null);
        mainframe.setTitle("PAYROL CALCULATOR");
        mainframe.setSize(1000, 600);
        mainframe.setResizable(false);
        mainframe.setLocationRelativeTo(null);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setVisible(true);
    }

    public void setHistoryGUI() {
        histo5ta.setText("");
        histo5ta.setBounds(25, 40, 550, 350);
        histo5ta.setEditable(false);
        histo5ta.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        histo5ta.setVisible(false);

        histo4ta.setText("");
        histo4ta.setBounds(25, 40, 550, 350);
        histo4ta.setEditable(false);
        histo4ta.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        histo4ta.setVisible(false);

        histo3ta.setText("");
        histo3ta.setBounds(25, 40, 550, 350);
        histo3ta.setEditable(false);
        histo3ta.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        histo3ta.setVisible(false);

        histo2ta.setText("");
        histo2ta.setBounds(25, 40, 550, 350);
        histo2ta.setEditable(false);
        histo2ta.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        histo2ta.setVisible(false);

        histo1ta.setText("");
        histo1ta.setBounds(25, 40, 550, 350);
        histo1ta.setEditable(false);
        histo1ta.setFont(new Font("Times New Roman", Font.PLAIN, 15));
  
        moverightbtn.setText(" > ");
        moverightbtn.setBounds(25, 400, 50, 30);
        moverightbtn.setBackground(new Color(0, 103, 0));
        moverightbtn.setForeground(Color.white);
        moverightbtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        moveleftbtn.setText(" < ");
        moveleftbtn.setBounds(25, 400, 50, 30);
        moveleftbtn.setBackground(new Color(0, 103, 0));
        moveleftbtn.setForeground(Color.white);
        moveleftbtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        moveleftbtn.setVisible(false);

        histobackbtn.setText("BACK");
        histobackbtn.setBounds(570, 520, 100, 30);
        histobackbtn.setBackground(new Color(153, 0, 0));
        histobackbtn.setForeground(Color.white);
        histobackbtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        histolbl.setText("CALCULATION HISTORY");
        histolbl.setBounds(10, -25, 700, 100);
        histolbl.setForeground(Color.WHITE);
        histolbl.setFont(new Font("Times New Roman", Font.PLAIN, 25));

        histosubpanel.setLayout(null);
        histotoppanel.setLayout(null);
        histomainpanel.setLayout(null);
        histoframe.setLayout(null);

        histosubpanel.add(histo5ta);
        histosubpanel.add(histo4ta);
        histosubpanel.add(histo3ta);
        histosubpanel.add(histo2ta);
        histosubpanel.add(histo1ta);

        histosubpanel.add(moverightbtn);
        histosubpanel.add(moveleftbtn);
        histomainpanel.add(histobackbtn);
        histotoppanel.add(histolbl);
        histomainpanel.add(histosubpanel);
        histomainpanel.add(histotoppanel);
        histoframe.add(histomainpanel);

        histosubpanel.setBounds(50, 60, 600, 450);
        histosubpanel.setBackground(Color.LIGHT_GRAY);
        histotoppanel.setBounds(0, 0, 700, 50);
        histotoppanel.setBackground(new Color(153, 0, 0));
        histomainpanel.setBounds(0, 0, 700, 600);
        histomainpanel.setBackground(Color.DARK_GRAY);

        histoframe.setLayout(null);
        histoframe.setTitle("CALCULATION HISTORY");
        histoframe.setSize(700, 600);
        histoframe.setResizable(false);
        histoframe.setLocationRelativeTo(mainframe);
        histoframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        histoframe.setVisible(false);
    }

    public void setOtherGUI() {
        //othersframe
        //others buttton
        continuebtn.setText("CONTINUE");
        continuebtn.setBounds(350, 470, 120, 30);
        continuebtn.setBackground(new Color(0, 103, 0)/*new Color(153,0,0)*/);
        continuebtn.setForeground(Color.white);
        continuebtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        cancelbtn.setText("CANCEL");
        cancelbtn.setBounds(200, 470, 120, 30);
        cancelbtn.setBackground(new Color(153, 0, 0));
        cancelbtn.setForeground(Color.white);
        cancelbtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));

        //otherstxt
        org1txt.setBounds(450, 135, 250, 30);
        org1txt.setBackground(Color.WHITE);
        org1txt.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        org2txt.setBounds(450, 235, 250, 30);
        org2txt.setBackground(Color.WHITE);
        org2txt.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        org3txt.setBounds(450, 335, 250, 30);
        org3txt.setBackground(Color.WHITE);
        org3txt.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        orgded1txt.setBounds(600, 175, 100, 30);
        orgded1txt.setForeground(Color.DARK_GRAY);
        orgded1txt.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        orgded2txt.setBounds(600, 275, 100, 30);
        orgded2txt.setForeground(Color.DARK_GRAY);
        orgded2txt.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        orgded3txt.setBounds(600, 375, 100, 30);
        orgded3txt.setForeground(Color.DARK_GRAY);
        orgded3txt.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        //otherslbl
        otherslbl.setText("OTHER DEDUCTIONS/CONTRIBUTIONS");
        otherslbl.setBounds(200, 15, 700, 100);
        otherslbl.setForeground(Color.ORANGE);
        otherslbl.setFont(new Font("Times New Roman", Font.PLAIN, 35));

        org1lbl.setText("ORGANIZATION 1 NAME : ");
        org1lbl.setBounds(200, 100, 300, 100);
        org1lbl.setForeground(Color.WHITE);
        org1lbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        org2lbl.setText("ORGANIZATION 2 NAME : ");
        org2lbl.setBounds(200, 200, 300, 100);
        org2lbl.setForeground(Color.WHITE);
        org2lbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        org3lbl.setText("ORGANIZATION 3 NAME : ");
        org3lbl.setBounds(200, 300, 300, 100);
        org3lbl.setForeground(Color.WHITE);
        org3lbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        orgded1.setText("DEDUCTION/CONTRIBUTION PER MONTH : ");
        orgded1.setBounds(200, 177, 400, 30);
        orgded1.setForeground(Color.WHITE);
        orgded1.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        orgded2.setText("DEDUCTION/CONTRIBUTION PER MONTH : ");
        orgded2.setBounds(200, 277, 400, 30);
        orgded2.setForeground(Color.WHITE);
        orgded2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        orgded3.setText("DEDUCTION/CONTRIBUTION PER MONTH : ");
        orgded3.setBounds(200, 377, 400, 30);
        orgded3.setForeground(Color.WHITE);
        orgded3.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        otherspanel.setLayout(null);

        otherspanel.add(continuebtn);
        otherspanel.add(cancelbtn);
        otherspanel.add(orgded1);
        otherspanel.add(orgded2);
        otherspanel.add(orgded3);
        otherspanel.add(orgded1txt);
        otherspanel.add(orgded2txt);
        otherspanel.add(orgded3txt);
        otherspanel.add(otherslbl);
        othersframe.add(otherspanel);
        otherspanel.add(org1lbl);
        otherspanel.add(org2lbl);
        otherspanel.add(org3lbl);
        otherspanel.add(org1txt);
        otherspanel.add(org2txt);
        otherspanel.add(org3txt);
        otherspanel.add(otherslbl);
        othersframe.add(otherspanel);

        otherspanel.setBounds(0, 0, 1000, 600);
        otherspanel.setBackground(Color.DARK_GRAY);

        othersframe.setLayout(null);
        othersframe.setTitle("OTHER DEDCUTIONS AND CONTRIBUTION");
        othersframe.setSize(1000, 600);
        othersframe.setResizable(false);
        othersframe.setLocationRelativeTo(null);
        othersframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setResultGUI() {
        //TEXTFIELDS

        resnametxt.setBounds(100, 20, 220, 30);
        resnametxt.setBackground(Color.WHITE);
        resnametxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        resnametxt.setEditable(false);

        resdatetxt.setBounds(500, 20, 100, 30);
        resdatetxt.setBackground(Color.WHITE);
        resdatetxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        resdatetxt.setEditable(false);

        grosstxt.setBounds(180, 90, 100, 20);
        grosstxt.setBackground(Color.WHITE);
        grosstxt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        grosstxt.setEditable(false);

        resssstxt.setBounds(180, 118, 100, 20);
        resssstxt.setBackground(Color.WHITE);
        resssstxt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        resssstxt.setEditable(false);

        respagibtxt.setBounds(180, 148, 100, 20);
        respagibtxt.setBackground(Color.WHITE);
        respagibtxt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        respagibtxt.setEditable(false);

        resphtxt.setBounds(180, 178, 100, 20);
        resphtxt.setBackground(Color.WHITE);
        resphtxt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        resphtxt.setEditable(false);

        resotherstxt.setBounds(180, 208, 100, 20);
        resotherstxt.setBackground(Color.WHITE);
        resotherstxt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        resotherstxt.setEditable(false);

        totaldedconttxt.setBounds(370, 245, 100, 30);
        totaldedconttxt.setBackground(Color.WHITE);
        totaldedconttxt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        totaldedconttxt.setEditable(false);

        nettxt.setBounds(530, 285, 100, 30);
        nettxt.setBackground(Color.WHITE);
        nettxt.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        nettxt.setEditable(false);

        //button
        printbtn.setText("PRINT");
        printbtn.setBounds(570, 520, 100, 30);
        printbtn.setBackground(new Color(0, 103, 0));
        printbtn.setForeground(Color.WHITE);
        printbtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        addcalcbtn.setText("+");
        addcalcbtn.setBounds(920, 520, 45, 30);
        addcalcbtn.setBackground(Color.ORANGE);
        addcalcbtn.setForeground(Color.DARK_GRAY);
        addcalcbtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        resexitbtn.setText("EXIT");
        resexitbtn.setBounds(20, 510, 100, 40);
        resexitbtn.setBackground(Color.DARK_GRAY/*new Color(153,0,0)*/);
        resexitbtn.setForeground(Color.white);
        resexitbtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        reshistorybtn.setText("HISTORY");
        reshistorybtn.setBounds(0, 185, 300, 80);
        reshistorybtn.setBackground(null);
        reshistorybtn.setForeground(Color.DARK_GRAY);
        reshistorybtn.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        //label
        resssslbl.setText("SSS :");
        resssslbl.setBounds(20, 80, 800, 100);
        resssslbl.setForeground(Color.WHITE);
        resssslbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        respagiblbl.setText("PAG-IBIG :");
        respagiblbl.setBounds(20, 110, 800, 100);
        respagiblbl.setForeground(Color.WHITE);
        respagiblbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        resphlbl.setText("PHILHEALTH :");
        resphlbl.setBounds(20, 140, 800, 100);
        resphlbl.setForeground(Color.WHITE);
        resphlbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        resotherslbl.setText("OTHERS :");
        resotherslbl.setBounds(20, 170, 800, 100);
        resotherslbl.setForeground(Color.WHITE);
        resotherslbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        totaldedcont.setText("TOTAL DEDUCTION/CONTRIBUTION :");
        totaldedcont.setBounds(20, 210, 800, 100);
        totaldedcont.setForeground(Color.WHITE);
        totaldedcont.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        grosslbl.setText("GROSS INCOME :");
        grosslbl.setBounds(20, 50, 800, 100);
        grosslbl.setForeground(Color.WHITE);
        grosslbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        resline.setText("=======================================================");
        resline.setBounds(20, 25, 800, 100);
        resline.setForeground(Color.WHITE);
        resline.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        resdatelbl.setText("DATE : ");
        resdatelbl.setBounds(420, -15, 300, 100);
        resdatelbl.setForeground(Color.WHITE);
        resdatelbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        resnamelbl.setText("NAME : ");
        resnamelbl.setBounds(20, -15, 300, 100);
        resnamelbl.setForeground(Color.WHITE);
        resnamelbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        resinputlbl.setText("           INPUT ");
        resinputlbl.setBounds(0, 85, 300, 80);
        resinputlbl.setBackground(Color.DARK_GRAY);
        resinputlbl.setForeground(Color.WHITE);
        resinputlbl.setOpaque(true);
        resinputlbl.setFont(new Font("Times New Roman", Font.PLAIN, 35));

        resultlbl.setText("CALCULATED!");
        resultlbl.setBounds(165, 5, 700, 100);
        resultlbl.setForeground(Color.WHITE);
        resultlbl.setFont(new Font("Times New Roman", Font.PLAIN, 55));

        resline2.setText("----------------------------------------------------------------");
        resline2.setBounds(180, 185, 800, 100);
        resline2.setForeground(Color.WHITE);
        resline2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        netlbl.setText("NET INCOME : ");
        netlbl.setBounds(360, 250, 700, 100);
        netlbl.setForeground(Color.ORANGE);
        netlbl.setFont(new Font("Times New Roman", Font.PLAIN, 25));

        //panel
        ressubmainpanel.setBounds(317, 180, 650, 330);
        ressubmainpanel.setBackground(Color.gray);
        ressidepanel.setBounds(0, 0, 300, 600);
        ressidepanel.setBackground(Color.orange);
        restoppanel.setBounds(300, 70, 700, 100);
        restoppanel.setBackground(new Color(0, 103, 0));
        resmainpanel.setBounds(0, 0, 1000, 600);
        resmainpanel.setBackground(Color.DARK_GRAY);

        //layout
        ressubmainpanel.setLayout(null);
        ressidepanel.setLayout(null);
        ressidepanel.setLayout(null);
        restoppanel.setLayout(null);
        resmainpanel.setLayout(null);
        resultframe.setLayout(null);

        //adding
        resmainpanel.add(printbtn);
        resmainpanel.add(addcalcbtn);
        ressubmainpanel.add(resnametxt);
        ressubmainpanel.add(resdatetxt);
        ressubmainpanel.add(grosstxt);
        ressubmainpanel.add(resssstxt);
        ressubmainpanel.add(respagibtxt);
        ressubmainpanel.add(resphtxt);
        ressubmainpanel.add(totaldedconttxt);
        ressubmainpanel.add(nettxt);
        ressubmainpanel.add(resotherstxt);

        ressubmainpanel.add(resline2);
        ressubmainpanel.add(resline);
        ressubmainpanel.add(resnamelbl);
        ressubmainpanel.add(resdatelbl);
        ressubmainpanel.add(grosslbl);
        ressubmainpanel.add(resssslbl);
        ressubmainpanel.add(respagiblbl);
        ressubmainpanel.add(resphlbl);
        ressubmainpanel.add(totaldedcont);
        ressubmainpanel.add(netlbl);
        ressubmainpanel.add(resotherslbl);
        ressidepanel.add(resexitbtn);
        ressidepanel.add(reshistorybtn);
        ressidepanel.add(resinputlbl);
        restoppanel.add(resultlbl);
        resmainpanel.add(ressubmainpanel);

        resultframe.add(ressidepanel);
        resultframe.add(restoppanel);
        resultframe.add(resmainpanel);

        resultframe.setLayout(null);
        resultframe.setTitle("RESULT");
        resultframe.setSize(1000, 600);
        resultframe.setResizable(false);
        resultframe.setLocationRelativeTo(null);
        resultframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        PayCalc pc = new PayCalc();
        pc.setGUI();
        pc.setHistoryGUI();
        pc.setOtherGUI();
        pc.setButton();
        pc.setResultGUI();
    }

    public void setButton() {
        //printing the textarea where the data is to be append
        printbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("PRINT BUTTON CLICKED!");
                try {
                    boolean success = calculate1txta.print();
                    if (success) {
                        JOptionPane.showMessageDialog(resultframe, "PRINTING SUCCESS!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(resultframe, "PRINTING!", "PRINTER", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (PrinterException e) {
                    JOptionPane.showMessageDialog(resultframe, e);
                }
            }
        });

        //visibility of elements for checkbox
        manualcheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JCheckBox cb1 = (JCheckBox) event.getSource();
                if (cb1.isSelected()) {
                    countercheck++;

                    ssstxt.setVisible(true);
                    pagibtxt.setVisible(true);
                    phtxt.setVisible(true);
                    ssscb.setVisible(false);
                    phval.setVisible(false);
                    pagibval.setVisible(false);
                } else {
                    countercheck = 0;

                    ssstxt.setVisible(false);
                    pagibtxt.setVisible(false);
                    phtxt.setVisible(false);
                    ssscb.setVisible(true);
                    phval.setVisible(true);
                    pagibval.setVisible(true);
                }
            }
        });

        //SETTING LABEL
        ratecb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ratecb.getSelectedItem().equals("PER HOUR")) {
                    dowlbl.setText("HOURS OF WORK :");
                } else {
                    dowlbl.setText("DAYS OF WORK : ");
                }
            }
        });

        //opening others frame
        othersbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //othersframe.setVisible(true);
                othersframe.setVisible(true);
                mainframe.setVisible(false);
            }
        });
        //clearing textfields as well as values and state of combobox and checkbox
        clearbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainframe.invalidate();
                mainframe.validate();
                mainframe.repaint();

                nametxt.setText("");
                dowtxt.setText("");
                ratetxt.setText("");
                otratetxt.setText("");
                ottxt.setText("");
                ssstxt.setText("");
                pagibtxt.setText("");
                phtxt.setText("");

                otherdedtxt.setText("");
                orgded1txt.setText("");
                orgded2txt.setText("");
                orgded3txt.setText("");
                org1txt.setText("");
                org2txt.setText("");
                org3txt.setText("");

                org1val = 0;
                org2val = 0;
                org3val = 0;
                othersded = 0;
                name = "";
                ot = 0;
                otrate = 0;
                rate = 0;
                dow = 0;

                ratecb.setSelectedIndex(0);
                ssscb.setSelectedIndex(0);
                manualcheck.setSelected(false);

                ssstxt.setVisible(false);
                pagibtxt.setVisible(false);
                phtxt.setVisible(false);
                ssscb.setVisible(true);
                phval.setVisible(true);
                pagibval.setVisible(true);
                otherdedlbl.setVisible(false);
                otherdedtxt.setVisible(false);

            }
        });

        exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //WRITING VALUE OF FILECOUNTER ON A FILE
                PrintWriter output = null;
                int fcval;
                fcval = filecounter;
                try {
                    String out = "filecounter.txt";
                    output = new PrintWriter(new FileWriter(out));

                    output.println(fcval);
                    output.close();
                } catch (Exception A) {
                    System.out.println("ERROR WRITING DATA ON FILECOUNTER");
                }
                System.exit(0);
            }
        });

        //CONTINUE BUTTON COMPUTES ALL THE VALUE IN TEXTFIELD OF OTHERS FRAME
        continuebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //othersframe.setVisible(true);

                try {
                    org1val = Double.parseDouble(orgded1txt.getText());
                    org2val = Double.parseDouble(orgded2txt.getText());
                    org3val = Double.parseDouble(orgded3txt.getText());
                } catch (Exception b) {

                }
                
                //PROMPTING USER FOR THE IMPORTANT FIELDS THAT NEEDS INPUTS BEFORE CONTINUING
               if ((org1val != 0) || (org2val != 0) || (org3val != 0)) {
                    if ((org1txt.getText().length() != 0) || (org2txt.getText().length() != 0) || (org3txt.getText().length() != 0)) {
                        othersframe.setVisible(false);
                        mainframe.setVisible(true);

                        othersded = org1val + org2val + org3val;

                        otherdedtxt.setText(Double.toString(othersded));
                        otherdedtxt.setVisible(true);
                        otherdedlbl.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(othersframe, "Please Make Sure To Put Value!",
                                "NO VALUE", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    othersded = 0;
                    JOptionPane.showMessageDialog(othersframe, "Please Make Sure To Put Value!",
                            "NO VALUE", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        //CANCELS ALL THE INPUTS
        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //othersframe.setVisible(true);
                othersframe.setVisible(false);
                mainframe.setVisible(true);
            }
        });

        //RESULT BUTTON HANDLES ALL THE CALCULATION AND GATHERS NECESSARY DATA FOR THE APPLICATION
        calcbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //PROMPTING USER FOR THE IMPORTANT FIELDS THAT NEEDS INPUTS BEFORE CALCULATING
                if (nametxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "PLEASE INPUT A NAME");
                } else if (ratetxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "PLEASE INPUT A RATE");
                } else if (dowtxt.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "PLEASE INPUT DAYS/HOURS");
                } else if (ssstxt.getText().isEmpty() && countercheck > 0) {
                    JOptionPane.showMessageDialog(null, "ATLEAST INPUT A 0 ON BLANK FIELDS");
                } else if (pagibtxt.getText().isEmpty() && countercheck > 0) {
                    JOptionPane.showMessageDialog(null, "ATLEAST INPUT A 0 ON BLANK FIELDS");
                } else if (phtxt.getText().isEmpty() && countercheck > 0) {
                    JOptionPane.showMessageDialog(null, "ATLEAST INPUT A 0 ON BLANK FIELDS");
                } else {

                    try {

                        //making files for history
                        File obj1 = new File("histo1.txt");
                        File obj2 = new File("histo2.txt");
                        File obj3 = new File("histo3.txt");
                        File obj4 = new File("histo4.txt");
                        File obj5 = new File("histo5.txt");

                        try {
                            if (obj1.createNewFile() && obj2.createNewFile() && obj3.createNewFile() && obj4.createNewFile()
                                    && obj5.createNewFile()) {
                                if (filecounter == 0) {
                                    System.out.println("FILES CREATED!");
                                }
                            } else {
                                System.out.println("FILES ALREADY EXIST!");
                            }
                        } catch (IOException j) {
                            System.out.println("AN ERROR OCCURED.");
                            //j.printStackTrace();
                        }
                        filecounter++;

                        //getting input for name
                        name = nametxt.getText();
                        //parsing2
                        rate = Double.parseDouble(ratetxt.getText());
                        dow = Integer.parseInt(dowtxt.getText());

                        if (ot >= 1 && otrate >= 1.0) {
                            ot = Integer.parseInt(ottxt.getText());
                            otrate = Double.parseDouble(otratetxt.getText());
                        }

                        //computation
                        //for gross
                        gross = (rate * dow) + (otrate * ot);
                        gross = (double) (Math.round(gross * 100.0) / 100.0);
                        //for contribs
                        if (countercheck > 0) {
                            sssval2 = Double.parseDouble(ssstxt.getText());
                            sssval2 = (double) (Math.round(sssval2 * 100.0) / 100.0);
                            pagibval2 = Double.parseDouble(pagibtxt.getText());
                            pagibval2 = (double) (Math.round(pagibval2 * 100.0) / 100.0);
                            phval2 = Double.parseDouble(phtxt.getText());
                            phval2 = (double) (Math.round(phval2 * 100.0) / 100.0);

                            manualded = sssval2 + pagibval2 + phval2;
                            manualded = (double) (Math.round(manualded * 100.0) / 100.0);
                        } else {
                            sssStr = (String) ssscb.getSelectedItem();
                            sssval1 = Double.parseDouble(sssStr);

                            sssval1 = sssval1 / 100;
                            sssval1 = (double) (Math.round(sssval1 * 100.0) / 100.0);
                            pagibval1 = 100;
                            phval1 = 1.75 / 100;
                            phval1 = (double) (Math.round(phval1 * 100.0) / 100.0);

                            automated = (gross * sssval1) + (gross * phval1) + pagibval1;
                            automated = (double) (Math.round(automated * 100.0) / 100.0);
                        }

                        //COMPUTATION FOR ALL DEDUCTIONS AND CONTRIBUTION
                        sssval3 = (gross * sssval1) + sssval2;
                        sssval3 = (double) (Math.round(sssval3 * 100.0) / 100.0);
                        pagibval3 = pagibval1 + pagibval2;
                        pagibval3 = (double) (Math.round(pagibval3 * 100.0) / 100.0);
                        phval3 = (gross * phval1) + phval2;
                        phval3 = (double) (Math.round(phval3 * 100.0) / 100.0);

                        allded = manualded + automated + othersded;
                        allded = (double) (Math.round(allded * 100.0) / 100.0);
                        
                        //for net
                        net = gross - allded;
                        net = (double) (Math.round(net * 100.0) / 100.0);
                    } catch (Exception f) {
                        System.out.println("ERROR PARSING NULL AND SETTING NULL VALUES!!!");
                    }
                    //SETTING VALUES AS TEXT ADN SHOWING THAT WILL BE SHOWN IN RESULT FRAME
                    resnametxt.setText(name);
                    resdatetxt.setText(str);
                    grosstxt.setText(Double.toString(gross));
                    respagibtxt.setText(Double.toString(pagibval3));
                    resssstxt.setText(Double.toString(sssval3));
                    resphtxt.setText(Double.toString(phval3));
                    resotherstxt.setText(Double.toString(othersded));
                    totaldedconttxt.setText(Double.toString(allded));
                    nettxt.setText(Double.toString(net));

                    //Sending data to textarea for possible printing action
                    calculate1txta.append("\t       UNOFFICIAL PAYROLL INFORMATION\n\n"
                            + "   NAME : " + nametxt.getText() + "\t\t\t DATE : " + resdatetxt.getText()
                            + "\n   ============================================================\n"
                            + "   GROSS INCOME :\t" + gross + "\n\n"
                            + "   SSS :\t\t" + sssval3 + "\n\n"
                            + "   PAG-IBIG :\t\t" + pagibval3 + "\n\n"
                            + "   PHILHEALTH :\t" + phval3 + "\n\n"
                            + "   OTHERS :\t\t" + otherdedtxt.getText() + "\n\n"
                            + "   TOTAL DEDUCTION AND CONTRIBUTION : " + allded + "\n\n"
                            + "\n   ============================================================\n"
                            + "   NET INCOME :\t" + net + "\n\n"
                    );

                    //writing data in files
                    if (filecounter == 6) {
                        filecounter = 1;
                    }

                    switch (filecounter) {
                        case 1:
                try {
                            BufferedWriter bf = new BufferedWriter(new FileWriter("histo1.txt"));
                            bf.write(calculate1txta.getText());
                            bf.flush();
                            bf.close();
                            //calculate1txta.setText("");
                        } catch (IOException k) {
                            //e.printStackTrace();
                        }
                        break;
                        case 2:
                 try {
                            BufferedWriter bf = new BufferedWriter(new FileWriter("histo2.txt"));
                            bf.write(calculate1txta.getText());
                            bf.flush();
                            bf.close();
                            //calculate1txta.setText("");
                        } catch (IOException k) {
                            //e.printStackTrace();
                        }
                        break;
                        case 3:
                 try {
                            BufferedWriter bf = new BufferedWriter(new FileWriter("histo3.txt"));
                            bf.write(calculate1txta.getText());
                            bf.flush();
                            bf.close();
                            //calculate1txta.setText("");
                        } catch (IOException k) {
                            //e.printStackTrace();
                        }
                        break;
                        case 4:
                 try {
                            BufferedWriter bf = new BufferedWriter(new FileWriter("histo4.txt"));
                            bf.write(calculate1txta.getText());
                            bf.flush();
                            bf.close();
                            //calculate1txta.setText("");
                        } catch (IOException k) {
                            //e.printStackTrace();
                        }
                        break;
                        case 5:
                 try {
                            BufferedWriter bf = new BufferedWriter(new FileWriter("histo5.txt"));
                            bf.write(calculate1txta.getText());
                            bf.flush();
                            bf.close();
                            //calculate1txta.setText("");
                        } catch (IOException k) {
                            //e.printStackTrace();
                        }
                        break;
                    }

                    mainframe.setVisible(false);
                    resultframe.setVisible(true);
                }//end of if else if name, days, rate and manual contrib
            }
        }
        ); // end of calc btn
        
        //BEFORE EXITING GETTING THE CURRENT VALUE OF FILECOUNTER AND WRITING TO FILE FOR NEXT USAGE
        resexitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //GETTING VALUE OF FILECOUNTER ON A FILE
                PrintWriter output = null;
                int fcval;
                fcval = filecounter;
                try {
                    String out = "filecounter.txt";
                    output = new PrintWriter(new FileWriter(out));

                    output.println(fcval);
                    output.close();
                } catch (Exception B) {
                    System.out.println("ERROR WRITING DATA ON FILECOUNTER");
                }
                System.exit(0);
            }
        });
        
        //MAKING ANOTHER CALCULATION AND SETTING VALUES AND FIELDS TO NULL OR 0
        addcalcbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rescount = 0;
                maincount = 0;
                nametxt.setText("");
                dowtxt.setText("");
                ratetxt.setText("");
                otratetxt.setText("");
                ottxt.setText("");
                ssstxt.setText("");
                pagibtxt.setText("");
                phtxt.setText("");

                calculate1txta.setText("");

                otherdedtxt.setText("");
                orgded1txt.setText("");
                orgded2txt.setText("");
                orgded3txt.setText("");
                org1txt.setText("");
                org2txt.setText("");
                org3txt.setText("");

                org1val = 0;
                org2val = 0;
                org3val = 0;
                othersded = 0;
                sssval2 = 0;
                pagibval2 = 0;
                phval2 = 0;

                otherdedlbl.setVisible(false);
                otherdedtxt.setVisible(false);

                manualcheck.setSelected(false);
                ratecb.setSelectedIndex(0);
                ssscb.setSelectedIndex(0);

                mainframe.setVisible(true);
                resultframe.dispose();
                othersframe.dispose();
            }
        });
        
        //OPENING HISTORY FRAME AND READING TEXTFIELS NEEDED FOR HISTORY
        historybtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                histocounter = 1;
                histoframe.setVisible(true);
                histo1ta.setVisible(true);
                inputlbl.setOpaque(false);
                inputlbl.setForeground(Color.DARK_GRAY);
                historybtn.setForeground(Color.WHITE);
                historybtn.setBackground(Color.DARK_GRAY);

                //displaying data of files on text area 
                try {
                    FileReader reader = new FileReader("histo1.txt");
                    BufferedReader br = new BufferedReader(reader);
                    histo1ta.read(br, null);
                } catch (Exception b) {
                    JOptionPane.showMessageDialog(null, "NO HISTORY CALCULATION YET");
                }

                try {
                    FileReader reader = new FileReader("histo2.txt");
                    BufferedReader br = new BufferedReader(reader);
                    histo2ta.read(br, null);
                } catch (Exception c) {
                    //JOptionPane.showMessageDialog(null, "NO HISTORY CALCULATION YET");
                }

                try {
                    FileReader reader = new FileReader("histo3.txt");
                    BufferedReader br = new BufferedReader(reader);
                    histo3ta.read(br, null);
                } catch (Exception d) {
                    //JOptionPane.showMessageDialog(null, "NO HISTORY CALCULATION YET");
                }

                try {
                    FileReader reader = new FileReader("histo4.txt");
                    BufferedReader br = new BufferedReader(reader);
                    histo4ta.read(br, null);
                } catch (Exception z) {
                    //JOptionPane.showMessageDialog(null, "NO HISTORY CALCULATION YET");
                }

                try {
                    FileReader reader = new FileReader("histo5.txt");
                    BufferedReader br = new BufferedReader(reader);
                    histo5ta.read(br, null);
                } catch (Exception y) {
                    //JOptionPane.showMessageDialog(null, "NO HISTORY CALCULATION YET");
                }
            }
        });
        
        //OPENING HISTORY FRAME AND READING CONTENTS OF FILE
        reshistorybtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                histocounter = 1;
                histoframe.setVisible(true);
                histo1ta.setVisible(true);

                reshistorybtn.setForeground(Color.WHITE);
                reshistorybtn.setBackground(Color.DARK_GRAY);

                resinputlbl.setForeground(Color.DARK_GRAY);
                resinputlbl.setBackground(null);
                resinputlbl.setOpaque(false);

                rescount++;
                maincount++;

                //reading files
                if (filecounter == 6) {
                    filecounter = 1;
                }
                //displaying data of file in text area
                try {
                    FileReader reader = new FileReader("histo1.txt");
                    BufferedReader br = new BufferedReader(reader);
                    histo1ta.read(br, null);
                } catch (Exception b) {
                    JOptionPane.showMessageDialog(null, "NO HISTORY CALCULATION YET");
                }

                try {
                    FileReader reader = new FileReader("histo2.txt");
                    BufferedReader br = new BufferedReader(reader);
                    histo2ta.read(br, null);
                } catch (Exception c) {
                    JOptionPane.showMessageDialog(null, "NO HISTORY CALCULATION YET");
                }

                try {
                    FileReader reader = new FileReader("histo3.txt");
                    BufferedReader br = new BufferedReader(reader);
                    histo3ta.read(br, null);
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(null, "NO HISTORY CALCULATION YET");
                }

                try {
                    FileReader reader = new FileReader("histo4.txt");
                    BufferedReader br = new BufferedReader(reader);
                    histo4ta.read(br, null);
                } catch (Exception z) {
                    JOptionPane.showMessageDialog(null, "NO HISTORY CALCULATION YET");
                }

                try {
                    FileReader reader = new FileReader("histo5.txt");
                    BufferedReader br = new BufferedReader(reader);
                    histo5ta.read(br, null);
                } catch (Exception y) {
                    JOptionPane.showMessageDialog(null, "NO HISTORY CALCULATION YET");
                }

            }
        });
        //CLOSING THE HISTORY FRAME AND SETTING IT TO DEFAULT 
        histobackbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                histoframe.setVisible(false);
                historybtn.setBackground(null);
                historybtn.setForeground(Color.DARK_GRAY);

                histocounter = 1;
                //setting the last to default
                switch (histocounter) {
                    case 1 -> {
                        histo1ta.setVisible(true);
                        histo5ta.setVisible(false);
                        histo2ta.setVisible(false);
                        histo3ta.setVisible(false);
                        histo4ta.setVisible(false);
                        moveleftbtn.setVisible(false);
                        moverightbtn.setVisible(true);                       
                    }
                    case 2 -> {
                        histo2ta.setVisible(true);
                        histo1ta.setVisible(false);
                        histo5ta.setVisible(false);
                        histo3ta.setVisible(false);
                        histo4ta.setVisible(false);
                    }
                    case 3 -> {
                        histo3ta.setVisible(true);
                        histo1ta.setVisible(false);
                        histo2ta.setVisible(false);
                        histo5ta.setVisible(false);
                        histo4ta.setVisible(false);
                    }
                    case 4 -> {
                        histo4ta.setVisible(true);
                        histo1ta.setVisible(false);
                        histo2ta.setVisible(false);
                        histo3ta.setVisible(false);
                        histo5ta.setVisible(false);
                    }
                    case 5 -> {
                        histo5ta.setVisible(true);
                        histo1ta.setVisible(false);
                        histo2ta.setVisible(false);
                        histo3ta.setVisible(false);
                        histo4ta.setVisible(false);

                    }
                }

                if (maincount == 0) {
                    mainframe.setVisible(true);
                    inputlbl.setForeground(Color.WHITE);
                    inputlbl.setBackground(Color.DARK_GRAY);
                    inputlbl.setOpaque(true);
                } else {
                    resultframe.setVisible(true);
                    resinputlbl.setForeground(Color.WHITE);
                    resinputlbl.setBackground(Color.DARK_GRAY);
                    resinputlbl.setOpaque(true);
                    reshistorybtn.setBackground(null);
                    reshistorybtn.setForeground(Color.DARK_GRAY);
                }
            }
        });
        //NAVIGATING TO HISTORY FROM NEWEST UNTIL TO THE END
        moveleftbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reading files
                if (filecounter == 6) {
                    filecounter = 1;
                }

                if (histocounter != 1) {
                    histocounter--;
                }

                switch (histocounter) {
                    case 1 -> {
                        histo1ta.setVisible(true);
                        histo5ta.setVisible(false);
                        histo2ta.setVisible(false);
                        histo3ta.setVisible(false);
                        histo4ta.setVisible(false);
                        moveleftbtn.setVisible(false);
                        moverightbtn.setVisible(true);                   
                    }
                    case 2 -> {
                        histo2ta.setVisible(true);
                        histo1ta.setVisible(false);
                        histo5ta.setVisible(false);
                        histo3ta.setVisible(false);
                        histo4ta.setVisible(false);                      
                    }
                    case 3 -> {
                        histo3ta.setVisible(true);
                        histo1ta.setVisible(false);
                        histo2ta.setVisible(false);
                        histo5ta.setVisible(false);
                        histo4ta.setVisible(false);
                    }
                    case 4 -> {
                        histo4ta.setVisible(true);
                        histo1ta.setVisible(false);
                        histo2ta.setVisible(false);
                        histo3ta.setVisible(false);
                        histo5ta.setVisible(false);
                    }
                    case 5 -> {
                        histo5ta.setVisible(true);
                        histo1ta.setVisible(false);
                        histo2ta.setVisible(false);
                        histo3ta.setVisible(false);
                        histo4ta.setVisible(false);

                    }
                }

            }
        });
        //NAVIGATING TO HISTORY FROM THE END UNTIL NEWEST
        moverightbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (histocounter != 5) {
                    histocounter++;
                }

                switch (histocounter) {
                    case 1 -> {
                        histo1ta.setVisible(true);
                        histo5ta.setVisible(false);
                        histo2ta.setVisible(false);
                        histo3ta.setVisible(false);
                        histo4ta.setVisible(false);
                    }

                    case 2 -> {
                        histo2ta.setVisible(true);
                        histo1ta.setVisible(false);
                        histo5ta.setVisible(false);
                        histo3ta.setVisible(false);
                        histo4ta.setVisible(false);
                    }

                    case 3 -> {
                        histo3ta.setVisible(true);
                        histo1ta.setVisible(false);
                        histo2ta.setVisible(false);
                        histo5ta.setVisible(false);
                        histo4ta.setVisible(false);
                    }

                    case 4 -> {
                        histo4ta.setVisible(true);
                        histo1ta.setVisible(false);
                        histo2ta.setVisible(false);
                        histo3ta.setVisible(false);
                        histo5ta.setVisible(false);
                    }

                    case 5 -> {
                        histo5ta.setVisible(true);
                        histo1ta.setVisible(false);
                        histo2ta.setVisible(false);
                        histo3ta.setVisible(false);
                        histo4ta.setVisible(false);
                        moverightbtn.setVisible(false);
                        moveleftbtn.setVisible(true);
                    }
                }

            }
        });

    }
}
