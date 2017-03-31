/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec;


import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Choir
 */
public class itemDataBeans implements Serializable
{
    /*
    ���\������f�[�^
    �E���i      ��
    �E�|�C���g  ��
    �E���[�J�[  ��
    �E���r���[
        �[�]���l
        �[�J�E���g��
        �[URL
    �E�T�v
    �E�݌ɂ���E�Ȃ�
    �E�R���f�B�V�����@�V�i�E����
    */
    private ArrayList<String>   name;
    private ArrayList<Integer>  price;
    private ArrayList<String>   ImageURL;
    private ArrayList<String>   productID;
    private ArrayList<Integer>  point;
    private ArrayList<String>   maker;
    
    public class Review
    {
       public int     reviewPoint;    //�]���l
       public int     cnt;            //�J�E���g��
       public  String  URL;            //URL
    }
    private ArrayList<Review>   review;     //���r���[
    private ArrayList<String>   overView;   //�T�v
    private ArrayList<String>   stock;      //�݌ɂ���
    private ArrayList<String>   condition;  //�R���f�B�V����

    public itemDataBeans()
    {
        this.name = new ArrayList<String>();
        this.price = new ArrayList<Integer>();
        this.ImageURL = new ArrayList<String>();
        this.productID = new ArrayList<String>();
        
        this.point      = new ArrayList<Integer>();
        this.maker      = new ArrayList<String>();
        this.review     = new ArrayList<Review>();
        this.overView   = new ArrayList<String>();
        this.stock      = new ArrayList<String>();
        this.condition  = new ArrayList<String>();
    }
    
    public String getName(int index) 
    {
        return name.get(index);
    }
    
    public void setName(String name) 
    {
        //�󕶎�(������)�̏ꍇ�󕶎����Z�b�g
        if(name.trim().length()==0)
        {
            this.name.add("");
        }
        else
        {
            this.name.add(name);
        }
    }
    
    public int getPrice(int index) 
    {
        return price.get(index);
    }
    
    public void setPrice(int  price) 
    {
        if(price <= 0)
        {
            this.price.add(0);
        }
        else
        {
            this.price.add(price);
        }
    }
    
    public String getImageURL(int index) 
    {
        return ImageURL.get(index);
    }
    
    public void setImageURL(String url) 
    {
        //�󕶎�(������)�̏ꍇ�󕶎����Z�b�g
        if(url.trim().length()==0)
        {
            this.ImageURL.add("");
        }
        else
        {
            this.ImageURL.add(url);
        }
    }
    

    
    public String getProductID(int index) 
    {
        return productID.get(index);
    }
    
    public void setProductID(String name) 
    {
        //�󕶎�(������)�̏ꍇ�󕶎����Z�b�g
        if(name.trim().length()==0)
        {
            this.productID.add("");
        }
        else
        {
            this.productID.add(name);
        }
    }
     
    public Integer getPoint(int index) 
    {
        return point.get(index);
    }
    
    public void setPoint(Integer i_point) 
    {
        //�󕶎�(������)�̏ꍇ�󕶎����Z�b�g
        if(i_point <= 0)
        {
            this.point.add(0);
        }
        else
        {
            this.point.add(i_point);
        }
    }

    public String getMaker(int index) 
    {
        return maker.get(index);
    }
    
    public void setMaker(String name) 
    {
        //�󕶎�(������)�̏ꍇ�󕶎����Z�b�g
        if(name.trim().length()==0)
        {
            this.maker.add("");
        }
        else
        {
            this.maker.add(name);
        }
    }
    
    public Review getReview(int index) 
    {
        return review.get(index);
    }
    
    public void setReview(Review i_review) 
    {
        this.review.add(i_review);
    }
    
    public String getOverView(int index) 
    {
        return overView.get(index);
    }
    
    public void setOverView(String i_overView) 
    {
        //�󕶎�(������)�̏ꍇ�󕶎����Z�b�g
        if(i_overView.trim().length()==0)
        {
            this.overView.add("");
        }
        else
        {
            this.overView.add(i_overView);
        }
    }
    
    public String getStock(int index) 
    {
        return stock.get(index);
    }
    
    public void setStock(String i_stock) 
    {
        //�󕶎�(������)�̏ꍇ�󕶎����Z�b�g
        if(i_stock.trim().length()==0)
        {
            this.stock.add("");
        }
        else
        {
            this.stock.add(i_stock);
        }
    }
    
    public String getCondition(int index) 
    {
        return condition.get(index);
    }
    
    public void setCondition(String i_condition) 
    {
        //�󕶎�(������)�̏ꍇ�󕶎����Z�b�g
        if(i_condition.trim().length()==0)
        {
            this.condition.add("");
        }
        else
        {
            this.condition.add(i_condition);
        }
    }
    
    //���i�̐����擾
    public int getItemCnt()
    {
        return this.name.size();
    }
    
    //���i�̍��v���z���擾
    public int getTotalPrice()
    {
        
        int sum = 0;       //���v���z
        if(getItemCnt() > 0)
        {
            //���v���z�̌v�Z
            for(int i = 0; i < getItemCnt() ;i++)
            {
                //�ʐ^�@���i���i�����N�t���@�j���z��\��
                sum += getPrice(i);
            }
        }
        return sum;
    }
    
    public void deleteItem(int Index)
    {
        this.name.remove(Index);
        this.price.remove(Index);
        this.ImageURL.remove(Index);
        this.productID.remove(Index);
        
//        this.point.remove(Index);
//        this.maker.remove(Index);
//        this.review.remove(Index);
//        this.overView.remove(Index);
//        this.stock.remove(Index);
//        this.condition.remove(Index);
        
    }
}
