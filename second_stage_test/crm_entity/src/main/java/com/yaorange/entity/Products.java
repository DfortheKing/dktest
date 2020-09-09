package com.yaorange.entity;



import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    @Column
    private String pname;
    @Column
    private String pimg;
    @Column
    private double price;
    @Column
    private String flag;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Products(Integer pid, String pname, String pimg, double price, String flag, Category category) {
        this.pid = pid;
        this.pname = pname;
        this.pimg = pimg;
        this.price = price;
        this.flag = flag;
        this.category = category;
    }

    public Products() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Products{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pimg='" + pimg + '\'' +
                ", price=" + price +
                ", flag='" + flag + '\'' +
                ", category=" + category +
                '}';
    }
}
