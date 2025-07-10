package travelmanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewBookedHotel extends JFrame implements ActionListener {
    JButton back;
    ViewBookedHotel(String username) {
        setBounds(400, 200, 1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60, 0, 400, 30);
        add(text);

        JLabel lblusername   = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lbhotelname   = new JLabel("Hotel Name");
        lbhotelname.setBounds(30, 90, 150, 25);
        add(lbhotelname);

        JLabel labelhotelname = new JLabel();
        labelhotelname.setBounds(220, 90, 150, 25);
        add(labelhotelname);

        JLabel lbltotalperson   = new JLabel("Total Persons");
        lbltotalperson.setBounds(30, 130, 150, 25);
        add(lbltotalperson);

        JLabel labeltotalperson = new JLabel();
        labeltotalperson.setBounds(220, 130, 150, 25);
        add(labeltotalperson);

        JLabel lbltotaldays   = new JLabel("Total Days");
        lbltotaldays.setBounds(30, 170, 150, 25);
        add(lbltotaldays);

        JLabel labeltotaldays = new JLabel();
        labeltotaldays.setBounds(220, 170, 150, 25);
        add(labeltotaldays);

        JLabel lblroomtype   = new JLabel("AC/Non-AC");
        lblroomtype.setBounds(30, 210, 150, 25);
        add(lblroomtype);

        JLabel labelroomtype = new JLabel();
        labelroomtype.setBounds(220, 210, 150, 25);
        add(labelroomtype);

        JLabel lblfood   = new JLabel("Food Included?");
        lblfood.setBounds(30, 250, 150, 25);
        add(lblfood);

        JLabel labelfood = new JLabel();
        labelfood.setBounds(220, 250, 150, 25);
        add(labelfood);

        JLabel lblid   = new JLabel("ID");
        lblid.setBounds(30, 290, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 290, 150, 25);
        add(labelid);


        JLabel lblnumber   = new JLabel("Number");
        lblnumber.setBounds(30, 330, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 330, 150, 25);
        add(labelnumber);

        JLabel lblphone   = new JLabel("Phone");
        lblphone.setBounds(30, 370, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 370, 150, 25);
        add(labelphone);

        JLabel lblprice   = new JLabel("Price");
        lblprice.setBounds(30, 410, 150, 25);
        add(lblprice);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 410, 150, 25);
        add(labelprice);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(110, 450, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 20, 500, 400);
        add(image);

        try{
            Conn conn = new Conn();
            String query = "Select * from bookhotel where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelhotelname.setText(rs.getString("name"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labeltotalperson.setText(rs.getString("person"));
                labelfood.setText(rs.getString("food"));
                labeltotaldays.setText(rs.getString("days"));
                labelroomtype.setText(rs.getString("ac"));
            }
        }catch (Exception e){

        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewBookedHotel("tannu");
    }
}


