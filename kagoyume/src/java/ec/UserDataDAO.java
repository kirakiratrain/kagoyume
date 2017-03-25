package ec;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * ã¦ã¼ã¶ã¼æ?å ±ãæ?¼ç´ãããã¼ãã«ã«å¯¾ãã¦ã®æä½å?¦ç?ãåæ¬ãã
 * DBæ¥ç¶ç³»ã¯DBManagerã¯ã©ã¹ã«ä¸?ä»»
 * åºæ¬ç?ã«ã¯ã?ããã?1ç¨®é¡ã?®åä½ã«å¯¾ãã¦1ã¡ã½ã?ã?
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //ã¤ã³ã¹ã¿ã³ã¹ãªãã¸ã§ã¯ããè¿å´ããã¦ã³ã¼ãã?®ç°¡ç¥å?
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * ã?ã¼ã¿ã®æ¿å¥å¦ç?ãè¡ããç¾å¨æå»ã¯æ¿å¥ç´åã«çæ??
     * @param ud å¯¾å¿ãããã¼ã¿ãä¿æãã¦ã?ãJavaBeans
     * @throws SQLException å¼ã³åºãå??ã«catchãããããã«ã¹ã­ã¼ 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//æ?å®ã?®ã¿ã¤ã?ã¹ã¿ã³ãå?¤ããSQLæ ¼ç´ç¨ã®DATEåã«å¤æ´
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }
        finally
        {
            if(con != null)
            {
                con.close();
            }
        }

    }
    /**
     * ã?ã¼ã¿ã®æ´æ°ãè¡ã
     * 
     * 
     * 
     */
        //profilesID, name,tell,age,birthday
    UserDataDTO updateDataAll(UserDataDTO updateData
                       )throws SQLException
    {
        String ret;

       
        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
            
//            String sql = "update user_t set name = " + "'" + updateData.getName() + "'";
//            java.sql.Date sqlDate = new java.sql.Date(updateData.getBirthday().getTime());
//            sql += ",birthday = " +  "'" + sqlDate.toString() + "'";
//            sql += ",tell = " + "'" + updateData.getTell()+ "'";
//            sql += ",type = " + updateData.getType();
//            sql += ",comment = "  + "'" + updateData.getComment()+ "'";
//            String strNewDate = new Timestamp(System.currentTimeMillis()).toString();
//            sql += ",newDate = "  + "'" + new Timestamp(System.currentTimeMillis()).toString()+ "'";
//            sql += " where userID = " + updateData.getUserID() + ';';
//            st =  con.prepareStatement(sql);
//            int num = st.executeUpdate();
            
            //ä¸ã?®æ¹æ³ã¨ä¸ã?®æ¹æ³ã§å¤ã®ã»ã?ããããã©ã¼ããããããããªã?ã?'ãã¤ã?ããã¤ããªãã£ããã§ã©ã£ã¡ãæ­£ãããä¸æ??
            String sql = "update user_t set name = " + "?";
            java.sql.Date sqlDate = new java.sql.Date(updateData.getBirthday().getTime());
            sql += ",birthday = " +  "?";
            sql += ",tell = " + "?";
            sql += ",type = ?";
            //sql += ",comment = " + "'?'";
            sql += ",comment = ?";
            sql += ",newDate = ?";
            sql += " where userID = ?";
            
            
            st =  con.prepareStatement(sql);
            st.setString(1, updateData.getName());
            st.setDate(2, sqlDate);
            st.setString(3, updateData.getTell());
            st.setInt(4, updateData.getType());
            st.setString(5,updateData.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, updateData.getUserID());

            int num = st.executeUpdate();
            
            sql = "SELECT * FROM user_t where userID =" + updateData.getUserID() ;
            st =  con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("Update completed");

            return resultUd;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }
        finally
        {
            if(con != null)
            {
                con.close();
            }
        }
    }
    
    
    /**
     * ã?ã¼ã¿ã®åé¤ãè¡ã
    
    */
     public void delete(UserDataDTO deleteData) throws SQLException
     {
        UserDataDTO resultUd = new UserDataDTO();
        String sql = "delete from  user_t where userID =" + deleteData.getUserID() + ';';
        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
           
            st =  con.prepareStatement(sql);
            int num = st.executeUpdate();
            
            
            System.out.println("Update completed");

        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }
        finally
        {
            if(con != null)
            {
                con.close();
            }
        }
            
     }
    /**
     * ã?ã¼ã¿ã®æ¤ç´¢å¦ç?ãè¡ãã?
     * @param ud å¯¾å¿ãããã¼ã¿ãä¿æãã¦ã?ãJavaBeans
     * @throws SQLException å¼ã³åºãå??ã«catchãããããã«ã¹ã­ã¼ 
     * @return æ¤ç´¢çµæ
     */
    public UserDataDTO search(UserDataDTO ud) throws SQLException
    {
        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
            //
            String sql = "SELECT * FROM user_t";
            boolean flag = false;
            int[] saerchTarget = {0,0,0};
            
            //ä¿®æ­£ç®?æ?2 å¯¾ç­?
            if (!ud.getName().equals("")) 
            {
                sql += " WHERE name like ?";
                flag = true;
                saerchTarget[0] = 1;
            }
            if (ud.getBirthday()!=null) 
            {
                if(!flag)
                {
                    sql += " WHERE birthday like ?";
                    flag = true;
                }
                else
                {
                    sql += " AND birthday like ?";
                }
                saerchTarget[1] = 1;
            }
            if (ud.getType()!=0)
            {
                if(!flag)
                {
                    sql += " WHERE type like ?";
                }
                else
                {    
                    sql += " AND type like ?";
                }
                saerchTarget[2] = 1;
            }
             //ä¿®æ­£ç®?æ?2  ããã§ä¾å¤ãçºçããã???ãä¸?åãªã®ã«å¤æããã?ã¨ãã¦ã?ããã?
             
            st =  con.prepareStatement(sql);
            //ã³ã¡ã³ãã¢ã¦ã?
//            st.setString(1, "%"+ud.getName()+"%");
//            st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
//            st.setInt(3, ud.getType());
            
            int cnt = 1;
            if(saerchTarget[0]== 1) 
            {
               st.setString(cnt, "%"+ud.getName()+"%");
               cnt++;
            }
            if(saerchTarget[1]== 1)
            {
                st.setString(cnt, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                cnt++;
            }
            if(saerchTarget[2]== 1)
            {
                st.setInt(cnt, ud.getType());
            }

            
            //ä¿®æ­£ç®?æ?3 è¤?æ°ã®æ¤ç´¢å¯¾è±¡ããã£ãå?´åã«æ?åã?®ä¸?äººããè¡¨ç¤ºããªã?æ§ã«ãªã£ã¦ã?ã?
            ResultSet rs = st.executeQuery();
            UserDataDTO resultUd = new UserDataDTO();
            while(rs.next())
            {
                //UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                resultUd.setBirthday(rs.getDate(3));
                resultUd.setTell(rs.getString(4));
                resultUd.setType(rs.getInt(5));
                resultUd.setComment(rs.getString(6));
                resultUd.setNewDate(rs.getTimestamp(7));
            }
            
            System.out.println("search completed");

            return resultUd;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }
        finally
        {
            if(con != null)
            {
                con.close();
            }
        }

    }
    
    /**
     * ã¦ã¼ã¶ã¼IDã«ãã1ä»¶ã®ã?ã¼ã¿ã®æ¤ç´¢å¦ç?ãè¡ãã?
     * @param ud å¯¾å¿ãããã¼ã¿ãä¿æãã¦ã?ãJavaBeans
     * @throws SQLException å¼ã³åºãå??ã«catchãããããã«ã¹ã­ã¼ 
     * @return æ¤ç´¢çµæ
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
}
