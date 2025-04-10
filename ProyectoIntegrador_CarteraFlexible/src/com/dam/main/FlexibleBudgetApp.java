package com.dam.main;

import javax.swing.*;
import java.awt.*;

public class FlexibleBudgetApp {
	
	 static JFrame ventanaPrincipal;

 public static void main(String[] args) {
     SwingUtilities.invokeLater(() -> mostrarMenuPrincipal());
 }

 public static void mostrarLoginInicial() {
     ventanaPrincipal = new JFrame("Flexible Budget - Bienvenido");
     ventanaPrincipal.setBounds(100, 100, 400, 250);
     ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     ventanaPrincipal.setLayout(new BorderLayout());

     JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
     panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

     JLabel bienvenida = new JLabel("Bienvenido a Flexible Budget", SwingConstants.CENTER);
     bienvenida.setFont(new Font("SansSerif", Font.BOLD, 20));
     ventanaPrincipal.add(bienvenida, BorderLayout.NORTH);

     JButton iniciar = new JButton("Iniciar Sesión");
     JButton registrar = new JButton("Registrarse");

     iniciar.setBackground(new Color(70, 130, 180));
     iniciar.setForeground(Color.WHITE);
     registrar.setBackground(new Color(60, 179, 113));
     registrar.setForeground(Color.WHITE);

     iniciar.addActionListener(e -> {
         ventanaPrincipal.dispose();
         mostrarLogin();
     });
     registrar.addActionListener(e -> {
         ventanaPrincipal.dispose();
         mostrarRegistro();
     });

     panel.add(iniciar);
     panel.add(registrar);
     ventanaPrincipal.add(panel, BorderLayout.CENTER);
     ventanaPrincipal.setVisible(true);
 }

