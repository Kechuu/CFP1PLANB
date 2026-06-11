package JPanelWebCam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Reemplazo de JPanelWebCam que permite subir una foto desde el disco.
 */
public class JPanelWebCam extends JPanel {

    private byte[] imageBytes = null;
    private JLabel lblFoto;
    private JButton btnSeleccionar;
    private JLabel lblTexto;

    public JPanelWebCam() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(5, 5));
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(160, 160));

        // Label para mostrar la foto
        lblFoto = new JLabel();
        lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
        lblFoto.setVerticalAlignment(SwingConstants.CENTER);
        lblFoto.setPreferredSize(new Dimension(150, 120));
        lblFoto.setBackground(new Color(230, 230, 230));
        lblFoto.setOpaque(true);

        // Texto inicial
        lblTexto = new JLabel("Sin foto", SwingConstants.CENTER);
        lblTexto.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblFoto.add(lblTexto);

        // Botón para seleccionar foto
        btnSeleccionar = new JButton("Seleccionar foto");
        btnSeleccionar.setBackground(new Color(38, 86, 186));
        btnSeleccionar.setForeground(Color.WHITE);
        btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarFoto();
            }
        });

        add(lblFoto, BorderLayout.CENTER);
        add(btnSeleccionar, BorderLayout.SOUTH);
    }

    private void seleccionarFoto() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccionar foto");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Imágenes (JPG, PNG, GIF)", "jpg", "jpeg", "png", "gif");
        chooser.setFileFilter(filter);

        int resultado = chooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            try {
                // Leer bytes del archivo
                FileInputStream fis = new FileInputStream(archivo);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int len;
                while ((len = fis.read(buf)) != -1) {
                    bos.write(buf, 0, len);
                }
                fis.close();
                imageBytes = bos.toByteArray();

                // Mostrar imagen en el label
                Image img = ImageIO.read(archivo);
                Image imgEscalada = img.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
                lblFoto.setText("");
                lblFoto.setIcon(new ImageIcon(imgEscalada));

            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Error al cargar la imagen: " + ex.getMessage());
            }
        }
    }

    /**
     * Devuelve los bytes de la imagen seleccionada.
     * Si no se seleccionó ninguna, devuelve un array vacío.
     */
    public byte[] getBytes() {
        if (imageBytes == null) {
            return new byte[0];
        }
        return imageBytes;
    }

    /**
    * Carga una imagen desde bytes (para mostrar foto existente al modificar).
    */
    public void setImagen(byte[] bytes) {
        if (bytes != null && bytes.length > 0) {
            try {
                imageBytes = bytes;
                java.io.ByteArrayInputStream bis = new java.io.ByteArrayInputStream(bytes);
                Image img = ImageIO.read(bis);
                if (img != null) {
                    Image imgEscalada = img.getScaledInstance(150, 120, Image.SCALE_SMOOTH);
                    lblFoto.setText("");
                    lblFoto.setIcon(new ImageIcon(imgEscalada));
                }
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Error al mostrar la imagen: " + ex.getMessage());
            }
        }
    }
    
    /**
     * Limpia la foto seleccionada.
     */
    public void limpiar() {
        imageBytes = null;
        lblFoto.setIcon(null);
        lblFoto.setText("Sin foto");
    }
}
