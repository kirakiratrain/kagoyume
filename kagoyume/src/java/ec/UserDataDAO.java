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
 * 繝ｦ繝ｼ繧ｶ繝ｼ諠?蝣ｱ繧呈?ｼ邏阪☆繧九ユ繝ｼ繝悶Ν縺ｫ蟇ｾ縺励※縺ｮ謫堺ｽ懷?ｦ逅?繧貞桁諡ｬ縺吶ｋ
 * DB謗･邯夂ｳｻ縺ｯDBManager繧ｯ繝ｩ繧ｹ縺ｫ荳?莉ｻ
 * 蝓ｺ譛ｬ逧?縺ｫ縺ｯ繧?繧翫◆縺?1遞ｮ鬘槭?ｮ蜍穂ｽ懊↓蟇ｾ縺励※1繝｡繧ｽ繝?繝?
 * @author hayashi-s
 */
public class UserDataDAO 
{
    
    final private String tblName = "user_t";
    //繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ繧ｪ繝悶ず繧ｧ繧ｯ繝医ｒ霑泌唆縺輔○縺ｦ繧ｳ繝ｼ繝峨?ｮ邁｡逡･蛹?
    public static UserDataDAO getInstance()
    {
        return new UserDataDAO();
    }
    

    
    /**
     * 繝?繝ｼ繧ｿ縺ｮ謖ｿ蜈･蜃ｦ逅?繧定｡後≧縲ら樟蝨ｨ譎ょ綾縺ｯ謖ｿ蜈･逶ｴ蜑阪↓逕滓??
     * @param ud 蟇ｾ蠢懊＠縺溘ョ繝ｼ繧ｿ繧剃ｿ晄戟縺励※縺?繧徽avaBeans
     * @throws SQLException 蜻ｼ縺ｳ蜃ｺ縺怜??縺ｫcatch縺輔○繧九◆繧√↓繧ｹ繝ｭ繝ｼ 
     */
    public void insert(UserDataDTO ud) throws SQLException
    {
        Connection con = null;
        PreparedStatement st = null;
      
        try
        {
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO "+ tblName +"(name,password,mail,address,total,newDate,deleteFlg)"
                    + " VALUES(?,?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            //st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//謖?螳壹?ｮ繧ｿ繧､繝?繧ｹ繧ｿ繝ｳ繝怜?､縺九ｉSQL譬ｼ邏咲畑縺ｮDATE蝙九↓螟画峩
            st.setString(2, ud.getPass());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress()); 
            st.setInt(5, ud.getTotal());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, ud.getDeleteFlg());
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
     * 繝?繝ｼ繧ｿ縺ｮ譖ｴ譁ｰ繧定｡後≧
     * 
     * 
     * 
     */
        //profilesID, name,tell,age,birthday
    UserDataDTO updateDataAll(UserDataDTO ud
                       )throws SQLException
    {
        String ret;

       
        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
            
            st =  con.prepareStatement("INSERT INTO "+ tblName +"(name,password,mail,address,total,newDate,deleteFlg)" + " VALUES(?,?,?,?,?,?)");
            
            //荳翫?ｮ譁ｹ豕輔→荳九?ｮ譁ｹ豕輔〒蛟､縺ｮ繧ｻ繝?繝医☆繧九ヵ繧ｩ繝ｼ繝槭ャ繝医′繧上°繧峨↑縺?縲?'縺後▽縺?縺溘ｊ縺､縺九↑縺九▲縺溘ｊ縺ｧ縺ｩ縺｣縺｡縺梧ｭ｣縺励＞縺倶ｸ肴??
            String sql = "update user_t set name = " + "?";
            //java.sql.Date sqlDate = new java.sql.Date(getTime());   //修正中
            sql += ",password = " +  "?";
            sql += ",mail = " + "?";
            sql += ",address = ?";
            sql += ",total = ?";
            sql += ",newDate = ?";
            sql += ",deleteFlg = ?";
            sql += " where userID = ?";
            
            
            st =  con.prepareStatement(sql);
            st.setString(1, ud.getName());
            st.setString(2, ud.getPass());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setInt(5, ud.getTotal());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, ud.getDeleteFlg());
            st.setInt(8, ud.getUserID());

            int num = st.executeUpdate();
            
