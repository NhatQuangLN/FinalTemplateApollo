/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helpers.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import model.Account;
import model.Category;
import model.Exchange;
import model.Post;
import model.postFullList;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author truon
 */
public class DAO {

    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    public List<Account> getAllAccount() {
        List<Account> ls = new ArrayList<>();
        try {
            String query = "select * from Account";
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                //int accountID, String username, String userPassword, String userEmail,
                //String userFullname, boolean isAdmin, Date createDate, String facebookURL, String userImage
                ls.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getBoolean(6), rs.getDate(7), rs.getString(8), rs.getString(9)));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }

    public HashMap<String, String> getAllAccountUserPass() {
        HashMap<String, String> hm = new HashMap();
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement("select * from Account");
            rs = stm.executeQuery();
            while (rs.next()) {
                //int accountID, String username, String userPassword, String userEmail,
                //String userFullname, boolean isAdmin, Date createDate, String facebookURL, String userImage
                hm.put(rs.getString(2).trim()/*username*/, rs.getString(3).trim()/*password*/);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hm;
    }

    public boolean insertAccount(String username, String email, String fullname, String password) throws SQLException, NamingException, Exception {
//        try {
//            
//            con = DBUtils.makeConnection();
//            if (con != null) {
//                String sql = "insert into "
//                        + "Account(username,userPassword,userEmail,userFullname,isAdmin,createDate,facebookURL,userImage)"
//                        + " values(?,?,?,?,0,?,'','')";
//                stm = con.prepareStatement(sql);
//                stm.setString(1, username);
//                stm.setString(2, hash);
//                stm.setString(3, email);
//                stm.setString(4, fullname);
//                stm.setString(5, LocalDateTime.now().toString());
//                int row = stm.executeUpdate();
//                System.out.println(row);
////                return row;
//            }
//            con.close();
//        } catch (Exception e) {
//        }
//        return -5;
        try {
            con = DBUtils.makeConnection();
            String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
            if (con != null) {
                String sql = "insert into "
                        + "Account(username,userPassword,userEmail,userFullname,isAdmin,createDate,facebookURL,userImage)"
                        + " values(?,?,?,?,0,?,'','')";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, hash);
                stm.setString(3, email);
                stm.setString(4, fullname);
                stm.setString(5, LocalDateTime.now().toString());
                int row = stm.executeUpdate();
//                System.out.println(row);
                if (row > 0) {
                    return true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    public void AddCategory(String name, String url) {
        String query = "insert into Category(categoryName,categoryIcon) values\n"
                + "(?,?)";
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, name);
            stm.setString(2, url);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCategory(String id) {
        String query = "delete Category where [categoryID] = ?";
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, id);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAccount(String id) {
        String query = "delete Account where [accountID] = ?";
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, id);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAdmin(String id, String isAdmin) {
        String query = "update Account set isAdmin = ? where accountID = ?";
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, isAdmin);
            stm.setString(2, id);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account getAccountByUserName(String username) throws Exception {
        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from [Account] where username = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, username);

                rs = stm.executeQuery();
                while (rs.next()) {
                    return new Account(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getBoolean(6),
                            rs.getDate(7),
                            rs.getString(8),
                            rs.getString(9));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return null;
    }

    public void deletePost(String id) {
        deleteCategoryPost(id);
        deletePostImage(id);
        String query = "delete Post where postID = ?";
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, id);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCategoryPost(String id) {
        String query = "delete CategoryPost where postID = ?";
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, id);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCategoryByPost(String id, ArrayList<String> list) {

        try {
            con = DBUtils.makeConnection();
            for (String string : list) {
                String query = "delete CategoryPost where postID = ? and categoryID = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, id);
                stm.setString(2, string);
                stm.executeUpdate();
            }

        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletePostImage(String id) {
        String query = "delete ProductImage where postID = ?";
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, id);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Post> getPostByID(int accountID) throws Exception {
        List<Post> listPostByID = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from Post where accountID = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, accountID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    listPostByID.add(new Post(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getDate(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7)));
                }
                return listPostByID;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return null;

    }

    public Post getPostByPostID(String accountID) throws Exception {
        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from Post where postID = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, accountID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    return (new Post(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getDate(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return null;

    }

    public int getMostLike() throws Exception {
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select top 1* from (\n"
                        + "select [postLike] from [dbo].[Post]) a\n"
                        + "order by  a.[postLike] desc";

                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return 0;
    }
//slideshop

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<String> getCategoryByPostID(String id) {
        ArrayList<String> list = new ArrayList<>();
        String query = "select categoryID from CategoryPost where postID = ?";
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<postFullList> getAllPost() throws Exception {
        List<postFullList> list = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from [dbo].[Post] a, [dbo].[Account] b where a.accountID = b.accountID";

                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new postFullList(rs.getInt(1),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(9),
                            rs.getString(16)));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public postFullList getlastPost() throws Exception {

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from [dbo].[Post] a, [dbo].[Account] b where a.accountID = b.accountID order by postID desc";

                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                    return (new postFullList(rs.getInt(1),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(9),
                            rs.getString(16)));
                }
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
//    home page ussing this method

    public List<Post> getLatestPostInHomePage() throws Exception {
        List<Post> listLastestPostInHomePage = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from [dbo].[Post] order by postID desc";

                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                    listLastestPostInHomePage.add(new Post(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getDate(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7)));
                }
                return listLastestPostInHomePage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public List<Post> getTopLikePostInHomePage() throws Exception {
        List<Post> listTopLikePostInHomePage = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from [dbo].[Post] order by postLike desc";

                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                    listTopLikePostInHomePage.add(new Post(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getDate(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7)));
                }
                return listTopLikePostInHomePage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public List<Post> getAllPostInHomePage() throws Exception {
        List<Post> listAllPostInHomePage = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from Post";

                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                    listAllPostInHomePage.add(new Post(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getDate(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7)));
                }
                return listAllPostInHomePage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public List<Exchange> getAllExchangeInManager() throws Exception {
        List<Exchange> listAllExchangeInHomePage = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from Exchange where exchangeState = 1";

                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                    listAllExchangeInHomePage.add(new Exchange(rs.getInt(1),
                            rs.getDate(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5)));
                }
                return listAllExchangeInHomePage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public List<Exchange> getAllExchangeInHomePage() throws Exception {
        List<Exchange> listAllExchangeInHomePage = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from Exchange where exchangeState = 1";

                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                    listAllExchangeInHomePage.add(new Exchange(rs.getInt(1),
                            rs.getDate(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5)));
                }
                return listAllExchangeInHomePage;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public int insertPost(int accountID, String postTitle, Timestamp postDate, String postDescription, String thumbnailURL) throws Exception {
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "insert into "
                        + "Post(accountID,postTitle,postDate,postDescription,postLike,thumbnailURL)"
                        + " values(?,?,?,?,0,?)";
                stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stm.setInt(1, accountID);
                stm.setString(2, postTitle);
                stm.setTimestamp(3, postDate);
                stm.setString(4, postDescription);
                stm.setString(5, thumbnailURL);

                int row = stm.executeUpdate();

                if (row == 0) {
                    return 0;
                }

                ResultSet generatedKeys = stm.getGeneratedKeys();

                if (generatedKeys.next()) {
                    int postID = generatedKeys.getInt(1); //get the key of the row after inserting
                    System.out.println("postID: " + postID);
                    return postID;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return -1;
    }

    public int insertCategoryPost(int PostID, String[] categoriesID) throws Exception {
        try {
            int successCounter = 0;
            con = DBUtils.makeConnection();
            if (con != null) {
                for (String catID : categoriesID) {
                    String sql = "insert into "
                            + "CategoryPost(PostID,categoryID)"
                            + " values (?,?)";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, PostID);
                    stm.setInt(2, Integer.parseInt(catID));
                    if (stm.executeUpdate() > 0) {
                        successCounter++;
                    }
                }
                return successCounter;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return 0;
    }

    public int insertCategoryPost(int PostID, ArrayList<String> categoriesID) throws Exception {
        try {
            int successCounter = 0;
            con = DBUtils.makeConnection();
            if (con != null) {
                for (String catID : categoriesID) {
                    String sql = "insert into "
                            + "CategoryPost(PostID,categoryID)"
                            + " values (?,?)";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, PostID);
                    stm.setInt(2, Integer.parseInt(catID));
                    if (stm.executeUpdate() > 0) {
                        successCounter++;
                    }
                }
                return successCounter;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return 0;
    }

    public int insertProductImage(int PostID, String[] imageURL) throws Exception {
        try {
            int successCounter = 0;
            con = DBUtils.makeConnection();
            if (con != null) {
                for (String imgURL : imageURL) {
                    String sql = "insert into "
                            + "ProductImage(PostID,imageURL)"
                            + " values(?,?)";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, PostID);
                    stm.setString(2, imgURL);
                    if (stm.executeUpdate() > 0) {
                        successCounter++;
                    }
                }
                return successCounter;
//            con = DBUtils.makeConnection();
//            if (con != null) {
//                String sql = "insert into "
//                        + "ProductImage(PostID,imageURL)"
//                        + " values(?,?)";
//                stm = con.prepareStatement(sql);
//                stm.setInt(1, PostID);
//                stm.setString(2, imageURL);
//                return stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return 0;
    }

    public void updatePost(String postID, String postTitle, String postDescription) throws Exception {
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "update Post set postTitle = ? , postDescription = ? where postID = ?";
                stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, postTitle);
                stm.setString(2, postDescription);
                stm.setString(3, postID);
                stm.executeQuery();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void updateCategory(String cid, String cname, String cic) throws Exception {

        String sql = "update Category set categoryName=?, categoryIcon = ? where  categoryID = ?";
        try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, cname);
            stm.setString(2, cic);
            stm.setString(3, cid);
            stm.executeQuery();
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<postFullList> getAllPostPopularity() throws Exception {
        List<postFullList> list = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from [dbo].[Post] a, [dbo].[Account] b\n"
                        + "						 where a.accountID = b.accountID order by a.postLike desc";

                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new postFullList(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(9),
                            rs.getString(16)));

                }
                return list;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public List<postFullList> getAllPostAtoZ() throws Exception {
        List<postFullList> list = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from [dbo].[Post] a, [dbo].[Account] b\n"
                        + "						 where a.accountID = b.accountID order by a.postTitle asc";

                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new postFullList(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(9),
                            rs.getString(16)));

                }
                return list;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public List<postFullList> getAllPostZtoA() throws Exception {
        List<postFullList> list = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from [dbo].[Post] a, [dbo].[Account] b\n"
                        + "						 where a.accountID = b.accountID order by a.postTitle desc";

                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new postFullList(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(9),
                            rs.getString(16)));

                }
                return list;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public postFullList showPostDetail(String id) throws SQLException {
        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from [dbo].[Post] a inner join  [dbo].[CategoryPost] b on a.postID = b.postID inner join  \n"
                        + "[dbo].[Category] c on b.categoryID = c.categoryID  inner join \n"
                        + "Account e on e.accountID = a.accountID where a.postID = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    return (new postFullList(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(14),
                            rs.getString(21),
                            rs.getInt(10),
                            rs.getString(11)));
                }
                return null;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return null;

    }

    public List<postFullList> suggestPostSameCategory(String name) throws SQLException {
        List<postFullList> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select top 4 * from [dbo].[Post] a inner join  [dbo].[CategoryPost] b on a.postID = b.postID \n"
                        + "inner join  [dbo].[Category] c on b.categoryID = c.categoryID \n"
                        + " where c.categoryName like ? order by NEWID()";

                stm = con.prepareStatement(sql);
                stm.setString(1, '%' + name + '%');
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new postFullList(rs.getInt(1),
                            rs.getInt(6),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(7)));
                }
                return list;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return null;

    }

    public List<postFullList> showCategoryPostDetail(String id) throws SQLException {
        List<postFullList> list = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from [dbo].[Post] a inner join  [dbo].[CategoryPost] b on a.postID = b.postID inner join \n"
                        + " [dbo].[Category] c on b.categoryID = c.categoryID  inner join \n"
                        + "Account e on e.accountID = a.accountID where a.postID = ? ";

                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new postFullList(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(14),
                            rs.getString(21),
                            rs.getInt(10),
                            rs.getString(11)));
                }
                return list;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return null;

    }

    public List<postFullList> getPostByCategory(String id) throws Exception {
        List<postFullList> list = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
//                where b.categoryID = 1
                String sql = "select * from [dbo].[Post] a inner join  [dbo].[CategoryPost] b on a.postID = b.postID \n"
                        + "inner join  [dbo].[Category] c on b.categoryID = c.categoryID \n"
                        + " inner join Account e on e.accountID = a.accountID where b.categoryID = ? ";

                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new postFullList(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(14),
                            rs.getString(21),
                            rs.getInt(10),
                            rs.getString(11)));
                }
                return list;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public List<postFullList> getAllPostSearch(String txt) throws Exception {
        List<postFullList> list = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from [dbo].[Post] a, [dbo].[Account] b\n"
                        + "						 where a.accountID = b.accountID and a.postTitle like ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, '%' + txt + '%');
                rs = stm.executeQuery();
                while (rs.next()) {
                    list.add(new postFullList(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getString(9),
                            rs.getString(16)));

                }
                return list;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
//    insert exchange but only one side (one person) accept two exchange
//    người secondPostID là người gửi lời exchange,  người firstPostId là người quyết định accpet exchange or not,
//    secondPostID người gửi, firstPostId người nhận quyết định

    public boolean createExchangeOnlyExceptOneSide(String firstPostID, String secondPostID) throws SQLException, NamingException, Exception {
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "insert into Exchange(postExchangeDate,firstPostID,secondPostID,exchangeState) values"
                        + "(?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, LocalDateTime.now().toString());
                stm.setString(2, firstPostID);
                stm.setString(3, secondPostID);
                stm.setInt(4, 0);
                int row = stm.executeUpdate();
//                System.out.println(row);
                if (row > 0) {
                    return true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }
//     lấy ra những post mà exchangeState là 0, là những post chưa chính thức exchange, để thông báo cho người chấp nhận để chấp nhận exchange
// người secondPostID là người gửi lời exchange,  người firstPostId là người quyết định accept exchange or not,

    public List<Exchange> getAllExchangeStateEqualZeroByID(int accountID) throws Exception {
        List<Exchange> listAllExchangeStateEqualZeroByID = new ArrayList<>();

        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select a.exchangeID, a.postExchangeDate, a.firstPostID, a.secondPostID, a.exchangeState\n"
                        + "from Exchange a, Post b\n"
                        + "where a.exchangeState = 0 and a.firstPostID = b.postID and b.accountID = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, accountID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    listAllExchangeStateEqualZeroByID.add(new Exchange(rs.getInt(1),
                            rs.getDate(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5)));

                }
                return listAllExchangeStateEqualZeroByID;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public boolean updateAcceptExchange(String exchangeID) throws SQLException, NamingException, Exception {
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "update Exchange set exchangeState = 1, postExchangeDate = ? where exchangeID = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, LocalDateTime.now().toString());
                stm.setString(2, exchangeID);
                int row = stm.executeUpdate();
//                System.out.println(row);
                if (row > 0) {
                    return true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    public boolean deleteExchange(String exchangeID) throws SQLException, NamingException, Exception {
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "delete from Exchange where exchangeID = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, exchangeID);
                int row = stm.executeUpdate();
//                System.out.println(row);
                return row > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    public String modifyPostLikeUser(int pid, int uid) throws SQLException {
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String check = "select * from PostLikeUsers where postID=? and accountID=?";
                System.out.println("pid=" + pid + " uid=" + uid);
                stm = con.prepareStatement(check);
                stm.setInt(1, pid);
                stm.setInt(2, uid);

                if (!stm.executeQuery().next()) {
                    String sql = "insert into PostLikeUsers(postID, accountID) values (?,?)";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, pid);
                    stm.setInt(2, uid);

                    int row = stm.executeUpdate();
                    return row > 0 ? "like true" : "like false";
                } else {
                    String sql = "delete from PostLikeUsers where postID=? and accountID=?";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, pid);
                    stm.setInt(2, uid);

                    int row = stm.executeUpdate();
                    return row > 0 ? "unlike true" : "unlike false";
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return "";
    }

    public int countLike(int pid) throws SQLException {
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select count(*) from PostLikeUsers where postID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, pid);

                rs = stm.executeQuery();
                if (rs.next()) {
                    int realLike = rs.getInt(1);
                    sql = "select postLike from Post where postID=?";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, pid);
                    rs = stm.executeQuery();

                    rs.next();
                    int fakeLike = rs.getInt(1);
                    System.out.println("fakeLike = " + fakeLike);
                    return realLike + fakeLike;
                } else {
                    return -1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return -1;
    }

    public List<Integer> getLikedPostByID(int uid) throws SQLException {
        try {
            System.out.println("uid: " + uid);
            con = DBUtils.makeConnection();
            List<Integer> result = new ArrayList();
            if (con != null) {
                String sql = "select postID from PostLikeUsers where accountID=?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, uid);

                rs = stm.executeQuery();

                while (rs.next()) {
                    result.add(rs.getInt(1));
                    System.out.println("have next" + result.get(result.size() - 1));
                }
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public Category ShowCategoryByID(String id) throws SQLException {
        try {
            con = DBUtils.makeConnection();

            if (con != null) {
                String sql = "select * from Category where categoryID = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    return (new Category(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3)));
                }
                return null;
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return null;
    }
/////////////////////////////////////////////////////////////

    public static void main(String[] args) throws Exception {
//        String username = "trang";
//        String password = "banana";
//        DAO dao = new DAO();
//        List<Account> list = dao.getAllAccount();
//        Account find = new Account();
//        boolean flag = true;
//        for (int i = 0; i < list.size() && flag; i++) {
//            if(list.get(i).getUsername().trim().equals(username.trim()) && list.get(i).getUserPassword().trim().equals(password.trim())){
//                find.setUsername(list.get(i).getUsername());
//                find.setUserPassword(list.get(i).getUserPassword());
//                System.out.println("Da toi");
//                flag = false;
//            }
//        }
//        if(flag){
//            System.out.println("Co cai nit");           
//        }else{
//            System.out.println(find.toString());          
//        }
        DAO dao = new DAO();
//        ArrayList<String> temp = dao.getCategoryByPostID("19");
//        for (String string : temp) {
//            System.out.println(string);
//        }
//        dao.updateAdmin("8", "0");
//        Post temp = dao.getPostByPostID("1");
//        System.out.println(temp.toString());
//        dao.insertAccount("HELLO", "TEST", "CHUOI", "132");
//        dao.deleteAccount("7");
//        List<Account> list = dao.getAllAccount();
//        for (Account account : list) {
//            System.out.println(account.toString());
//        }
//        System.out.println(dao.getPostByID(1));
//            System.out.println(dao.getAccountByUserName("quang"));
//        System.out.println(dao.getMostLike());
//        System.out.println(dao.getAllCategory());
//        System.out.println(dao.getlastPost());
//        System.out.println(dao.getAllExchangeInHomePage());
//        System.out.println(dao.insertAccount("quang123", "rollroyce230501@gmail.com", "Tôi abcded", "123456789"));
//dao.insertAccount("quang41551",  "quanglnnde150066@fpt.edu.vn", "Tôi abcded", "123456789");
//        String hash = BCrypt.hashpw("banana", BCrypt.gensalt(12));
//        System.out.println(hash);

//        System.out.println(dao.getAllExchangeStateEqualZeroByID(1));
//        System.out.println(dao.getAllPostInHomePage());
//            System.out.println(dao.getAllPost());
//        System.out.println(dao.ShowCategoryByID("1"));
        dao.updateCategory("20", "a", "111");
    }

}
