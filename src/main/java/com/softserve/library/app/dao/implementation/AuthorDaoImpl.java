package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dao.interfaces.AuthorDao;
import com.softserve.library.app.dao.statement.AuthorStatementExecutor;
import com.softserve.library.app.enums.sql.AuthorSQL;
import com.softserve.library.app.model.Author;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class AuthorDaoImpl implements AuthorDao {

    private final AuthorStatementExecutor authorStatementExecutor = new AuthorStatementExecutor();
    private boolean isSuccess;

    @Override public Author get(int id) throws SQLException {

        List<Author> list = authorStatementExecutor.getAllByOption(id + "");

        return list != null && !list.isEmpty() ? list.get(0) : null;
    }
    @Override public Author getByName(String name) throws SQLException {

        List<Author> list = authorStatementExecutor.getAllByOption("author.full_name=" + wrapper(name));

        return list != null && !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public int addAndGetIdBack(Author author) throws SQLException {

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(AuthorSQL.INSERT.getSQL(), Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, author.getName());
        isSuccess = preparedStatement.executeUpdate() > 0;

        if (isSuccess) {

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getInt(1);
        }

        return 0;
    }

    @Override
    public boolean add(Author t) throws SQLException {
        return false;
    }
    @Override
    public boolean delete(int id) throws SQLException {

        return authorStatementExecutor.delete(id);
    }
    @Override
    public boolean update(Author author) throws SQLException {

        return authorStatementExecutor.update(author);
    }

    private String wrapper(String param) {

        return "'" + param + "'";
    }
}
