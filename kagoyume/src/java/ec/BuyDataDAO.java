/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec;

import base.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
/**
 *
 * @author Choir
 */
public class BuyDataDAO 
{
    final private  String tblName = "buy_t";
    //繧､繝ｳ繧ｹ繧ｿ繝ｳ繧ｹ繧ｪ繝悶ず繧ｧ繧ｯ繝医ｒ霑泌唆縺輔○縺ｦ繧ｳ繝ｼ繝峨?ｮ邁｡逡･蛹?
    public static BuyDataDAO getInstance(){
        return new BuyDataDAO();
    }
            
    //購入テーブルの更新
    public void insert(BuyDataDTO ud) throws SQLException
    {
        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
            
            st =  con.prepareStatement("INSERT INTO "+ tblName +"(buyID,userID,itemCode,type,buyDate) VALUES(?,?,?,?,?)");
            st.setInt(1, ud.getBuyID());
            st.setInt(2, ud.getUserID());
            st.setString(3, ud.getItemCode());
            st.setInt(4, ud.getType());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
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
     * 繝ｦ繝ｼ繧ｶ繝ｼID縺ｫ繧医ｋ1莉ｶ縺ｮ繝?繝ｼ繧ｿ縺ｮ讀懃ｴ｢蜃ｦ逅?繧定｡後≧縲?
     * @param ud 蟇ｾ蠢懊＠縺溘ョ繝ｼ繧ｿ繧剃ｿ晄戟縺励※縺?繧徽avaBeans
     * @throws SQLException 蜻ｼ縺ｳ蜃ｺ縺怜??縺ｫcatch縺輔○繧九◆繧√↓繧ｹ繝ｭ繝ｼ 
     * @return 讀懃ｴ｢邨先棡
     */
    public ArrayList <BuyDataDTO> searchByID(int userId) throws SQLException
    {
        Connection con = null;
        PreparedStatement st = null;
        try
        {
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM buy_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, userId);
            
            ResultSet rs = st.executeQuery();
            
            ArrayList<BuyDataDTO> resultUd = new ArrayList<BuyDataDTO>();
            BuyDataDTO buyDataTmp = new BuyDataDTO();
            int i = 0;
            while(rs.next())
            {
                
                buyDataTmp.setBuyID(rs.getInt(1));
                buyDataTmp.setUserID(rs.getInt(2));
                buyDataTmp.setItemCode(rs.getString(3));
                buyDataTmp.setType(rs.getInt(4));
                buyDataTmp.setBuyDate(rs.getTimestamp(5));
                resultUd.add(buyDataTmp);
                i++;
            }
            
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

    
}
