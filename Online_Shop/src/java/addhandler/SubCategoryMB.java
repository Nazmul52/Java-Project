/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.AddDao;
import dao.ListDao;
import entity.Category;
import entity.SubCat;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author John
 */
@ManagedBean
@SessionScoped

public class SubCategoryMB {
    SubCat subcat = new SubCat();
    String catname;
    List<Category> listCat;

    public List<Category> getListCat() {
        return listCat;
    }

    public void setListCat(List<Category> listCat) {
        this.listCat = listCat;
    }
    

    public SubCat getSubcat() {
        return subcat;
    }

    public void setSubcat(SubCat subcat) {
        this.subcat = subcat;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }
    public String addSubCategory(){
        listCat = new ListDao().catListByName(catname);
        subcat.setSubCatId(listCat.get(0).getCatId());
        subcat.setSubCatName(subcat.getSubCatName());
        subcat.setSubCatDesc(subcat.getSubCatDesc());
        boolean status = new AddDao().addSubCatagory(subcat);
        if(status){
            FacesContext.getCurrentInstance().addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved", ""));
        }else{
             FacesContext.getCurrentInstance().addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_ERROR, "Data Not Saved", ""));
        }
      return null;  
    }
    
    public List<SelectItem> getCategoryName(){
        List<SelectItem> catname = new ListDao().catList();
        return catname;
    }
}
