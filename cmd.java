package cmd_aparte;

import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Tomas Yuja
 */
public class cmd extends javax.swing.JFrame {

    File carpetainicial = new File(System.getProperty("user.dir"));
    String carpetaAct = carpetainicial.getAbsolutePath();

    public cmd() {
        initComponents();
        setLocationRelativeTo(null);
        jTextArea1.append("Carpeta actual: " + carpetaAct);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 700, 40));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 700, 450));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 390));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String command = jTextField1.getText();
            String[] tokens = command.split(" ");
            jTextArea1.append("\n" + carpetaAct + ">" + tokens[0]);
            File carpetaActual = new File(carpetaAct);

            switch (tokens[0]) {
                case "mkdir":
                    String nombreCarpeta = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));

                    String rutaNuevaCarpeta = carpetaActual.getAbsolutePath() + File.separator + nombreCarpeta;

                    File nuevaCarpeta = new File(rutaNuevaCarpeta);
                    if (nuevaCarpeta.mkdir()) {
                        jTextArea1.append("\nCarpeta creada: " + nuevaCarpeta.getAbsolutePath() + "\n");
                    } else {
                        jTextArea1.append("\nError al crear carpeta.\n");
                    }
                    break;

                case "rm":
                    String nombreCarpetaEliminar = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));

                    String rutaCarpetaAEliminar = carpetaActual.getAbsolutePath() + File.separator + nombreCarpetaEliminar;
                    File carpetaAEliminar = new File(rutaCarpetaAEliminar);

                    if (carpetaAEliminar.delete()) {
                        jTextArea1.append("\nCarpeta eliminada: " + carpetaAEliminar.getAbsolutePath() + "\n");
                    } else {
                        jTextArea1.append("\nError al eliminar carpeta\n");
                    }
                    break;

                case "cd":
                    String nombreCarpetaCD = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));

                    File carpetaACambiar = new File(carpetaActual, nombreCarpetaCD);
                    if (carpetaACambiar.isDirectory()) {
                        System.setProperty("user.dir", carpetaACambiar.getAbsolutePath());
                        carpetaAct = carpetaACambiar.getAbsolutePath();
                        jTextArea1.append("\nCarpeta actual: " + carpetaACambiar.getAbsolutePath() + "\n");
                    } else {
                        jTextArea1.append("\nError: " + nombreCarpetaCD + " no es una carpeta\n");
                    }
                    break;
                case "...":
                    File carpetaAnterior = carpetaActual.getParentFile();
                    if (carpetaAnterior != null) {
                        System.setProperty("user.dir", carpetaAnterior.getAbsolutePath());
                        carpetaAct = carpetaAnterior.getAbsolutePath();
                        jTextArea1.append("\nCarpeta actual: " + carpetaAnterior.getAbsolutePath() + "\n");
                    } else {
                        jTextArea1.append("\nError: No hay carpeta anterior\n");
                    }
                    break;
                case "help":
                    jTextArea1.append("\nComandos disponibles:\n");
                    jTextArea1.append("mkdir <nombreCarpeta>: Crear una nueva carpeta.\n");
                    jTextArea1.append("mfile<nombre.ext:nuevo archivo>\n");
                    jTextArea1.append("rm <nombreCarpeta>: Eliminar una carpeta.\n");
                    jTextArea1.append("cd <nombreCarpeta>: Cambiar al directorio especificado.\n");
                    jTextArea1.append("...: Retroceder al directorio padre.\n");
                    jTextArea1.append("dir: Mostrar lista de carpetas en el directorio actual.\n");
                    jTextArea1.append("date: Mostrar la fecha actual.\n");
                    jTextArea1.append("time: Mostrar la hora actual.\n");
                    jTextArea1.append("Escribir<wr>debe ingresar un texto al archivo\n");
                    jTextArea1.append("Leer<rd> debe seleccionar un archivo para mostrar lo que contiene.\n");
                    jTextArea1.append("help: Mostrar esta ayuda.\n");
                    break;

                case "dir":
                    File[] archivos = carpetaActual.listFiles();
                    Arrays.sort(archivos);

                    String formatoFecha = "yyyy-MM-dd HH:mm:ss";
                    SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);

                    String tabla = String.format("%-50s%-20s\n", "Nombre", "Fecha de creación");
                    tabla += "------------------------------------------------------------------\n";

                    for (File archivo : archivos) {
                        if (archivo.isDirectory()) {
                            String fecha = sdf.format(new Date(archivo.lastModified()));
                            tabla += String.format("%-50s%-20s\n", archivo.getName(), fecha);
                        }
                    }

                    jTextArea1.append("\n" + tabla);
                    break;

                case "date":
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Date date = new Date();
                    jTextArea1.append("\nFecha actual: " + dateFormat.format(date) + "\n");
                    break;
                case "time":
                    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    Date time = new Date();
                    jTextArea1.append("\nHora actual: " + timeFormat.format(time) + "\n");
                    break;
                default:
                    jTextArea1.append("\nError: comando invalido\n");
                    break;

                case "mfile":
                    String nombreArchivo = String.join(" ", Arrays.copyOfRange(tokens, 1, tokens.length));
                    String rutaNuevoArchivo = carpetaActual.getAbsolutePath() + File.separator + nombreArchivo;
                    File nuevoArchivo = new File(rutaNuevoArchivo);
                    try {
                        if (nuevoArchivo.createNewFile()) {
                            jTextArea1.append("\nArchivo creado: " + nuevoArchivo.getAbsolutePath() + "\n");
                        } else {
                            jTextArea1.append("\nEl archivo ya existe\n");
                        }
                    } catch (IOException e) {
                        jTextArea1.append("\nError al crear archivo\n");
                        e.printStackTrace();
                    }
                    break;

                case "escribir":
                    if (tokens.length < 3) {
                        jTextArea1.append("\nUso: escribir <nombreArchivo> <contenido>\n");
                    } else {
                        String nombreArchivoEscribir = tokens[1];
                        String contenido = String.join(" ", Arrays.copyOfRange(tokens, 2, tokens.length));
                        String rutaArchivoEscribir = carpetaActual.getAbsolutePath() + File.separator + nombreArchivoEscribir;
                        try (FileWriter writer = new FileWriter(rutaArchivoEscribir)) {
                            writer.write(contenido);
                            jTextArea1.append("\nContenido escrito en el archivo: " + nombreArchivoEscribir + "\n");
                        } catch (IOException e) {
                            jTextArea1.append("\nError al escribir en el archivo\n");
                            e.printStackTrace();
                        }
                    }
                    break;

                case "leer":
                    if (tokens.length < 2) {
                        jTextArea1.append("\nUso: leer <nombreArchivo>\n");
                    } else {
                        String nombreArchivoLeer = tokens[1];
                        String rutaArchivoLeer = carpetaActual.getAbsolutePath() + File.separator + nombreArchivoLeer;
                        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivoLeer))) {
                            String linea;
                            jTextArea1.append("\nContenido del archivo " + nombreArchivoLeer + ":\n");
                            while ((linea = reader.readLine()) != null) {
                                jTextArea1.append(linea + "\n");
                            }
                        } catch (IOException e) {
                            jTextArea1.append("\nError al leer el archivo\n");
                            e.printStackTrace();
                        }
                    }
                    break;

            }
            jTextField1.setText("");
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped

    }//GEN-LAST:event_jTextField1KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cmd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cmd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cmd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cmd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cmd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextField jTextField1;
    private java.awt.ScrollPane scrollPane1;
    private java.awt.ScrollPane scrollPane2;
    private java.awt.ScrollPane scrollPane3;
    private java.awt.ScrollPane scrollPane4;
    private java.awt.ScrollPane scrollPane5;
    private java.awt.ScrollPane scrollPane6;
    // End of variables declaration//GEN-END:variables
}
