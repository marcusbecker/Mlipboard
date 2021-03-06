/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvbos.mlipboard;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;

/**
 *
 * @author Marcus Becker
 */
public class Window extends javax.swing.JFrame {

    private int count;
    private final Timer timer;
    private Robot robo;
    private final Clipboard clipboard;

    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private final static int FILE_TAB = 0;
    private final static int IMAGE_TAB = 1;

    private ImageIcon icon;
    private BufferedImage lastIcon;

    private static final String IMAGEM_EXT = ".jpg";
    private static final String IMAGEM_NOME = "imagem_%d.jpg";

    private static final List<ImageIcon> images = new ArrayList<>(20);

    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();
        try {
            robo = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

        clipboard = toolkit.getSystemClipboard();

        Integer val = (Integer) printTimer.getValue();

        try {
            count = new File(".").listFiles((File pathname) -> pathname.isFile() && pathname.getName().endsWith(IMAGEM_EXT)).length + 1;
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }

        timer = new Timer(val, (ActionEvent e) -> {
            if (cbAutoPrint.isSelected()) {
                print();
            }
        });
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        pnText = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        taResult = new javax.swing.JTextArea();
        pnImage = createPanel();
        pnBottomBar = new javax.swing.JPanel();
        cbAutoLoad = new javax.swing.JCheckBox();
        btnPaste = new javax.swing.JButton();
        cbAutoPrint = new javax.swing.JCheckBox();
        printTimer = new javax.swing.JSpinner();
        cbHideWindow = new javax.swing.JCheckBox();
        btnPrint = new javax.swing.JButton();
        cbQuality = new javax.swing.JComboBox();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meu Clipboard");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        taResult.setColumns(20);
        taResult.setRows(5);
        sp.setViewportView(taResult);

        javax.swing.GroupLayout pnTextLayout = new javax.swing.GroupLayout(pnText);
        pnText.setLayout(pnTextLayout);
        pnTextLayout.setHorizontalGroup(
            pnTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnTextLayout.setVerticalGroup(
            pnTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane.addTab("Plain text", pnText);

        pnImage.setBackground(new java.awt.Color(51, 204, 255));

        javax.swing.GroupLayout pnImageLayout = new javax.swing.GroupLayout(pnImage);
        pnImage.setLayout(pnImageLayout);
        pnImageLayout.setHorizontalGroup(
            pnImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );
        pnImageLayout.setVerticalGroup(
            pnImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Screen Images", pnImage);

        cbAutoLoad.setText("Auto load");

        btnPaste.setText("Paste");
        btnPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasteActionPerformed(evt);
            }
        });

        cbAutoPrint.setText("Auto Print");
        cbAutoPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAutoPrintActionPerformed(evt);
            }
        });

        printTimer.setToolTipText("Number of shots per second");
        printTimer.setValue(1);
        printTimer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                printTimerStateChanged(evt);
            }
        });

        cbHideWindow.setText("Hide on print");

        btnPrint.setText("Print and Save");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        cbQuality.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "100%", "90%", "80%", "70%", "60%", "50%", "40%", "30%", "20%", "10%" }));
        cbQuality.setToolTipText("Image quality");

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBottomBarLayout = new javax.swing.GroupLayout(pnBottomBar);
        pnBottomBar.setLayout(pnBottomBarLayout);
        pnBottomBarLayout.setHorizontalGroup(
            pnBottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbAutoLoad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPaste, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAutoPrint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHideWindow)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbQuality, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnBottomBarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnPaste, btnPrint});

        pnBottomBarLayout.setVerticalGroup(
            pnBottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBottomBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnBottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAutoLoad)
                    .addComponent(btnPaste)
                    .addComponent(btnPrint)
                    .addComponent(cbAutoPrint)
                    .addComponent(btnClear)
                    .addComponent(cbHideWindow)
                    .addComponent(printTimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbQuality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
            .addComponent(pnBottomBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnBottomBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasteActionPerformed
        paste();

    }//GEN-LAST:event_btnPasteActionPerformed


    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        print();

    }//GEN-LAST:event_btnPrintActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if (cbAutoLoad.isSelected()) {
            paste();
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void cbAutoPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAutoPrintActionPerformed
        btnPrint.setEnabled(!cbAutoPrint.isSelected());
    }//GEN-LAST:event_cbAutoPrintActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        taResult.setText(null);
    }//GEN-LAST:event_btnClearActionPerformed

    private void printTimerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_printTimerStateChanged

        Integer value = (Integer) printTimer.getValue();
        if (value < 1) {
            printTimer.setValue(1);
        } else if (value > 60) {
            printTimer.setValue(60);
        }

        timer.stop();
        timer.setDelay(((Integer) printTimer.getValue()) * 1000);
        timer.start();

    }//GEN-LAST:event_printTimerStateChanged

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        repaintLastImage();
    }//GEN-LAST:event_formWindowStateChanged

    private void repaintLastImage() {
        if (lastIcon != null) {
            createIcon(lastIcon);
        }
    }

    private void print() throws HeadlessException {
        if (robo != null) {
            boolean hide = cbHideWindow.isSelected() && !cbAutoPrint.isSelected();

            if (hide) {
                this.setVisible(false);

                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            Dimension screenSize = toolkit.getScreenSize();
            BufferedImage print = robo.createScreenCapture(new Rectangle(screenSize));
            pasteImageCompressed(print);
            setTab(IMAGE_TAB);

            if (hide) {
                this.setVisible(true);
            }
        }
    }

    private JTabbedPane setTab(int tab) {
        jTabbedPane.setSelectedIndex(tab);
        return jTabbedPane;
    }

    private void paste() {
        try {
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                taResult.append("\n");
                taResult.append(clipboard.getData(DataFlavor.stringFlavor).toString());
                setTab(FILE_TAB);

            } else if (clipboard.isDataFlavorAvailable(DataFlavor.javaFileListFlavor)) {
                List<File> files = (List<File>) clipboard.getData(DataFlavor.javaFileListFlavor);
                pasteFiles(files);
                setTab(FILE_TAB);

            } else if (clipboard.isDataFlavorAvailable(DataFlavor.imageFlavor)) {
                setTab(IMAGE_TAB);
                pasteImageCompressed((BufferedImage) clipboard.getData(DataFlavor.imageFlavor));
            }

        } catch (UnsupportedFlavorException | IOException ufe) {
            Logger.getLogger(getClass().getName()).log(null, null, ufe);
        }
    }

    private void pasteImageCompressed(BufferedImage image) {
        createIcon(image);

        final File fImg = new File(String.format(IMAGEM_NOME, count));

        try {
            String val = cbQuality.getSelectedItem().toString().replaceAll("%", "");
            float quality = Float.parseFloat(val) / 100f;

            JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(null);
            jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            jpegParams.setCompressionQuality(quality);

            final ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
            final FileImageOutputStream fios = new FileImageOutputStream(fImg);
            writer.setOutput(fios);
            writer.write(null, new IIOImage(image, null, null), jpegParams);
            writer.dispose();
            fios.close();

            ++count;
            taResult.append("\nImagem salva em: " + fImg.getAbsolutePath());

        } catch (IOException ex) {
            Logger.getLogger(Window.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createIcon(BufferedImage image) {
        // with and height
        final int w = image.getWidth();
        final int h = image.getHeight();

        //new width and height
        int nw = pnImage.getWidth();
        int nh = pnImage.getHeight();

        if (w > h) {
            nh = h * nw / w;
        } else {
            nw = w * nh / h;
        }

        lastIcon = image;

        Image temp = image.getScaledInstance(nw, nh, Image.SCALE_SMOOTH);
        BufferedImage buffer = new BufferedImage(nw, nh, BufferedImage.TYPE_INT_ARGB);

        Graphics g = buffer.createGraphics();
        g.drawImage(temp, 0, 0, null);
        g.dispose();

        //images.add(new ImageIcon(image));
        icon = new ImageIcon(buffer);
        pnImage.repaint();
    }

    private JPanel createPanel() {
        return new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (icon != null) {
                    g.drawImage(icon.getImage(), 0, 0, null);
                }
            }

        };
    }

    private void pasteImage(BufferedImage image) {
        createIcon(image);

        File fImg = new File(String.format(IMAGEM_NOME, count));
        try {
            ImageIO.write(image, "jpg", fImg);
            ++count;
            taResult.append("\nImagem salva em: " + fImg.getAbsolutePath());

        } catch (IOException ex) {
            Logger.getLogger(Window.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void pasteFiles(List<File> files) {
        if (files.size() == 1) {
            taResult.append(files.get(0).getAbsolutePath());
            taResult.append("\n");
            taResult.append(files.get(0).getName());
        } else {

            taResult.append("Caminho completo com ';':\n");
            files.forEach((File f) -> {
                taResult.append(f.getAbsolutePath());
                taResult.append(";");
            });

            taResult.append("\nNomes com ';':\n");

            files.forEach((File f) -> {
                taResult.append(f.getName());
                taResult.append(";");
            });

            taResult.append("\n");
            taResult.append("\nCaminho completo:\n");

            files.forEach((File f) -> {
                taResult.append(f.getAbsolutePath());
                taResult.append("\n");
            });

            taResult.append("\nNomes:\n");

            files.forEach((File f) -> {
                taResult.append(f.getName());
                taResult.append("\n");
            });
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnPaste;
    private javax.swing.JButton btnPrint;
    private javax.swing.JCheckBox cbAutoLoad;
    private javax.swing.JCheckBox cbAutoPrint;
    private javax.swing.JCheckBox cbHideWindow;
    private javax.swing.JComboBox cbQuality;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JPanel pnBottomBar;
    private javax.swing.JPanel pnImage;
    private javax.swing.JPanel pnText;
    private javax.swing.JSpinner printTimer;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTextArea taResult;
    // End of variables declaration//GEN-END:variables
}
