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
import model.Cart;

/**
 *
 * @author Trong Thinh
 */
public class CartDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public Cart get(String uId, String pId) {

        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "select * from Cart where uid=? and pid=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, uId);
                ps.setString(2, pId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new Cart(rs.getString(1), rs.getString(2), rs.getInt(3));
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    public boolean add(String uId, String pId) {

        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "insert into Cart values(?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, uId);
                ps.setString(2, pId);
                ps.setInt(3, 1);
                if (ps.executeUpdate() > 0) {
                    return true;
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    public boolean updade(String uId, String pId, int amount) {

        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "update Cart set amount=? where pId=? and uid=?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, amount);
                ps.setString(2, pId);
                ps.setString(3, uId);
                if (ps.executeUpdate() > 0) {
                    return true;
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    public int getTotal(String uid) {

        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = " select sum(amount) from cart where uid=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, uid);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt(1);
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return -1;
    }

    public ArrayList<Cart> getListByUId(String uId) {
        ArrayList<Cart> result= new ArrayList<>();
        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "select * from Cart where uid=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, uId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    result.add( new Cart(rs.getString(1), rs.getString(2), rs.getInt(3)));
                }
                return result;

            }
        } catch (Exception ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }
     public boolean delete(String uId, String pId) {

        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "delete from Cart where pId=? and uid=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, pId);
                ps.setString(2, uId);
                if (ps.executeUpdate() > 0) {
                    return true;
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

}
