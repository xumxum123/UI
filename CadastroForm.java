package atvdia11do10.model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import atvdia11do10.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroForm extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;  // Alterado para JTextField
    private JRadioButton masculinoButton;
    private JRadioButton femininoButton;
    private JLabel resultadoLabel;

    public CadastroForm() {
        setTitle("Formulário de Cadastro");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Labels e Campos
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(15);
        
        JLabel idadeLabel = new JLabel("Idade:");
        idadeField = new JTextField(5);  // Inicialização do JTextField

        JLabel sexoLabel = new JLabel("Sexo:");
        masculinoButton = new JRadioButton("Masculino");
        femininoButton = new JRadioButton("Feminino");
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(masculinoButton);
        sexoGroup.add(femininoButton);

        JButton enviarButton = new JButton("Enviar");
        resultadoLabel = new JLabel("");

        // Adicionando os componentes à janela
        add(nomeLabel);
        add(nomeField);
        add(idadeLabel);
        add(idadeField);  // Adicionado JTextField
        add(sexoLabel);
        add(masculinoButton);
        add(femininoButton);
        add(enviarButton);
        add(resultadoLabel);

        // Ação do botão
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarDados();
            }
        });
    }

    private void enviarDados() {
        String nome = nomeField.getText();
        String idadeText = idadeField.getText();  // Captura a idade como String
        String sexo = masculinoButton.isSelected() ? "Masculino" : (femininoButton.isSelected() ? "Feminino" : "");

        // Validação
        if (nome.isEmpty() || idadeText.isEmpty() || sexo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tenta converter a idade para um inteiro
        int idade;
        try {
            idade = Integer.parseInt(idadeText);
            if (idade < 0 || idade > 120) {  // Validação da faixa etária
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma idade válida!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = new Cliente(nome, idade, sexo);
        resultadoLabel.setText(cliente.getResumo());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroForm form = new CadastroForm();
            form.setVisible(true);
        });
    }
}