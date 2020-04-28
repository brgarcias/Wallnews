package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;
import model.Noticia;

public class NoticiasDAO {

	public int criar(Noticia noticia) {
		
		int status = 0;
		
		String sqlInsert = "INSERT INTO noticia(descricao, titulo, texto) VALUES (?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, noticia.getDescricao());
			stm.setString(2, noticia.getTitulo());
			stm.setString(3, noticia.getTexto());
			int exec = stm.executeUpdate();
			if(exec == 1){
				status = 2;
			}else {
				status =  1;
			}
		} catch (SQLException e) {
			status =  1;
			e.printStackTrace();
		}
		return status;
	}

	public int criarComentario(Comentario comentario) {
		
		int status = 0;
		
		String sqlInsert = "INSERT INTO comentario(nome, texto, fk_noticia_id) VALUES (?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, comentario.getNome());
			stm.setString(2, comentario.getTexto());
			stm.setInt(3, comentario.getIdNoticia());
			int exec = stm.executeUpdate();
			if(exec == 1){
				status = 2;
			}else {
				status =  1;
			}
		} catch (SQLException e) {
			status =  1;
			e.printStackTrace();
		}
		return status;
	}

	
	public int atualizar(Noticia noticia) {
		int status = 0;
		String sqlUpdate = "UPDATE NOTICIA SET DESCRICAO = ?, TITULO = ?, TEXTO = ? WHERE ID = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, noticia.getDescricao());
			stm.setString(2, noticia.getTitulo());
			stm.setString(3, noticia.getTexto());
			stm.setInt(4, noticia.getId());
			int row =  stm.executeUpdate();
			if(row == 1)
				status = 1;
			else 
				status = 2;
		} catch (Exception e) {
			status = 3;
			e.printStackTrace();
		}
		return status;
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM NOTICIA WHERE ID = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirComentario(int id) {
		String sqlDelete = "DELETE FROM comentario WHERE fk_noticia_id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Noticia> listagem() {
		ArrayList<Noticia> noticia = new ArrayList<Noticia>();
		String sqlSelect = "SELECT id, descricao, titulo, texto FROM noticia";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				
				while (rs.next()) {
					Noticia nt = new Noticia();
					
					nt.setId(rs.getInt("id"));
					nt.setDescricao(rs.getString("descricao"));
					nt.setTitulo(rs.getString("titulo"));
					nt.setTexto(rs.getString("texto"));
					
					noticia.add(nt);
					
				}
				
				rs.close();
				stm.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return noticia;
	}
	
	
	public ArrayList<Comentario> listagemComentario(int id) {
		ArrayList<Comentario> comentario = new ArrayList<Comentario>();
		String sqlSelect = "SELECT * FROM COMENTARIO where FK_NOTICIA_ID = ? ";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, id);
				stm.execute();
			try (ResultSet rs = stm.executeQuery();) {
				
				while (rs.next()) {
					Comentario nt = new Comentario();
					
					nt.setIdComentario(rs.getInt("ID"));
					nt.setNome(rs.getString("NOME"));
					nt.setTexto(rs.getString("TEXTO"));
					nt.setIdNoticia(rs.getInt("FK_NOTICIA_ID"));
					comentario.add(nt);					
				}
				
				rs.close();
				stm.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return comentario;
	}
	
	public Noticia carregar(int id) {
		Noticia noticia = new Noticia();
		noticia.setId(id);
		String sqlSelect = "SELECT descricao, titulo, texto FROM noticia WHERE noticia.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, noticia.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					noticia.setDescricao(rs.getString("descricao"));
					noticia.setTitulo(rs.getString("titulo"));
					noticia.setTexto(rs.getString("texto"));
				} else {
					noticia.setId(-1);
					noticia.setDescricao(null);
					noticia.setTitulo(null);
					noticia.setTexto(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return noticia;
	}
}
