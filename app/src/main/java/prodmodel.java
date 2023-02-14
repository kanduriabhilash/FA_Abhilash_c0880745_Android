public class prodmodel {

    // variables for our coursename,
    // description, tracks and duration, id.
    private int productid;
    private String productname;
    private String productdescription;
    private String productprice;

    // creating getter and setter methods
    public int getproductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = Integer.parseInt(productid);
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public int getId() {
        return productid;
    }

    public void setId(int id) {
        this.productid = productid;
    }

    // constructor
    public prodmodel(int productid, int productname, int productdescription, int productprice) {
        this.productid = productid;
        this.productname = String.valueOf(productname);
        this.productdescription = String.valueOf(productdescription);
        this.productprice = String.valueOf(productprice);
    }
}