            sql = "SELECT * FROM user_t where userID =" + ud.getUserID() ;
            st =  con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setPass(rs.getString(3));
            resultUd.setMail(rs.getString(4));
            resultUd.setAddress(rs.getString(5));
            resultUd.setTotal(rs.getInt(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            resultUd.setDeleteFlg(rs.getInt(8));
            
            
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
     * 繝?繝ｼ繧ｿ縺ｮ蜑企勁繧定｡後≧
    
    */
//     public void delete(UserDataDTO deleteData) throws SQLException
//     {
//        //UserDataDTO resultUd = new UserDataDTO();
//        String sql = "delete from  user_t where userID =" + deleteData.getUserID() + ';';
//        Connection con = null;
//        PreparedStatement st = null;
//        try
//        {
//            con = DBManager.getConnection();
//           
//            st =  con.prepareStatement(sql);
//            int num = st.executeUpdate();
//            
//            
//            System.out.println("Update completed");
//
//        }
//        catch(SQLException e)
//        {
//            System.out.println(e.getMessage());
//            throw new SQLException(e);
//        }
//        finally
//        {
//            if(con != null)
//            {
//                con.close();
//            }
//        }
//            
//     }
     
     public void delete(UserDataDTO deleteData) throws SQLException
     {
        String ret;

        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
             
            String sql = "update user_t set deleteFlg = " + "?";
            sql += " where userID = ?";
            
            //ここにアクセスした段階で、IDによる削除が実行される（外部キー制約により直接DELETEは
            //できないので、削除フラグを0から1に変更する）
            st =  con.prepareStatement(sql);
            st.setInt(1, 1);
            st.setInt(2, deleteData.getUserID());
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
     * 繝?繝ｼ繧ｿ縺ｮ讀懃ｴ｢蜃ｦ逅?繧定｡後≧縲?
     * @param ud 蟇ｾ蠢懊＠縺溘ョ繝ｼ繧ｿ繧剃ｿ晄戟縺励※縺?繧徽avaBeans
     * @throws SQLException 蜻ｼ縺ｳ蜃ｺ縺怜??縺ｫcatch縺輔○繧九◆繧√↓繧ｹ繝ｭ繝ｼ 
     * @return 讀懃ｴ｢邨先棡
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
            
            //菫ｮ豁｣邂?謇?2 蟇ｾ遲?
            if (!ud.getName().equals("")) 
            {
                sql += " WHERE name like ?";
                flag = true;
                saerchTarget[0] = 1;
            }
            /*
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
            }*/
            
            /*
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
            }*/
            
             //菫ｮ豁｣邂?謇?2  縺薙％縺ｧ萓句､悶′逋ｺ逕溘☆繧九???縺御ｸ?蛟九↑縺ｮ縺ｫ螟画鋤縺励ｈ縺?縺ｨ縺励※縺?繧九◆繧? 
            st =  con.prepareStatement(sql);
            
            int cnt = 1;
            if(saerchTarget[0]== 1) 
            {
               st.setString(cnt, "%"+ud.getName()+"%");
               cnt++;
            }
            if(saerchTarget[1]== 1)
            {
                //st.setString(cnt, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                cnt++;
            }
            if(saerchTarget[2]== 1)
            {
                //st.setInt(cnt, ud.getType());
            }

            
            //菫ｮ豁｣邂?謇?3 隍?謨ｰ縺ｮ讀懃ｴ｢蟇ｾ雎｡縺後≠縺｣縺溷?ｴ蜷医↓譛?蛻昴?ｮ荳?莠ｺ縺励°陦ｨ遉ｺ縺励↑縺?讒倥↓縺ｪ縺｣縺ｦ縺?繧?
            ResultSet rs = st.executeQuery();
            UserDataDTO resultUd = new UserDataDTO();
            while(rs.next())
            {
                //UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                //resultUd.setBirthday(rs.getDate(3));
                //resultUd.setTell(rs.getString(4));
                //resultUd.setType(rs.getInt(5));
                //resultUd.setComment(rs.getString(6));
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
     * 繝ｦ繝ｼ繧ｶ繝ｼID縺ｫ繧医ｋ1莉ｶ縺ｮ繝?繝ｼ繧ｿ縺ｮ讀懃ｴ｢蜃ｦ逅?繧定｡後≧縲?
     * @param ud 蟇ｾ蠢懊＠縺溘ョ繝ｼ繧ｿ繧剃ｿ晄戟縺励※縺?繧徽avaBeans
     * @throws SQLException 蜻ｼ縺ｳ蜃ｺ縺怜??縺ｫcatch縺輔○繧九◆繧√↓繧ｹ繝ｭ繝ｼ 
     * @return 讀懃ｴ｢邨先棡
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException
    {
        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setPass(rs.getString(3));
            resultUd.setMail(rs.getString(4));
            resultUd.setAddress(rs.getString(5));
            resultUd.setTotal(rs.getInt(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            resultUd.setDeleteFlg(rs.getInt(8));
            
            System.out.println("searchByID completed");

            return resultUd;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }
        finally{
            if(con != null){
                con.close();
            }
        }

    }

    
}
