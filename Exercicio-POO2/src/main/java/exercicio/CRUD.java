package exercicio;

import java.sql.*;

public class CRUD {
	private ClasseConexao conexao;

	public CRUD() {
		conexao = new ClasseConexao();
	}

	public boolean cadastrarAluno(String nome, int idade, String ra) {
		try {
			PreparedStatement comando = conexao.getConexao()
					.prepareStatement("INSERT INTO aluno (nome,idade,ra) VALUES (?,?,?)");
			comando.setString(1, nome);
			comando.setInt(2, idade);
			comando.setString(3, ra);
			return comando.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ResultSet carregarAlunos() {
		ResultSet dados = null;
		try {
			PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * from aluno");
			dados = comando.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dados;
	}

	public boolean atualizarAluno(int codigo, String nome, int idade, String ra) {
		try {
			PreparedStatement comando = conexao.getConexao()
					.prepareStatement("UPDATE aluno SET nome=?,idade=?,ra=? WHERE id_aluno=?");
			comando.setString(1, nome);
			comando.setInt(2, idade);
			comando.setString(3, ra);
			comando.setInt(4, codigo);
			return comando.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean excluirAluno(int codigo) {
		try {
			PreparedStatement comando = conexao.getConexao().prepareStatement("DELETE FROM aluno WHERE id_aluno=?");
			comando.setInt(1, codigo);
			return comando.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}