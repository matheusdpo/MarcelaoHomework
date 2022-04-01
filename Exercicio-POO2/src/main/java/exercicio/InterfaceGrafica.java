package exercicio;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class InterfaceGrafica extends JFrame {
	private JLabel lblCodigo;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblIdade;
	private JTextField txtIdade;
	private JLabel lblRa;
	private JTextField txtRa;
	private JButton btnInserir;
	private JButton btnAtualizar;
	private JButton btnExcluir;
	private JTable tabela;
	final DefaultTableModel modelo;
	private Container tela;
	public CRUD controle = new CRUD();

	public InterfaceGrafica() {
		setSize(400, 500);
		setTitle("Cadastro de Aluno");
		tela = getContentPane();
		tela.setLayout(null);
		lblCodigo = new JLabel("Código:");
		lblNome = new JLabel("Nome:");
		lblIdade = new JLabel("Idade:");
		lblRa = new JLabel("RA:");
		lblCodigo.setBounds(10, 10, 80, 25);
		lblNome.setBounds(10, 45, 80, 25);
		lblIdade.setBounds(10, 85, 80, 25);
		lblRa.setBounds(10, 135, 80, 25);
		tela.add(lblCodigo);
		tela.add(lblNome);
		tela.add(lblIdade);
		tela.add(lblRa);
		JTextField txtCodigo = new JTextField();
		txtNome = new JTextField();
		txtIdade = new JTextField();
		txtRa = new JTextField();
		txtCodigo.setBounds(90, 10, 40, 25);
		txtNome.setBounds(90, 45, 150, 25);
		txtIdade.setBounds(90, 85, 40, 25);
		txtRa.setBounds(90, 135, 150, 25);
		tela.add(txtCodigo);
		tela.add(txtNome);
		tela.add(txtIdade);
		tela.add(txtRa);

		btnInserir = new JButton("Inserir");
		btnAtualizar = new JButton("Atualizar");
		btnExcluir = new JButton("Excluir");
		btnInserir.setBounds(10, 170, 100, 50);
		btnAtualizar.setBounds(110, 170, 100, 50);
		btnExcluir.setBounds(210, 170, 100, 50);
		tela.add(btnInserir);
		tela.add(btnAtualizar);
		tela.add(btnExcluir);
		modelo = new DefaultTableModel();
		tabela = new JTable(modelo);
		modelo.addColumn("Código");
		modelo.addColumn("Nome");
		modelo.addColumn("Idade");
		modelo.addColumn("RA");
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(10, 240, 300, 200);
		tela.add(painel);
		carregarDados();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnInserir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.cadastrarAluno(txtNome.getText(), Integer.parseInt(txtIdade.getText()), txtRa.getText());
				carregarDados();
			}
		});

		btnAtualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controle.atualizarAluno(Integer.parseInt(txtCodigo.getText()), txtNome.getText(),
						Integer.parseInt(txtIdade.getText()), txtRa.getText());
				carregarDados();
			}
		});

		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controle.excluirAluno(Integer.parseInt(txtCodigo.getText()));
				carregarDados();
			}

		});
	}

	private void carregarDados() {
		modelo.setNumRows(0);
		try {
			ResultSet dados = controle.carregarAlunos();
			while (dados.next()) {
				int id = dados.getInt("id_aluno");
				String nome = dados.getString("nome");
				int idade = dados.getInt("idade");
				String ra = dados.getString("ra");
				modelo.addRow(new Object[] { new Integer(id), nome, new Integer(idade), ra });
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		InterfaceGrafica tela1 = new InterfaceGrafica();
		System.out.println("Iniciando");
	}
}