/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

/**
 *
 * @author Trong Thinh
 */
public class CategoryDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Category> getList() {
        ArrayList<Category> result = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "select * from Category";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    result.add(new Category(rs.getString(1), rs.getString(2), rs.getInt(3)));
                }
                return result;
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

}
