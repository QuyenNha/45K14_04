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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;
import model.Order;

/**
 *
 * @author Trong Thinh
 */
public class OrderDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public boolean add(Cart c) {

        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "insert into [Order] values(?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, c.getuId());
                ps.setString(2, c.getpId());
                ps.setInt(3, c.getAmount());

                if (ps.executeUpdate() > 0) {
                    return true;
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    public boolean update(Order c) {

        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "update [Order] set amount=? where pId=? and uid=?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, c.getAmount());
                ps.setString(3, c.getuId());
                ps.setString(2, c.getpId());

                if (ps.executeUpdate() > 0) {
                    return true;
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    public Order getByUIdAndPId(String uId, String pId) {

        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "select *from [order] where uid=? and pid=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, uId);
                ps.setString(2, pId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new Order(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    public int getCollectByCateId(String cateId) {

        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "select sum(amount) from [Order] \n"
                        + "where pID in(select pId from Product where cateid=?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, cateId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getInt(1);
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return -1;
    }

    public boolean deleteByCateId(String cateId) {

        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "delete from [Order] \n"
                        + "where pID in(select pId from Product where cateid=?)";
                ps = con.prepareStatement(sql);
              
                ps.setString(1, cateId);

                if (ps.executeUpdate() > 0) {
                    return true;
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

}
