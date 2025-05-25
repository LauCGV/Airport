/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package core.views;

import core.models.Plane;
import core.models.Flight;
import core.models.Passenger;
import core.models.Location;
import com.formdev.flatlaf.FlatDarkLaf;
import core.controllers.flights.AddFlightToPassengerController;
import core.controllers.flights.DelayFlightController;
import core.controllers.flights.FlightController;
import core.controllers.LocationController;
import core.controllers.PassengerController;
import core.controllers.PlaneController;
import core.controllers.UpdatePassengerController;
import core.controllers.table.FlightTableController;
import core.controllers.table.LocationTableController;
import core.controllers.table.PassengerTableController;
import core.controllers.table.PlaneTableController;
import core.controllers.utils.addItemToComboBox.AddPassengerToComboBox;
import core.controllers.utils.LocationSort;
import core.controllers.utils.PassengerSort;
import core.controllers.utils.PlaneSort;
import core.controllers.utils.Response;
import core.controllers.utils.addItemToComboBox.AddFlightToComboBox;
import core.controllers.utils.addItemToComboBox.AddJsonToStorage;
import core.controllers.utils.addItemToComboBox.AddLocationToComboBox;
import core.controllers.utils.addItemToComboBox.AddPlaneToComboBox;
import core.models.jsonReader.ReadJsonFlight;
import core.models.storage.FlightStorage;
import core.models.storage.LocationStorage;
import core.models.storage.PassengerStorage;
import core.models.storage.PlaneStorage;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import static core.controllers.utils.addItemToComboBox.AddPassengerToComboBox.addItems;

/**
 *
 * @author edangulo
 */
public class AirportFrame extends javax.swing.JFrame {

    /**
     * Creates new form AirportFrame
     */
    private int x, y;
    private PassengerStorage passengerStorage;
    private PlaneStorage planeStorage;
    private FlightStorage flightStorage;
    private LocationStorage locationStorage;

    public AirportFrame() {
        initComponents();

        this.passengerStorage = PassengerStorage.getInstance();
        this.planeStorage = PlaneStorage.getInstance();
        this.flightStorage = FlightStorage.getInstance();
        this.locationStorage = LocationStorage.getInstance();

        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);

