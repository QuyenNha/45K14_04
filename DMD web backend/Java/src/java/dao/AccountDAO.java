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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Trong Thinh
 */
public class AccountDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public Account login(String u, String p) {
        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "select * from Account where uId=? and password=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, u);
                ps.setString(2, p);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                }
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
        return null;
    }
    public List<Account> getListAccount() {
        List<Account> list = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "select * from Account";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                }
            }
            return list;
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
        return null;
    }

    public void insertAccount(String uId, String paswrod, String name, String type) {
        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "insert Account values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, uId);
                ps.setString(2, paswrod);
                ps.setString(3, name);
                ps.setString(4, type);
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

    public void deleteAccount(String uId) {
        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "delete from Cart where uID = ?\n"
                        + "delete from [Order] where uID = ?\n"
                        + "delete from Account where uID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, uId);
                ps.setString(2, uId);
                ps.setString(3, uId);
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
    
    public void updateAccount(String name, String type, String uID) {
        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "update Account set [name] = ?, [type] = ? where [uID] = ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, type);
                ps.setString(3, uID);
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

    public Account getAccountByID(String uID) {
        try {
            DBContext db = new DBContext();
            con = db.getConnection();
            if (con != null) {
                String sql = "select * from Account where uId=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, uID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                }
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
        return null;
    }
    

}
