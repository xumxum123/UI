package atvdia11do10.model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import atvdia11do10.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreferenciasUsuario extends JFrame {
    private JComboBox<String> temaComboBox;
    private JCheckBox notificacoesCheckBox;
    private JSlider volumeSlider;
    private JTextArea resultadoTextArea;
    private Usuario usuario;

    public PreferenciasUsuario() {
        setTitle("Configuração de Preferências");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes
        JLabel temaLabel = new JLabel("Tema:");
        temaComboBox = new JComboBox<>(new String[]{"Claro", "Escuro"});
        
        JLabel notificacoesLabel = new JLabel("Notificações:");
        notificacoesCheckBox = new JCheckBox();
        
        JLabel volumeLabel = new JLabel("Volume:");
        volumeSlider = new JSlider(0, 100, 50);
        
        JButton salvarButton = new JButton("Salvar");
        resultadoTextArea = new JTextArea(5, 20);
        resultadoTextArea.setEditable(false);
        
        // Adicionando componentes à janela
        add(temaLabel);
        add(temaComboBox);
        add(notificacoesLabel);
        add(notificacoesCheckBox);
        add(volumeLabel);
        add(volumeSlider);
        add(salvarButton);
        add(new JScrollPane(resultadoTextArea));

        // Ação do botão salvar
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarPreferencias();
            }
        });

        // Configurações iniciais
        atualizarTema();
    }

    private void salvarPreferencias() {
        String tema = (String) temaComboBox.getSelectedItem();
        boolean notificacoes = notificacoesCheckBox.isSelected();
        int volume = volumeSlider.getValue();

        usuario = new Usuario(tema, notificacoes, volume);
        resultadoTextArea.setText(usuario.toString());
        
        atualizarTema();  // Atualiza a cor do JFrame
    }

    private void atualizarTema() {
        String temaSelecionado = (String) temaComboBox.getSelectedItem();
        if ("Escuro".equals(temaSelecionado)) {
            getContentPane().setBackground(Color.DARK_GRAY);
            resultadoTextArea.setBackground(Color.LIGHT_GRAY);
            resultadoTextArea.setForeground(Color.BLACK);
        } else {
            getContentPane().setBackground(Color.LIGHT_GRAY);
            resultadoTextArea.setBackground(Color.WHITE);
            resultadoTextArea.setForeground(Color.BLACK);
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PreferenciasUsuario preferencias = new PreferenciasUsuario();
            preferencias.setVisible(true);
        });
    }
}
