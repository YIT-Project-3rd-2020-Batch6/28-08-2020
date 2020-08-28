package mobileModel;

public class CartModel {
 String cid,pid,quantity,userid;

public CartModel() {
	super();
}

public CartModel(String cid, String pid, String quantity, String userid) {
	super();
	this.cid = cid;
	this.pid = pid;
	this.quantity = quantity;
	this.userid = userid;
}

public String getCid() {
	return cid;
}

public void setCid(String cid) {
	this.cid = cid;
}

public String getPid() {
	return pid;
}

public void setPid(String pid) {
	this.pid = pid;
}

public String getQuantity() {
	return quantity;
}

public void setQuantity(String quantity) {
	this.quantity = quantity;
}

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}
 
}