 public static void mostrarMenuPrincipal() {
     JFrame frame = new JFrame("Flexible Budget - Menú Principal");
     frame.setBounds(100, 100, 600, 700);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.getContentPane().setLayout(new BorderLayout());

     JLabel lblTitulo = new JLabel("Flexible Budget", SwingConstants.CENTER);
     lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 30));
     lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
     frame.getContentPane().add(lblTitulo, BorderLayout.NORTH);

     JPanel centerPanel = new JPanel();
     centerPanel.setLayout(new GridLayout(9, 1, 10, 10));
     centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 80, 10, 80));

     String[] opciones = {
         "Dashboard", "Nuevo Ingreso", "Nuevo Gasto", "Recomendaciones",
         "Artículos Educativos", "Gestión de Grupos", "Cerrar Sesión"
     };
     Runnable[] acciones = {
         () -> mostrarDashboard(), () -> mostrarFormularioIngreso(),
         () -> mostrarFormularioGasto(), () -> mostrarRecomendaciones(),
         () -> mostrarArticulosEducativos(), () -> mostrarGrupo(),
         () -> {
             frame.dispose();
             mostrarLoginInicial();
         }
     };

     for (int i = 0; i < opciones.length; i++) {
         JButton boton = new JButton(opciones[i]);
         boton.setFont(new Font("SansSerif", Font.PLAIN, 16));
         int finalI = i;
         boton.addActionListener(e -> acciones[finalI].run());
         centerPanel.add(boton);
     }

     frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
     frame.setVisible(true);
 }


 public static void mostrarDashboard() {
     JFrame frame = new JFrame("Flexible Budget - Panel Principal");
     frame.setBounds(100, 100, 1200, 700);
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     frame.setLayout(new BorderLayout());

     // Panel lateral
     JPanel sidePanel = new JPanel();
     sidePanel.setLayout(new GridLayout(5, 1));
     sidePanel.setPreferredSize(new Dimension(200, 700));
     sidePanel.setBackground(new Color(220, 235, 250));

     String[] menu = {"Dashboard", "Ingresos", "Gastos", "Inversiones"};
     for (String item : menu) {
         JButton btn = new JButton(item);
         btn.setFocusPainted(false);
         btn.setFont(new Font("SansSerif", Font.PLAIN, 16));
         sidePanel.add(btn);
     }

     // Panel principal
     JPanel mainPanel = new JPanel();
     mainPanel.setLayout(new GridLayout(2, 2, 10, 10));
     mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

     JLabel saldoLabel = new JLabel("Saldo total: €5.200,00", SwingConstants.CENTER);
     saldoLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
     saldoLabel.setOpaque(true);
     saldoLabel.setBackground(new Color(240, 255, 255));

     JLabel mesLabel = new JLabel("Este mes: €1.200,00", SwingConstants.CENTER);
     mesLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
     mesLabel.setOpaque(true);
     mesLabel.setBackground(new Color(255, 255, 240));

     JLabel graficoLabel = new JLabel("[Gráfico de balance mensual]", SwingConstants.CENTER);
     graficoLabel.setOpaque(true);
     graficoLabel.setBackground(new Color(230, 230, 250));

     JLabel categoriasLabel = new JLabel("[Gastos por categoría]", SwingConstants.CENTER);
     categoriasLabel.setOpaque(true);
     categoriasLabel.setBackground(new Color(250, 240, 230));

     mainPanel.add(saldoLabel);
     mainPanel.add(mesLabel);
     mainPanel.add(graficoLabel);
     mainPanel.add(categoriasLabel);

     frame.add(sidePanel, BorderLayout.WEST);
     frame.add(mainPanel, BorderLayout.CENTER);
     frame.setVisible(true);
 }

 public static void mostrarLogin() {
     JFrame frame = new JFrame("Iniciar Sesión");
     frame.setBounds(100, 100, 400, 350);
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     frame.setLayout(new BorderLayout());

     JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
     panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

     JTextField correo = new JTextField();
     JPasswordField contrasena = new JPasswordField();
     JPasswordField confirmar = new JPasswordField();

     correo.setBorder(BorderFactory.createTitledBorder("Correo Electrónico"));
     contrasena.setBorder(BorderFactory.createTitledBorder("Contraseña"));
     confirmar.setBorder(BorderFactory.createTitledBorder("Confirmar Contraseña"));

     panel.add(correo);
     panel.add(contrasena);
     panel.add(confirmar);

     JButton iniciar = new JButton("Iniciar Sesión");
     iniciar.setBackground(new Color(70, 130, 180));
     iniciar.setForeground(Color.WHITE);
     panel.add(iniciar);

     iniciar.addActionListener(e -> {
         frame.dispose();
         mostrarMenuPrincipal();
     });

     frame.add(panel, BorderLayout.CENTER);
     frame.setVisible(true);
 }

 public static void mostrarRegistro() {
     JFrame frame = new JFrame("Registro de Usuario");
     frame.setBounds(100, 100, 400, 600);
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     frame.setLayout(new BorderLayout());

     JPanel panel = new JPanel(new GridLayout(7, 1, 10, 10));
     panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

     JTextField nombre = new JTextField();
     JTextField correo = new JTextField();
     JPasswordField contrasena = new JPasswordField();
     JTextField telefono = new JTextField();
     JTextField edad = new JTextField();
     JTextField dni = new JTextField();

     nombre.setBorder(BorderFactory.createTitledBorder("Nombre"));
     correo.setBorder(BorderFactory.createTitledBorder("Correo Electrónico"));
     contrasena.setBorder(BorderFactory.createTitledBorder("Contraseña"));
     telefono.setBorder(BorderFactory.createTitledBorder("Número de Teléfono"));
     edad.setBorder(BorderFactory.createTitledBorder("Edad"));
     dni.setBorder(BorderFactory.createTitledBorder("DNI"));

     panel.add(nombre);
     panel.add(correo);
     panel.add(contrasena);
     panel.add(telefono);
     panel.add(edad);
     panel.add(dni);

     JButton registrar = new JButton("Registrarse");
     registrar.setBackground(new Color(70, 130, 180));
     registrar.setForeground(Color.WHITE);
     panel.add(registrar);

     registrar.addActionListener(e -> {
         frame.dispose();
         mostrarMenuPrincipal();
     });

     frame.add(panel, BorderLayout.CENTER);
     frame.setVisible(true);
 }

 
 public static void mostrarFormularioIngreso() {
     JFrame frame = new JFrame("Nuevo Ingreso");
     frame.setBounds(100, 100, 400, 350);
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     frame.setLayout(new BorderLayout());

     JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
     panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

     JTextField fuente = new JTextField();
     JTextField cantidad = new JTextField();
     JTextField fecha = new JTextField();

     fuente.setBorder(BorderFactory.createTitledBorder("Fuente"));
     cantidad.setBorder(BorderFactory.createTitledBorder("Cantidad (€)"));
     fecha.setBorder(BorderFactory.createTitledBorder("Fecha (YYYY-MM-DD)"));

     panel.add(fuente);
     panel.add(cantidad);
     panel.add(fecha);

     JButton guardar = new JButton("Guardar Ingreso");
     guardar.setBackground(new Color(60, 179, 113));
     guardar.setForeground(Color.WHITE);
     panel.add(guardar);

     frame.add(panel, BorderLayout.CENTER);
     frame.setVisible(true);
 }

 public static void mostrarFormularioGasto() {
     JFrame frame = new JFrame("Nuevo Gasto");
     frame.setBounds(100, 100, 400, 350);
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     frame.setLayout(new BorderLayout());

     JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
     panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

     JTextField descripcion = new JTextField();
     JTextField categoria = new JTextField();
     JTextField cantidad = new JTextField();

     descripcion.setBorder(BorderFactory.createTitledBorder("Descripción"));
     categoria.setBorder(BorderFactory.createTitledBorder("Categoría"));
     cantidad.setBorder(BorderFactory.createTitledBorder("Cantidad (€)"));

     panel.add(descripcion);
     panel.add(categoria);
     panel.add(cantidad);

     JButton guardar = new JButton("Guardar Gasto");
     guardar.setBackground(new Color(220, 20, 60));
     guardar.setForeground(Color.WHITE);
     panel.add(guardar);

     frame.add(panel, BorderLayout.CENTER);
     frame.setVisible(true);
 }

 public static void mostrarRecomendaciones() {
     JFrame frame = new JFrame("Recomendaciones Financieras");
     frame.setBounds(100, 100, 500, 300);
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     frame.setLayout(new BorderLayout());

     JTextArea recomendaciones = new JTextArea("- Reduce gastos en ocio\n- Aprovecha promociones\n- Considera una inversión segura");
     recomendaciones.setEditable(false);
     recomendaciones.setFont(new Font("SansSerif", Font.PLAIN, 16));
     recomendaciones.setBorder(BorderFactory.createTitledBorder("Consejos para ti"));

     frame.add(recomendaciones, BorderLayout.CENTER);
     frame.setVisible(true);
 }

 public static void mostrarArticulosEducativos() {
     JFrame frame = new JFrame("Artículos Educativos");
     frame.setBounds(100, 100, 500, 400);
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     frame.setLayout(new BorderLayout());

     JTextArea articulos = new JTextArea("1. ¿Qué es un presupuesto flexible?\n2. Cómo invertir con bajo riesgo\n3. Aprende a dividir gastos en grupo");
     articulos.setEditable(false);
     articulos.setFont(new Font("SansSerif", Font.PLAIN, 16));
     articulos.setBorder(BorderFactory.createTitledBorder("Lecturas sugeridas"));

     frame.add(articulos, BorderLayout.CENTER);
     frame.setVisible(true);
 }

 public static void mostrarGrupo() {
     JFrame frame = new JFrame("Gestión de Grupos");
     frame.setBounds(100, 100, 500, 350);
     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     frame.setLayout(new BorderLayout());

     JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
     panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

     JTextField nombreGrupo = new JTextField();
     JTextField descripcion = new JTextField();
     JTextField miembros = new JTextField();

     nombreGrupo.setBorder(BorderFactory.createTitledBorder("Nombre del Grupo"));
     descripcion.setBorder(BorderFactory.createTitledBorder("Descripción"));
     miembros.setBorder(BorderFactory.createTitledBorder("Miembros (IDs separados por coma)"));

     panel.add(nombreGrupo);
     panel.add(descripcion);
     panel.add(miembros);

     JButton crearGrupo = new JButton("Crear Grupo");
     crearGrupo.setBackground(new Color(100, 149, 237));
     crearGrupo.setForeground(Color.WHITE);
     panel.add(crearGrupo);

     frame.add(panel, BorderLayout.CENTER);
     frame.setVisible(true);
 }
}

