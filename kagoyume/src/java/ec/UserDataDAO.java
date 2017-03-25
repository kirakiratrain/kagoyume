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
 * ユーザー�?報を�?�納するテーブルに対しての操作�?��?を包括する
 * DB接続系はDBManagerクラスに�?任
 * 基本�?には�?りた�?1種類�?�動作に対して1メソ�?�?
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコード�?�簡略�?
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * �?ータの挿入処�?を行う。現在時刻は挿入直前に生�??
     * @param ud 対応したデータを保持して�?るJavaBeans
     * @throws SQLException 呼び出し�??にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//�?定�?�タイ�?スタンプ�?�からSQL格納用のDATE型に変更
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
     * �?ータの更新を行う
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
            
            //上�?�方法と下�?�方法で値のセ�?トするフォーマットがわからな�?�?'がつ�?たりつかなかったりでどっちが正しいか不�??
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
     * �?ータの削除を行う
    
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
     * �?ータの検索処�?を行う�?
     * @param ud 対応したデータを保持して�?るJavaBeans
     * @throws SQLException 呼び出し�??にcatchさせるためにスロー 
     * @return 検索結果
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
            
            //修正�?�?2 対�?
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
             //修正�?�?2  ここで例外が発生する�???が�?個なのに変換しよ�?として�?るた�?
             
            st =  con.prepareStatement(sql);
            //コメントアウ�?
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

            
            //修正�?�?3 �?数の検索対象があった�?�合に�?初�?��?人しか表示しな�?様になって�?�?
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
     * ユーザーIDによる1件の�?ータの検索処�?を行う�?
     * @param ud 対応したデータを保持して�?るJavaBeans
     * @throws SQLException 呼び出し�??にcatchさせるためにスロー 
     * @return 検索結果
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
