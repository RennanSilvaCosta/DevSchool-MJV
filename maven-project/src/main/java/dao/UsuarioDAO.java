package dao;

import connectordb.FactoryConnector;

import java.sql.Connection;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO() {
        this.connection = FactoryConnector.getConnection();
    }

}
