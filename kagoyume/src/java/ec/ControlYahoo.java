/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
//XMLの解析
//import org.jdom.Document;
//import org.jdom.Element;
//import org.jdom.JDOMException;
//import org.jdom.input.SAXBuilder;
//import org.jdom.output.XMLOutputter;
import org.dom4j.*;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.List; 
import java.util.Iterator;


/**
 *
 * @author Choir
 */
public class ControlYahoo 
{
    private static final String APP_ID = "dj0zaiZpPVJwV3BVUUhJSGViYyZzPWNvbnN1bWVyc2VjcmV0Jng9YTc-";
    private static final String SEARCH_URL = "https://shopping.yahooapis.jp/ShoppingWebService/V1/itemSearch";
    
    void ContorolYahoo()
    {
        
    }
    /*
    概要：商品情報を検索する。
   
    */
    itemDataBeans search(String word)
    {
        //URLの設定
        String sendPalam = "?appid=" + APP_ID + "&query=" + word;
        itemDataBeans listIDB = new itemDataBeans();
        
        //String sendPalam = "&query=" + word;
        try
        {
            //XML
            Document doc = null;
             // アドレス設定、ヘッダー情報設定
            URL url = new URL(SEARCH_URL + sendPalam); 
            //URL url = new URL(SEARCH_URL + "?appid=" + APP_ID);  
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            
            con.setRequestMethod("POST");         // POSTまたはGET
            con.setDoOutput(true);                // POSTのデータを後ろに付ける
            con.setInstanceFollowRedirects(false);// 勝手にリダイレクトさせない
            con.setRequestProperty("Accept-Language", "jp");
            con.setRequestProperty("Content-Type","text/xml;charset=utf-8");
            //con.setRequestProperty("User-Agent","Mozilla/5.0");
            
            OutputStream os = con.getOutputStream();//POST用のOutputStreamを取得
            
            // URLにアクセスし、XMLドキュメントを取得
            
            //doc = new SAXBuilder().build(con.getInputStream());
            
            //XML 取り出したい値
            //商品名
            //価格
            //サムネイル
            //リンク
            //===========================================

            InputStream is = con.getInputStream();//POSTした結果を取得
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String xml = "";
            String s = "";
            while ((s = reader.readLine()) != null)
            {
                System.out.println(s);
                xml += s;
            }
            doc = DocumentHelper.parseText(xml);
            
            String strMsg = "";
            
            //ルート要素からひとつずつとっていく
            Element root = doc.getRootElement();
            
            //商品名・価格・サムネイル取得
            for (Iterator i = root.elementIterator(); i.hasNext();) 
            {
                Element elem = (Element) i.next();
                for (Iterator ii = elem.elementIterator(); ii.hasNext();) 
                {
                    Element elemHit = (Element) ii.next();
                    String sHit = elemHit.getName();
                    if(elemHit.getName().equals("Hit"))
                    {
                        Element elemTmp = elemHit.element("Name");
                        listIDB.setName(elemTmp.getText());
                        elemTmp.detach();
                        elemTmp = elemHit.element("Price");
                        String price = elemTmp.getText();
                        listIDB.setPrice(Integer.parseInt(price));
                        elemTmp.detach();
                        elemTmp = elemHit.element("Image").element("Medium");
                        listIDB.setImageURL(elemTmp.getText());
                        elemTmp.detach();
                        elemTmp = elemHit.element("ProductId");
                        listIDB.setProductID(elemTmp.getText());
                    }
                }

            }
            
            // 取得したDoucmnetを標準出力に書き出す
//            BufferedWriter bout = new BufferedWriter(new OutputStreamWriter(System.out));
//            XMLOutputter out = new XMLOutputter();
//            out.output(doc, bout);
            
            //ps.close();
            reader.close();
            con.connect();
            
            
        }
        catch(MalformedURLException e)
        {
            String str = e.getMessage();
        }
        catch(Exception e)
        {
            String str = e.getMessage();
                    
        }
       
        return listIDB;
    }
    
    void testXML(String word)
    {
        //URLの設定
        String sendPalam = "?appid=" + APP_ID + "&query=" + word;
        
        try
        {
            //XML
            Document doc = null;
             // アドレス設定、ヘッダー情報設定
            URL url = new URL(SEARCH_URL + sendPalam); 
            //URL url = new URL(SEARCH_URL + "?appid=" + APP_ID);  
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            
            con.setRequestMethod("POST");         // POSTまたはGET
            con.setDoOutput(true);                // POSTのデータを後ろに付ける
            con.setInstanceFollowRedirects(false);// 勝手にリダイレクトさせない
            con.setRequestProperty("Accept-Language", "jp");
            con.setRequestProperty("Content-Type","text/xml;charset=utf-8");

            OutputStream os = con.getOutputStream();//POST用のOutputStreamを取得

//            //itemsリスト取得
//            NodeList localNodeList =
//             ((Element) elementRoot.getElementsByTagName("Items").item(0)).getElementsByTagName("Item");
//
//            //itemName取得
//            for (int i = 0; i < localNodeList.getLength(); i++) 
//            {
//                Element elementItem = (Element) localNodeList.item(i);
//                Element elementItemName = (Element) elementItem.getElementsByTagName("itemName").item(0);
//                String itemName = elementItemName.getFirstChild().getNodeValue();
//                Log.d("itemName",itemName);
//            }
        }
        catch(MalformedURLException e)
        {
            String str = e.getMessage();
        }
        catch(Exception e)
        {
            String str = e.getMessage();
                    
        }

    }
        
}
