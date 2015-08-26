package br.com.acommerce.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum SearchableTable {
	PUBLISHER{
		@Override
		public ResultSet executeQuery(Connection connection, String query) throws SQLException {
			String sql = "select b.* from book b join publisher p on p.id = b.publisher_id where p.name like ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+query+"%");
			return preparedStatement.executeQuery();
		}
	},
	AUTHOR{
		@Override
		public ResultSet executeQuery(Connection connection, String query) throws SQLException {
			String sql = "select b.* from book b join book_author ab on ab.book_id = b.id join author a on a.id = ab.author_id where a.name like ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+query+"%");
			return preparedStatement.executeQuery();
		}
	},
	BOOK{
		@Override
		public ResultSet executeQuery(Connection connection, String query) throws SQLException {
			String sql = "select * from book where name like ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+query+"%");
			return preparedStatement.executeQuery();
		}
	},
	CATEGORY{
		@Override
		public ResultSet executeQuery(Connection connection, String query) throws SQLException {
			String sql = "select b.* from book b join book_category bc on bc.book_id = b.id join category c on c.id = bc.category_id where c.name like ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+query+"%");
			return preparedStatement.executeQuery();
		}
	};


	public abstract ResultSet executeQuery(Connection connection, String query)  throws SQLException;
}
