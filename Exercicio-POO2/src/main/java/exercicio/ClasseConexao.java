package exercicio;

import java.sql.Connection;
import java.sql.DriverManager;

public class ClasseConexao {
	private Connection conexao;
	private String URLBD = "jdbc:mysql://127.0.0.1:3306/cadastro";
	private String usuario = "root";
	private String senha = "yourpasswd";

	public ClasseConexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(URLBD, usuario, senha);

			System.out.println("          __   _,--=\"=--,_   __\n" + "         /  \\.\"    .-.    \"./  \\\n"
					+ "        /  ,/  _   : :   _  \\/` \\\n" + "        \\  `| /o\\  :_:  /o\\ |\\__/\n"
					+ "         `-'| :=\"~` _ `~\"=: |\n" + "            \\`     (_)     `/\n"
					+ "     .-\"-.   \\      |      /   .-\"-.\n" + ".---{     }--|  /,.-'-.,\\  |--{     }---.\n"
					+ " )  (_)_)_)  \\_/`~-===-~`\\_/  (_(_(_)  (\n" + "(         CONNECTED INTO MYSQL          )\n"
					+ " )                                     (\n" + "'---------------------------------------'\n"
					+ "\n");
		} catch (Exception ex) {
			System.out.println("                            _ ._  _ , _ ._\n"
					+ "                          (_ ' ( `  )_  .__)\n"
					+ "                        ( (  (    )   `)  ) _)\n"
					+ "                       (__ (_   (_ . _) _) ,__)\n"
					+ "                           `~~`\\ ' . /`~~`\n" + "                           ,::: ;   ; :::,\n"
					+ "                          ':::::::::::::::'\n"
					+ "     _________________________/_ __ \\________________________\n"
					+ "    |                                                         |\n"
					+ "    |                       CONNECTION FAILED                 |\n"
					+ "    |_________________________________________________________|\n" + "\n" + "\n" + "");
			ex.printStackTrace();

		}
	}

	public Connection getConexao() {
		return conexao;
	}
}