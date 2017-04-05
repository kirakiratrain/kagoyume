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
    //インスタンスオブジェクトを返却させてコード�?�簡略�?
    public static BuyDataDAO getInstance(){
        return new BuyDataDAO();
    }
            
    //�w���e�[�u���̍X�V
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
     * ユーザーIDによる1件の�?ータの検索処�?を行う�?
     * @param ud 対応したデータを保持して�?るJavaBeans
     * @throws SQLException 呼び出し�??にcatchさせるためにスロー 
     * @return 検索結果
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