        this.uploadJSON();
        this.uploadItemsToComboBox();
        this.generateMonths();
        this.generateDays();
        this.generateHours();
        this.generateMinutes();
        this.blockPanels();
    }

    private void uploadJSON() {
        Response response = AddJsonToStorage.addJson();
        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void uploadItemsToComboBox() {
        Response responsePassenger = AddPassengerToComboBox.addItems(this.userSelectComboBox);
        Response responsePlane = AddPlaneToComboBox.addItems(this.planeSelectComboBox);
        Response responseFlight = AddFlightToComboBox.addItems(this.idFlightCB);
        Response responseFlight2 = AddFlightToComboBox.addItems(this.idFlightDelayCB);
        Response responseLocation1 = AddLocationToComboBox.addItems(this.arrivLocationCB);
        Response responseLocation2 = AddLocationToComboBox.addItems(this.depLocationCB);
        Response responseLocation3 = AddLocationToComboBox.addItems(this.scLocationCB);

    }

    private void blockPanels() {
        //9, 11
        for (int i = 1; i < pantalla.getTabCount(); i++) {
            if (i != 9 && i != 11) {
                pantalla.setEnabledAt(i, false);
            }
        }
    }

    //Añadir los números de los meses, días, horas y al combox 
    private void generateMonths() {
        for (int i = 1; i < 13; i++) {
            monthComboBox.addItem("" + i);
            depMonthFlightTextField.addItem("" + i);
            monthUpdateCB.addItem("" + i);
        }
    }

    private void generateDays() {
        for (int i = 1; i < 32; i++) {
            dayComboBox.addItem("" + i);
            depDayFlightCB.addItem("" + i);
            dayUpdateCB.addItem("" + i);
        }
    }

    private void generateHours() {
        for (int i = 0; i < 24; i++) {
            depHourFlightCB.addItem("" + i);
            arDurHourCB.addItem("" + i);
            scDurHourFlightCB.addItem("" + i);
            hourDelayCB.addItem("" + i);
        }
    }

    private void generateMinutes() {
        for (int i = 0; i < 60; i++) {
            depMinuteFlightCB.addItem("" + i);
            arDurMinuteFlightCB.addItem("" + i);
            scDurMinuteFlightCB.addItem("" + i);
            minutesDelayCB.addItem("" + i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new core.views.PanelRound();
        panelRound2 = new core.views.PanelRound();
        jButton13 = new javax.swing.JButton();
        pantalla = new javax.swing.JTabbedPane();
        Administration = new javax.swing.JPanel();
        userRB = new javax.swing.JRadioButton();
        administratorRB = new javax.swing.JRadioButton();
        userSelectComboBox = new javax.swing.JComboBox<>();
        passangerRegistration = new javax.swing.JPanel();
        countryLabel = new javax.swing.JLabel();
        idUserLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        birthdateLabel = new javax.swing.JLabel();
        codCellLabel = new javax.swing.JLabel();
        idCellTextField = new javax.swing.JTextField();
        idUserTextField = new javax.swing.JTextField();
        yearTextField = new javax.swing.JTextField();
        countryTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        monthLabel = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        cellphoneLabel = new javax.swing.JLabel();
        monthComboBox = new javax.swing.JComboBox<>();
        nameTextField = new javax.swing.JTextField();
        dayLabel = new javax.swing.JLabel();
        dayComboBox = new javax.swing.JComboBox<>();
        btnRegister = new javax.swing.JButton();
        AirplaneRegistration = new javax.swing.JPanel();
        idAirplaneLabel = new javax.swing.JLabel();
        idAirplaneTextField = new javax.swing.JTextField();
        brandAirplaneLabel = new javax.swing.JLabel();
        brandTextField = new javax.swing.JTextField();
        modelAirplaneTextField = new javax.swing.JTextField();
        modelAirplaneLabel = new javax.swing.JLabel();
        maxCapAirplaneTextField = new javax.swing.JTextField();
        maxCapLabel = new javax.swing.JLabel();
        airlineAirplaneTextField = new javax.swing.JTextField();
        airlineAirplaneLabel = new javax.swing.JLabel();
        btnCreateAirplane = new javax.swing.JButton();
        locationRegistration = new javax.swing.JPanel();
        idAirportLabel = new javax.swing.JLabel();
        idAirportTextField = new javax.swing.JTextField();
        airportNameLabel = new javax.swing.JLabel();
        airportNameTextField = new javax.swing.JTextField();
        airportCityTextField = new javax.swing.JTextField();
        airportCityLabel = new javax.swing.JLabel();
        airportCountryLabel = new javax.swing.JLabel();
        airportCountryTextField = new javax.swing.JTextField();
        airportLatitudTextField = new javax.swing.JTextField();
        airportLatitudLabel = new javax.swing.JLabel();
        airportLongitudeLabel = new javax.swing.JLabel();
        airportLongitudeTextField = new javax.swing.JTextField();
        btn_createAirport = new javax.swing.JButton();
        flightRegistration = new javax.swing.JPanel();
        idFlightLabel = new javax.swing.JLabel();
        idFlightTextField = new javax.swing.JTextField();
        depLocationLabel = new javax.swing.JLabel();
        planeSelectComboBox = new javax.swing.JComboBox<>();
        depLocationCB = new javax.swing.JComboBox<>();
        departureLocationLabel = new javax.swing.JLabel();
        arrivLocationCB = new javax.swing.JComboBox<>();
        arrivLocationLabel = new javax.swing.JLabel();
        scLocationLabel = new javax.swing.JLabel();
        scLocationCB = new javax.swing.JComboBox<>();
        scDurationFlightLabel = new javax.swing.JLabel();
        arDurationFlightLabel = new javax.swing.JLabel();
        departureDateLabel = new javax.swing.JLabel();
        departYearTextField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        depMonthFlightTextField = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        depDayFlightCB = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        depHourFlightCB = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        depMinuteFlightCB = new javax.swing.JComboBox<>();
        arDurHourCB = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        arDurMinuteFlightCB = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        scDurHourFlightCB = new javax.swing.JComboBox<>();
        scDurMinuteFlightCB = new javax.swing.JComboBox<>();
        btn_createFlight = new javax.swing.JButton();
        updateInfo = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        idUpdateTextField = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        nameUpdateTextField = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        lastNameUpdateTextField = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        yearUpdateTextField = new javax.swing.JTextField();
        monthUpdateCB = new javax.swing.JComboBox<>();
        dayUpdateCB = new javax.swing.JComboBox<>();
        phoneUpdateTextField = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        codCellUpdateTextField = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        countryUpdateTextField = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        addFlight = new javax.swing.JPanel();
        idPassTextField = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        idFlightCB = new javax.swing.JComboBox<>();
        btnAddFligh = new javax.swing.JButton();
        showMyFlights = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myFlighsTable = new javax.swing.JTable();
        btnRefrescarMyFlights = new javax.swing.JButton();
        showAllPassenger = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        passengerTable = new javax.swing.JTable();
        btnRefreshPassengers = new javax.swing.JButton();
        showAllFlights = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        flightsTable = new javax.swing.JTable();
        btnRefreshFlights = new javax.swing.JButton();
        showAllPlanes = new javax.swing.JPanel();
        btnRefreshPlanes = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        planesTable = new javax.swing.JTable();
        showAllLocations = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        locationTable = new javax.swing.JTable();
        btnRefreshLocations = new javax.swing.JButton();
        delayFlight = new javax.swing.JPanel();
        hourDelayCB = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        idFlightDelayCB = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        minutesDelayCB = new javax.swing.JComboBox<>();
        btnDelayFlight = new javax.swing.JButton();
        panelRound3 = new core.views.PanelRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setRadius(40);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelRound2MouseDragged(evt);
            }
        });
        panelRound2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelRound2MousePressed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jButton13.setText("X");
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(1083, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addComponent(jButton13)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, -1));

        pantalla.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N

        Administration.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userRB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        userRB.setText("User");
        userRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userRBActionPerformed(evt);
            }
        });
        Administration.add(userRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

        administratorRB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        administratorRB.setText("Administrator");
        administratorRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administratorRBActionPerformed(evt);
            }
        });
        Administration.add(administratorRB, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 164, -1, -1));

        userSelectComboBox.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        userSelectComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User" }));
        userSelectComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSelectComboBoxActionPerformed(evt);
            }
        });
        Administration.add(userSelectComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 130, -1));

        pantalla.addTab("Administration", Administration);

        passangerRegistration.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        countryLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        countryLabel.setText("Country");
        passangerRegistration.add(countryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        idUserLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        idUserLabel.setText("ID:");
        passangerRegistration.add(idUserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        nameLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        nameLabel.setText("First Name:");
        passangerRegistration.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        lastNameLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lastNameLabel.setText("Last Name:");
        passangerRegistration.add(lastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        birthdateLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        birthdateLabel.setText("Birthdate:");
        passangerRegistration.add(birthdateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        codCellLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        codCellLabel.setText("+");
        passangerRegistration.add(codCellLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 20, -1));

        idCellTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        passangerRegistration.add(idCellTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 50, -1));

        idUserTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        idUserTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idUserTextFieldActionPerformed(evt);
            }
        });
        passangerRegistration.add(idUserTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 130, -1));

        yearTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        passangerRegistration.add(yearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 90, -1));

        countryTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        passangerRegistration.add(countryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 130, -1));

        phoneTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        passangerRegistration.add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 130, -1));

        phoneLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        phoneLabel.setText("Phone:");
        passangerRegistration.add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        monthLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        monthLabel.setText("-");
        passangerRegistration.add(monthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 30, -1));

        lastNameTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });
        passangerRegistration.add(lastNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 130, -1));

        cellphoneLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        cellphoneLabel.setText("-");
        passangerRegistration.add(cellphoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 30, -1));

        monthComboBox.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        monthComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));
        passangerRegistration.add(monthComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        nameTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        passangerRegistration.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 130, -1));

        dayLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        dayLabel.setText("-");
        passangerRegistration.add(dayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 30, -1));

        dayComboBox.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));
        passangerRegistration.add(dayComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, -1, -1));

        btnRegister.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        passangerRegistration.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, -1, -1));

        pantalla.addTab("Passenger registration", passangerRegistration);

        AirplaneRegistration.setLayout(null);

        idAirplaneLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        idAirplaneLabel.setText("ID:");
        AirplaneRegistration.add(idAirplaneLabel);
        idAirplaneLabel.setBounds(53, 96, 22, 25);

        idAirplaneTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        AirplaneRegistration.add(idAirplaneTextField);
        idAirplaneTextField.setBounds(180, 93, 130, 33);

        brandAirplaneLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        brandAirplaneLabel.setText("Brand:");
        AirplaneRegistration.add(brandAirplaneLabel);
        brandAirplaneLabel.setBounds(53, 157, 50, 25);

        brandTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        AirplaneRegistration.add(brandTextField);
        brandTextField.setBounds(180, 154, 130, 33);

        modelAirplaneTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        AirplaneRegistration.add(modelAirplaneTextField);
        modelAirplaneTextField.setBounds(180, 213, 130, 33);

        modelAirplaneLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        modelAirplaneLabel.setText("Model:");
        AirplaneRegistration.add(modelAirplaneLabel);
        modelAirplaneLabel.setBounds(53, 216, 55, 25);

        maxCapAirplaneTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        AirplaneRegistration.add(maxCapAirplaneTextField);
        maxCapAirplaneTextField.setBounds(180, 273, 130, 33);

        maxCapLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        maxCapLabel.setText("Max Capacity:");
        AirplaneRegistration.add(maxCapLabel);
        maxCapLabel.setBounds(53, 276, 109, 25);

        airlineAirplaneTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        AirplaneRegistration.add(airlineAirplaneTextField);
        airlineAirplaneTextField.setBounds(180, 333, 130, 33);

        airlineAirplaneLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        airlineAirplaneLabel.setText("Airline:");
        AirplaneRegistration.add(airlineAirplaneLabel);
        airlineAirplaneLabel.setBounds(53, 336, 70, 25);

        btnCreateAirplane.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnCreateAirplane.setText("Create");
        btnCreateAirplane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAirplaneActionPerformed(evt);
            }
        });
        AirplaneRegistration.add(btnCreateAirplane);
        btnCreateAirplane.setBounds(490, 480, 120, 40);

        pantalla.addTab("Airplane registration", AirplaneRegistration);

        idAirportLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        idAirportLabel.setText("Airport ID:");

        idAirportTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        airportNameLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        airportNameLabel.setText("Airport name:");

        airportNameTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        airportCityTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        airportCityLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        airportCityLabel.setText("Airport city:");

        airportCountryLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        airportCountryLabel.setText("Airport country:");

        airportCountryTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        airportLatitudTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        airportLatitudLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        airportLatitudLabel.setText("Airport latitude:");

        airportLongitudeLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        airportLongitudeLabel.setText("Airport longitude:");

        airportLongitudeTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        btn_createAirport.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btn_createAirport.setText("Create");
        btn_createAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createAirportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout locationRegistrationLayout = new javax.swing.GroupLayout(locationRegistration);
        locationRegistration.setLayout(locationRegistrationLayout);
        locationRegistrationLayout.setHorizontalGroup(
            locationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locationRegistrationLayout.createSequentialGroup()
                .addGroup(locationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(locationRegistrationLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(locationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idAirportLabel)
                            .addComponent(airportNameLabel)
                            .addComponent(airportCityLabel)
                            .addComponent(airportCountryLabel)
                            .addComponent(airportLatitudLabel)
                            .addComponent(airportLongitudeLabel))
                        .addGap(80, 80, 80)
                        .addGroup(locationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(airportLongitudeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idAirportTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(airportNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(airportCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(airportCountryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(airportLatitudTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(locationRegistrationLayout.createSequentialGroup()
                        .addGap(515, 515, 515)
                        .addComponent(btn_createAirport, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(515, 515, 515))
        );
        locationRegistrationLayout.setVerticalGroup(
            locationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locationRegistrationLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(locationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(locationRegistrationLayout.createSequentialGroup()
                        .addComponent(idAirportLabel)
                        .addGap(36, 36, 36)
                        .addComponent(airportNameLabel)
                        .addGap(34, 34, 34)
                        .addComponent(airportCityLabel)
                        .addGap(35, 35, 35)
                        .addComponent(airportCountryLabel)
                        .addGap(35, 35, 35)
                        .addComponent(airportLatitudLabel))
                    .addGroup(locationRegistrationLayout.createSequentialGroup()
                        .addComponent(idAirportTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(airportNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(airportCityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(airportCountryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(airportLatitudTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(locationRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(airportLongitudeLabel)
                    .addComponent(airportLongitudeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btn_createAirport, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        pantalla.addTab("Location registration", locationRegistration);

        idFlightLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        idFlightLabel.setText("ID:");

        idFlightTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        depLocationLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        depLocationLabel.setText("Plane:");

        planeSelectComboBox.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        planeSelectComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plane" }));

        depLocationCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        depLocationCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));
        depLocationCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depLocationCBActionPerformed(evt);
            }
        });

        departureLocationLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        departureLocationLabel.setText("Departure location:");

        arrivLocationCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        arrivLocationCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));

        arrivLocationLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        arrivLocationLabel.setText("Arrival location:");

        scLocationLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        scLocationLabel.setText("Scale location:");

        scLocationCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        scLocationCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Location" }));

        scDurationFlightLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        scDurationFlightLabel.setText("Duration:");

        arDurationFlightLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        arDurationFlightLabel.setText("Duration:");

        departureDateLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        departureDateLabel.setText("Departure date:");

        departYearTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel30.setText("-");

        depMonthFlightTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        depMonthFlightTextField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel31.setText("-");

        depDayFlightCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        depDayFlightCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel32.setText("-");

        depHourFlightCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        depHourFlightCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel33.setText("-");

        depMinuteFlightCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        depMinuteFlightCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        arDurHourCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        arDurHourCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel34.setText("-");

        arDurMinuteFlightCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        arDurMinuteFlightCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        jLabel35.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel35.setText("-");

        scDurHourFlightCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        scDurHourFlightCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        scDurMinuteFlightCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        scDurMinuteFlightCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        btn_createFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btn_createFlight.setText("Create");
        btn_createFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createFlightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout flightRegistrationLayout = new javax.swing.GroupLayout(flightRegistration);
        flightRegistration.setLayout(flightRegistrationLayout);
        flightRegistrationLayout.setHorizontalGroup(
            flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flightRegistrationLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(flightRegistrationLayout.createSequentialGroup()
                        .addComponent(scLocationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scLocationCB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, flightRegistrationLayout.createSequentialGroup()
                        .addComponent(arrivLocationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(arrivLocationCB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(flightRegistrationLayout.createSequentialGroup()
                        .addComponent(departureLocationLabel)
                        .addGap(46, 46, 46)
                        .addComponent(depLocationCB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(flightRegistrationLayout.createSequentialGroup()
                        .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idFlightLabel)
                            .addComponent(depLocationLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idFlightTextField)
                            .addComponent(planeSelectComboBox, 0, 130, Short.MAX_VALUE))))
                .addGap(45, 45, 45)
                .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scDurationFlightLabel)
                    .addComponent(arDurationFlightLabel)
                    .addComponent(departureDateLabel))
                .addGap(18, 18, 18)
                .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flightRegistrationLayout.createSequentialGroup()
                        .addComponent(departYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(flightRegistrationLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(depMonthFlightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(flightRegistrationLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(depDayFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(flightRegistrationLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(depHourFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(flightRegistrationLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(depMinuteFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(flightRegistrationLayout.createSequentialGroup()
                        .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(flightRegistrationLayout.createSequentialGroup()
                                .addComponent(arDurHourCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(flightRegistrationLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(arDurMinuteFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(flightRegistrationLayout.createSequentialGroup()
                                .addComponent(scDurHourFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(flightRegistrationLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(scDurMinuteFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, flightRegistrationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_createFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(530, 530, 530))
        );
        flightRegistrationLayout.setVerticalGroup(
            flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(flightRegistrationLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(flightRegistrationLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(idFlightLabel))
                    .addComponent(idFlightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depLocationLabel)
                    .addComponent(planeSelectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(depHourFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(depMinuteFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(flightRegistrationLayout.createSequentialGroup()
                        .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(departureLocationLabel)
                                .addComponent(depLocationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(departureDateLabel))
                            .addComponent(departYearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(depMonthFlightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(depDayFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(arrivLocationLabel)
                                .addComponent(arrivLocationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(arDurationFlightLabel))
                            .addComponent(arDurHourCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(arDurMinuteFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scDurHourFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)
                            .addComponent(scDurMinuteFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(flightRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(scLocationLabel)
                                .addComponent(scLocationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(scDurationFlightLabel)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(btn_createFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pantalla.addTab("Flight registration", flightRegistration);

        jLabel36.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel36.setText("ID:");

        idUpdateTextField.setEditable(false);
        idUpdateTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        idUpdateTextField.setEnabled(false);

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel37.setText("First Name:");

        nameUpdateTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel38.setText("Last Name:");

        lastNameUpdateTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel39.setText("Birthdate:");

        yearUpdateTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        monthUpdateCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        monthUpdateCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month" }));

        dayUpdateCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        dayUpdateCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day" }));

        phoneUpdateTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel40.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel40.setText("-");

        codCellUpdateTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        jLabel41.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel41.setText("+");

        jLabel42.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel42.setText("Phone:");

        jLabel43.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel43.setText("Country:");

        countryUpdateTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        btnUpdate.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout updateInfoLayout = new javax.swing.GroupLayout(updateInfo);
        updateInfo.setLayout(updateInfoLayout);
        updateInfoLayout.setHorizontalGroup(
            updateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateInfoLayout.createSequentialGroup()
                .addGroup(updateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateInfoLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(updateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updateInfoLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(108, 108, 108)
                                .addComponent(idUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(updateInfoLayout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(41, 41, 41)
                                .addComponent(nameUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(updateInfoLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(43, 43, 43)
                                .addComponent(lastNameUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(updateInfoLayout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(55, 55, 55)
                                .addComponent(yearUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(monthUpdateCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(dayUpdateCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(updateInfoLayout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(codCellUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(phoneUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(updateInfoLayout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(63, 63, 63)
                                .addComponent(countryUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(updateInfoLayout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(btnUpdate)))
                .addContainerGap(547, Short.MAX_VALUE))
        );
        updateInfoLayout.setVerticalGroup(
            updateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateInfoLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(updateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(idUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(updateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(nameUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(updateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(lastNameUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(updateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(yearUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthUpdateCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayUpdateCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(updateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41)
                    .addComponent(codCellUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(phoneUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(updateInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(countryUpdateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(113, 113, 113))
        );

        pantalla.addTab("Update info", updateInfo);

        idPassTextField.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        idPassTextField.setEnabled(false);

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel44.setText("ID:");

        jLabel45.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel45.setText("Flight:");

        idFlightCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        idFlightCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Flight" }));

        btnAddFligh.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnAddFligh.setText("Add");
        btnAddFligh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFlighActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addFlightLayout = new javax.swing.GroupLayout(addFlight);
        addFlight.setLayout(addFlightLayout);
        addFlightLayout.setHorizontalGroup(
            addFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addFlightLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(addFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addGap(79, 79, 79)
                .addGroup(addFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idPassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(829, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addFlightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddFligh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(509, 509, 509))
        );
        addFlightLayout.setVerticalGroup(
            addFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addFlightLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(addFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addFlightLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel44))
                    .addComponent(idPassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(addFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(idFlightCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addComponent(btnAddFligh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        pantalla.addTab("Add to flight", addFlight);

        myFlighsTable.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        myFlighsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Departure Date", "Arrival Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(myFlighsTable);

        btnRefrescarMyFlights.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRefrescarMyFlights.setText("Refresh");
        btnRefrescarMyFlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarMyFlightsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showMyFlightsLayout = new javax.swing.GroupLayout(showMyFlights);
        showMyFlights.setLayout(showMyFlightsLayout);
        showMyFlightsLayout.setHorizontalGroup(
            showMyFlightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showMyFlightsLayout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(291, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showMyFlightsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefrescarMyFlights)
                .addGap(527, 527, 527))
        );
        showMyFlightsLayout.setVerticalGroup(
            showMyFlightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showMyFlightsLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnRefrescarMyFlights)
                .addContainerGap())
        );

        pantalla.addTab("Show my flights", showMyFlights);

        passengerTable.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        passengerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Birthdate", "Age", "Phone", "Country", "Num Flight"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(passengerTable);

        btnRefreshPassengers.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRefreshPassengers.setText("Refresh");
        btnRefreshPassengers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshPassengersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showAllPassengerLayout = new javax.swing.GroupLayout(showAllPassenger);
        showAllPassenger.setLayout(showAllPassengerLayout);
        showAllPassengerLayout.setHorizontalGroup(
            showAllPassengerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showAllPassengerLayout.createSequentialGroup()
                .addGroup(showAllPassengerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showAllPassengerLayout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(btnRefreshPassengers))
                    .addGroup(showAllPassengerLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        showAllPassengerLayout.setVerticalGroup(
            showAllPassengerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showAllPassengerLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefreshPassengers)
                .addContainerGap())
        );

        pantalla.addTab("Show all passengers", showAllPassenger);

        flightsTable.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        flightsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Departure Airport ID", "Arrival Airport ID", "Scale Airport ID", "Departure Date", "Arrival Date", "Plane ID", "Number Passengers"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(flightsTable);

        btnRefreshFlights.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRefreshFlights.setText("Refresh");
        btnRefreshFlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshFlightsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showAllFlightsLayout = new javax.swing.GroupLayout(showAllFlights);
        showAllFlights.setLayout(showAllFlightsLayout);
        showAllFlightsLayout.setHorizontalGroup(
            showAllFlightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showAllFlightsLayout.createSequentialGroup()
                .addGroup(showAllFlightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showAllFlightsLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(showAllFlightsLayout.createSequentialGroup()
                        .addGap(521, 521, 521)
                        .addComponent(btnRefreshFlights)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        showAllFlightsLayout.setVerticalGroup(
            showAllFlightsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showAllFlightsLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRefreshFlights)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pantalla.addTab("Show all flights", showAllFlights);

        btnRefreshPlanes.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRefreshPlanes.setText("Refresh");
        btnRefreshPlanes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshPlanesActionPerformed(evt);
            }
        });

        planesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Brand", "Model", "Max Capacity", "Airline", "Number Flights"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(planesTable);

        javax.swing.GroupLayout showAllPlanesLayout = new javax.swing.GroupLayout(showAllPlanes);
        showAllPlanes.setLayout(showAllPlanesLayout);
        showAllPlanesLayout.setHorizontalGroup(
            showAllPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showAllPlanesLayout.createSequentialGroup()
                .addGroup(showAllPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showAllPlanesLayout.createSequentialGroup()
                        .addGap(508, 508, 508)
                        .addComponent(btnRefreshPlanes))
                    .addGroup(showAllPlanesLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        showAllPlanesLayout.setVerticalGroup(
            showAllPlanesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showAllPlanesLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnRefreshPlanes)
                .addGap(17, 17, 17))
        );

        pantalla.addTab("Show all planes", showAllPlanes);

        locationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airport ID", "Airport Name", "City", "Country"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(locationTable);

        btnRefreshLocations.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnRefreshLocations.setText("Refresh");
        btnRefreshLocations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshLocationsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout showAllLocationsLayout = new javax.swing.GroupLayout(showAllLocations);
        showAllLocations.setLayout(showAllLocationsLayout);
        showAllLocationsLayout.setHorizontalGroup(
            showAllLocationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showAllLocationsLayout.createSequentialGroup()
                .addGroup(showAllLocationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(showAllLocationsLayout.createSequentialGroup()
                        .addGap(508, 508, 508)
                        .addComponent(btnRefreshLocations))
                    .addGroup(showAllLocationsLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(272, Short.MAX_VALUE))
        );
        showAllLocationsLayout.setVerticalGroup(
            showAllLocationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showAllLocationsLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnRefreshLocations)
                .addGap(17, 17, 17))
        );

        pantalla.addTab("Show all locations", showAllLocations);

        hourDelayCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        hourDelayCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour" }));

        jLabel46.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel46.setText("Hours:");

        jLabel47.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel47.setText("ID:");

        idFlightDelayCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        idFlightDelayCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID" }));

        jLabel48.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel48.setText("Minutes:");

        minutesDelayCB.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        minutesDelayCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute" }));

        btnDelayFlight.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btnDelayFlight.setText("Delay");
        btnDelayFlight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelayFlightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout delayFlightLayout = new javax.swing.GroupLayout(delayFlight);
        delayFlight.setLayout(delayFlightLayout);
        delayFlightLayout.setHorizontalGroup(
            delayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(delayFlightLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(delayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(delayFlightLayout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minutesDelayCB, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(delayFlightLayout.createSequentialGroup()
                        .addGroup(delayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(jLabel46))
                        .addGap(79, 79, 79)
                        .addGroup(delayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hourDelayCB, 0, 105, Short.MAX_VALUE)
                            .addComponent(idFlightDelayCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(820, 820, 820))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, delayFlightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelayFlight)
                .addGap(531, 531, 531))
        );
        delayFlightLayout.setVerticalGroup(
            delayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(delayFlightLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(delayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(idFlightDelayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(delayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(hourDelayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(delayFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(minutesDelayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                .addComponent(btnDelayFlight)
                .addGap(33, 33, 33))
        );

        pantalla.addTab("Delay flight", delayFlight);

        panelRound1.add(pantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 41, 1150, 620));

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        panelRound1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 660, 1150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void panelRound2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_panelRound2MousePressed

    private void panelRound2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_panelRound2MouseDragged

    private void administratorRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administratorRBActionPerformed
        if (userRB.isSelected()) {
            userRB.setSelected(false);
            userSelectComboBox.setSelectedIndex(0);

        }
        for (int i = 1; i < pantalla.getTabCount(); i++) {
            pantalla.setEnabledAt(i, true);
        }
        pantalla.setEnabledAt(5, false);
        pantalla.setEnabledAt(6, false);
        pantalla.setEnabledAt(7, false);
    }//GEN-LAST:event_administratorRBActionPerformed

    private void userRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userRBActionPerformed
        if (administratorRB.isSelected()) {
            administratorRB.setSelected(false);
        }
        for (int i = 1; i < pantalla.getTabCount(); i++) {

            pantalla.setEnabledAt(i, false);

        }
        pantalla.setEnabledAt(9, true);
        pantalla.setEnabledAt(5, true);
        pantalla.setEnabledAt(6, true);
        pantalla.setEnabledAt(7, true);
        pantalla.setEnabledAt(11, true);
    }//GEN-LAST:event_userRBActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        String id = idUserTextField.getText();
        String firstname = nameTextField.getText();
        String lastname = lastNameTextField.getText();
        String year = yearTextField.getText();
        String month = monthComboBox.getItemAt(monthComboBox.getSelectedIndex());
        String day = dayComboBox.getItemAt(dayComboBox.getSelectedIndex());
        String phoneCode = idCellTextField.getText();
        String phone = phoneTextField.getText();
        String country = countryTextField.getText();

        Response response = PassengerController.passengerRegistration(id, firstname, lastname, year, month, day, phoneCode, phone, country);

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);
            idUserTextField.setText("");
            nameTextField.setText("");
            lastNameTextField.setText("");
            yearTextField.setText("");
            monthComboBox.setSelectedIndex(0);
            dayComboBox.setSelectedIndex(0);
            idCellTextField.setText("");
            phoneTextField.setText("");
            countryTextField.setText("");
            AddPassengerToComboBox.addItems(this.userSelectComboBox);

        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnCreateAirplaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAirplaneActionPerformed
        // TODO add your handling code here:
        String id = idAirplaneTextField.getText();
        String brand = brandTextField.getText();
        String model = modelAirplaneTextField.getText();
        String maxCapacity = maxCapAirplaneTextField.getText();
        String airline = airlineAirplaneTextField.getText();
        Response response = PlaneController.planeRegistration(id, brand, model, maxCapacity, airline);

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);
            idAirplaneTextField.setText("");
            brandTextField.setText("");
            modelAirplaneTextField.setText("");
            maxCapAirplaneTextField.setText("");
            airlineAirplaneTextField.setText("");
            this.planeSelectComboBox.removeAllItems();
            ArrayList<Plane> planes = PlaneSort.planes(this.planeStorage.getPlanes());
            this.planeSelectComboBox.addItem("Plane");
            for (Plane plane : planes) {
                this.planeSelectComboBox.addItem("" + plane.getId());
                System.out.println("New: " + plane.getId());
            }
        }
    }//GEN-LAST:event_btnCreateAirplaneActionPerformed

    private void btn_createAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createAirportActionPerformed
        // TODO add your handling code here:
        String id = idAirportTextField.getText();
        String name = airportNameTextField.getText();
        String city = airportCityTextField.getText();
        String country = airportCountryTextField.getText();
        String latitude = airportLatitudTextField.getText();
        String longitude = airportLongitudeTextField.getText();

        Response response = LocationController.locationRegistration(id, name, city, country, latitude, longitude);

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);
            idAirportTextField.setText("");
            airportNameTextField.setText("");
            airportCityTextField.setText("");
            airportCountryTextField.setText("");
            airportLatitudTextField.setText("");
            airportLongitudeTextField.setText("");
            this.depLocationCB.removeAllItems();
            this.arrivLocationCB.removeAllItems();
            this.scLocationCB.removeAllItems();
            ArrayList<Location> locations = LocationSort.locations(this.locationStorage.getLocations());
            this.planeSelectComboBox.addItem("Plane");
            for (Location location : locations) {
                this.planeSelectComboBox.addItem("" + location.getAirportId());
                System.out.println("New: " + location.getAirportId());
            }
        }
    }//GEN-LAST:event_btn_createAirportActionPerformed

    private void btn_createFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createFlightActionPerformed
        // TODO add your handling code here:
        String id = idFlightTextField.getText();
        String planeId = planeSelectComboBox.getItemAt(planeSelectComboBox.getSelectedIndex());
        String departureLocationId = depLocationCB.getItemAt(depLocationCB.getSelectedIndex());
        String arrivalLocationId = arrivLocationCB.getItemAt(arrivLocationCB.getSelectedIndex());
        String scaleLocationId = scLocationCB.getItemAt(scLocationCB.getSelectedIndex());
        String year = departYearTextField.getText();
        String month = depMonthFlightTextField.getItemAt(depMonthFlightTextField.getSelectedIndex());
        String day = depDayFlightCB.getItemAt(depDayFlightCB.getSelectedIndex());
        String hour = depHourFlightCB.getItemAt(depHourFlightCB.getSelectedIndex());
        String minutes = depMinuteFlightCB.getItemAt(depMinuteFlightCB.getSelectedIndex());
        String hoursDurationsArrival = arDurHourCB.getItemAt(arDurHourCB.getSelectedIndex());
        String minutesDurationsArrival = arDurMinuteFlightCB.getItemAt(arDurMinuteFlightCB.getSelectedIndex());
        String hoursDurationsScale = scDurHourFlightCB.getItemAt(scDurHourFlightCB.getSelectedIndex());
        String minutesDurationsScale = scDurMinuteFlightCB.getItemAt(scDurMinuteFlightCB.getSelectedIndex());

        Response response = FlightController.flightRegistration(id, planeId, departureLocationId, arrivalLocationId, scaleLocationId, year, month, day, hour, minutes, hoursDurationsArrival, minutesDurationsArrival, hoursDurationsScale, minutesDurationsScale);

        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);
            idFlightTextField.setText("");
            planeSelectComboBox.setSelectedIndex(0);
            depLocationCB.setSelectedIndex(0);
            arrivLocationCB.setSelectedIndex(0);
            scLocationCB.setSelectedIndex(0);
            departYearTextField.setText("");
            depMonthFlightTextField.setSelectedIndex(0);
            depDayFlightCB.setSelectedIndex(0);
            depHourFlightCB.setSelectedIndex(0);
            depMinuteFlightCB.setSelectedIndex(0);
            arDurHourCB.setSelectedIndex(0);
            arDurMinuteFlightCB.setSelectedIndex(0);
            scDurHourFlightCB.setSelectedIndex(0);
            scDurMinuteFlightCB.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btn_createFlightActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String id = idUpdateTextField.getText();
        String firstname = nameUpdateTextField.getText();
        String lastname = lastNameUpdateTextField.getText();
        String year = yearUpdateTextField.getText();
        String month = monthComboBox.getItemAt(monthUpdateCB.getSelectedIndex());
        String day = dayComboBox.getItemAt(dayUpdateCB.getSelectedIndex());
        String phoneCode = codCellUpdateTextField.getText();
        String phone = phoneUpdateTextField.getText();
        String country = countryUpdateTextField.getText();

        Response response = UpdatePassengerController.passengerUpdateRegistration(id, firstname, lastname, year, month, day, phoneCode, phone, country);
        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);
            idUpdateTextField.setText("");
            nameUpdateTextField.setText("");
            lastNameUpdateTextField.setText("");
            yearUpdateTextField.setText("");
            monthUpdateCB.setSelectedIndex(0);
            dayUpdateCB.setSelectedIndex(0);
            codCellUpdateTextField.setText("");
            phoneUpdateTextField.setText("");
            countryUpdateTextField.setText("");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddFlighActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFlighActionPerformed

        String passengerId = idPassTextField.getText();
        String flightId = idFlightCB.getItemAt(idFlightCB.getSelectedIndex());

        Response response = AddFlightToPassengerController.addFlight(passengerId, flightId);
        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);
            idPassTextField.setText("");
            idFlightCB.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnAddFlighActionPerformed

    private void btnDelayFlightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelayFlightActionPerformed

        String flightId = idFlightDelayCB.getItemAt(idFlightDelayCB.getSelectedIndex());
        String hours = hourDelayCB.getItemAt(hourDelayCB.getSelectedIndex());
        String minutes = minutesDelayCB.getItemAt(minutesDelayCB.getSelectedIndex());

        Response response = DelayFlightController.delayFlight(flightId, hours, minutes);
        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);
            idFlightDelayCB.setSelectedIndex(0);
            hourDelayCB.setSelectedIndex(0);
            minutesDelayCB.setSelectedIndex(0);
        }

    }//GEN-LAST:event_btnDelayFlightActionPerformed

    private void btnRefrescarMyFlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarMyFlightsActionPerformed
        // Response response = FlightTableController.updateFlightTable((DefaultTableModel) flightTable.getModel()); 
    }//GEN-LAST:event_btnRefrescarMyFlightsActionPerformed

    private void btnRefreshPassengersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshPassengersActionPerformed
        Response response = PassengerTableController.updatePassengerTable((DefaultTableModel) passengerTable.getModel());
    }//GEN-LAST:event_btnRefreshPassengersActionPerformed

    private void btnRefreshFlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshFlightsActionPerformed
        Response response = FlightTableController.updateFlightTable((DefaultTableModel) flightsTable.getModel());
        if (response.getStatus() >= 500) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.ERROR_MESSAGE);
        } else if (response.getStatus() >= 400) {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Error " + response.getStatus(), JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, response.getMessage(), "Response Message", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_btnRefreshFlightsActionPerformed

    private void btnRefreshPlanesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshPlanesActionPerformed
        Response response = PlaneTableController.updatePlaneTable((DefaultTableModel) planesTable.getModel());
    }//GEN-LAST:event_btnRefreshPlanesActionPerformed

    private void btnRefreshLocationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshLocationsActionPerformed
        Response response = LocationTableController.updateLocationTable((DefaultTableModel) locationTable.getModel());
    }//GEN-LAST:event_btnRefreshLocationsActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void userSelectComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSelectComboBoxActionPerformed
        try {
            String id = userSelectComboBox.getSelectedItem().toString();
            if (!id.equals(userSelectComboBox.getItemAt(0))) {
                idUpdateTextField.setText(id);
                idPassTextField.setText(id);
            } else {
                idUpdateTextField.setText("");
                idPassTextField.setText("");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_userSelectComboBoxActionPerformed

    private void idUserTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idUserTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idUserTextFieldActionPerformed

    private void depLocationCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depLocationCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depLocationCBActionPerformed

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Administration;
    private javax.swing.JPanel AirplaneRegistration;
    private javax.swing.JPanel addFlight;
    private javax.swing.JRadioButton administratorRB;
    private javax.swing.JLabel airlineAirplaneLabel;
    private javax.swing.JTextField airlineAirplaneTextField;
    private javax.swing.JLabel airportCityLabel;
    private javax.swing.JTextField airportCityTextField;
    private javax.swing.JLabel airportCountryLabel;
    private javax.swing.JTextField airportCountryTextField;
    private javax.swing.JLabel airportLatitudLabel;
    private javax.swing.JTextField airportLatitudTextField;
    private javax.swing.JLabel airportLongitudeLabel;
    private javax.swing.JTextField airportLongitudeTextField;
    private javax.swing.JLabel airportNameLabel;
    private javax.swing.JTextField airportNameTextField;
    private javax.swing.JComboBox<String> arDurHourCB;
    private javax.swing.JComboBox<String> arDurMinuteFlightCB;
    private javax.swing.JLabel arDurationFlightLabel;
    private javax.swing.JComboBox<String> arrivLocationCB;
    private javax.swing.JLabel arrivLocationLabel;
    private javax.swing.JLabel birthdateLabel;
    private javax.swing.JLabel brandAirplaneLabel;
    private javax.swing.JTextField brandTextField;
    private javax.swing.JButton btnAddFligh;
    private javax.swing.JButton btnCreateAirplane;
    private javax.swing.JButton btnDelayFlight;
    private javax.swing.JButton btnRefrescarMyFlights;
    private javax.swing.JButton btnRefreshFlights;
    private javax.swing.JButton btnRefreshLocations;
    private javax.swing.JButton btnRefreshPassengers;
    private javax.swing.JButton btnRefreshPlanes;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btn_createAirport;
    private javax.swing.JButton btn_createFlight;
    private javax.swing.JLabel cellphoneLabel;
    private javax.swing.JLabel codCellLabel;
    private javax.swing.JTextField codCellUpdateTextField;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JTextField countryTextField;
    private javax.swing.JTextField countryUpdateTextField;
    private javax.swing.JComboBox<String> dayComboBox;
    private javax.swing.JLabel dayLabel;
    private javax.swing.JComboBox<String> dayUpdateCB;
    private javax.swing.JPanel delayFlight;
    private javax.swing.JComboBox<String> depDayFlightCB;
    private javax.swing.JComboBox<String> depHourFlightCB;
    private javax.swing.JComboBox<String> depLocationCB;
    private javax.swing.JLabel depLocationLabel;
    private javax.swing.JComboBox<String> depMinuteFlightCB;
    private javax.swing.JComboBox<String> depMonthFlightTextField;
    private javax.swing.JTextField departYearTextField;
    private javax.swing.JLabel departureDateLabel;
    private javax.swing.JLabel departureLocationLabel;
    private javax.swing.JPanel flightRegistration;
    private javax.swing.JTable flightsTable;
    private javax.swing.JComboBox<String> hourDelayCB;
    private javax.swing.JLabel idAirplaneLabel;
    private javax.swing.JTextField idAirplaneTextField;
    private javax.swing.JLabel idAirportLabel;
    private javax.swing.JTextField idAirportTextField;
    private javax.swing.JTextField idCellTextField;
    private javax.swing.JComboBox<String> idFlightCB;
    private javax.swing.JComboBox<String> idFlightDelayCB;
    private javax.swing.JLabel idFlightLabel;
    private javax.swing.JTextField idFlightTextField;
    private javax.swing.JTextField idPassTextField;
    private javax.swing.JTextField idUpdateTextField;
    private javax.swing.JLabel idUserLabel;
    private javax.swing.JTextField idUserTextField;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTextField lastNameUpdateTextField;
    private javax.swing.JPanel locationRegistration;
    private javax.swing.JTable locationTable;
    private javax.swing.JTextField maxCapAirplaneTextField;
    private javax.swing.JLabel maxCapLabel;
    private javax.swing.JComboBox<String> minutesDelayCB;
    private javax.swing.JLabel modelAirplaneLabel;
    private javax.swing.JTextField modelAirplaneTextField;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JLabel monthLabel;
    private javax.swing.JComboBox<String> monthUpdateCB;
    private javax.swing.JTable myFlighsTable;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField nameUpdateTextField;
    private core.views.PanelRound panelRound1;
    private core.views.PanelRound panelRound2;
    private core.views.PanelRound panelRound3;
    private javax.swing.JTabbedPane pantalla;
    private javax.swing.JPanel passangerRegistration;
    private javax.swing.JTable passengerTable;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JTextField phoneUpdateTextField;
    private javax.swing.JComboBox<String> planeSelectComboBox;
    private javax.swing.JTable planesTable;
    private javax.swing.JComboBox<String> scDurHourFlightCB;
    private javax.swing.JComboBox<String> scDurMinuteFlightCB;
    private javax.swing.JLabel scDurationFlightLabel;
    private javax.swing.JComboBox<String> scLocationCB;
    private javax.swing.JLabel scLocationLabel;
    private javax.swing.JPanel showAllFlights;
    private javax.swing.JPanel showAllLocations;
    private javax.swing.JPanel showAllPassenger;
    private javax.swing.JPanel showAllPlanes;
    private javax.swing.JPanel showMyFlights;
    private javax.swing.JPanel updateInfo;
    private javax.swing.JRadioButton userRB;
    private javax.swing.JComboBox<String> userSelectComboBox;
    private javax.swing.JTextField yearTextField;
    private javax.swing.JTextField yearUpdateTextField;
    // End of variables declaration//GEN-END:variables
}
