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
import model.Product;

/**
 *
 * @author Trong Thinh
 */
public class ProductDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Product> getList() {
        ArrayList<Product> result = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "select * from Product";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    result.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
                }
                return result;
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    public ArrayList<Product> getListByCateogry(String cId) {
        ArrayList<Product> result = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "select * from Product where cateId=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, cId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    result.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
                }
                return result;
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    public Product getById(String pId) {

        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "select * from Product where pId=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, pId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    public boolean addProduct(String id, String name, String image, int price, String des, String cate) {
        try {
            DBContext db = new DBContext();
            con = db.getConnection();

            if (con != null) {
                String sql = "Insert into product values(?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setString(3, image);
                ps.setInt(4, price);
                ps.setString(5, des);
                ps.setString(6, cate);
                int row = ps.executeUpdate();
                if (row > 0) {
                    return true;
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    public Product getProduct(String id) {
        ArrayList<Product> result = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "select * from Product where pId=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {
                    return (new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
                }
                return null;
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    public boolean deleteProduct(String id) {
        try {
            DBContext db = new DBContext();
            con = db.getConnection();

            if (con != null) {
                String sql = "DELETE FROM Feedback where pId=?\n"
                        + "DELETE FROM Cart where pId=?\n"
                        + "DELETE FROM product where pId=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                ps.setString(2, id);
                ps.setString(3, id);
                int row = ps.executeUpdate();
                if (row > 0) {
                    return true;
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    public void updateProduct(String id, String name, String image, int price, String des, String cate) {
        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "update product set [name] = ?, [image] = ?, price=?,description=?,cateID=? where [pID] = ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, image);
                ps.setInt(3, price);
                ps.setString(4, des);
                ps.setString(5, cate);
                ps.setString(6, id);
                ps.executeQuery();
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
