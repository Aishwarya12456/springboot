
package com.javatechie.jdbcdemo.repository;


import com.javatechie.jdbcdemo.model.User;
import jakarta.persistence.EntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static java.lang.System.in;

@Repository
@Transactional //fot rollback
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final EntityManager entityManager;

    public UserRepository(JdbcTemplate jdbcTemplate, EntityManager entityManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager = entityManager;
    }

    //CREATE

    public void createUser(com.javatechie.jdbcdemo.model.User user) {
        //String sql = "INSERT INTO tbl_users(name, email) VALUES(?, ?)";
        //jdbcTemplate.update(sql, user.getName(), user.getEmail());
        entityManager.persist(user);
    }
    //READ
    public List<User> findAll() {
        //return jdbcTemplate.query("SELECT * FROM tbl_users", userRowMapper);
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    //    private RowMapper<User> userRowMapper = new RowMapper<User>() {
//        @Override
//        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//            User user = new User();
//            user.setId(rs.getInt("id"));
//            user.setName(rs.getString("name"));
//            user.setEmail(rs.getString("email"));
//            return user;
//        }
//    };
    //UPDATE
    public User findUserById(Integer id) {
        //String sql = "SELECT * FROM tbl_users WHERE id=?";
        //return jdbcTemplate.queryForObject(sql, userRowMapper, id);
        return entityManager.find(User.class, id);
    }

    public void update(User user) {
        //String sql = "UPDATE tbl_users SET name=?, email=? WHERE id=?";
        //jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getId());
        entityManager.merge(user);
    }
    //DELETE
    public void deleteUser(Integer id) {
        //String sql = "DELETE FROM tbl_users WHERE id=?";
        //jdbcTemplate.update(sql, id);
        User existingUser = entityManager.find(User.class, id);
        entityManager.remove(existingUser);
    }



}
