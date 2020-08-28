package mobileModel;

public class OrderModel {
 String oid,pid,cid,userid,price,odate,ddate,ostatus,address,remarks;

public OrderModel() {
	super();
}

public OrderModel(String oid, String pid, String cid, String userid, String price, String odate, String ddate,
		String ostatus, String address, String remarks) {
	super();
	this.oid = oid;
	this.pid = pid;
	this.cid = cid;
	this.userid = userid;
	this.price = price;
	this.odate = odate;
	this.ddate = ddate;
	this.ostatus = ostatus;
	this.address = address;
	this.remarks = remarks;
}

public String getOid() {
	return oid;
}

public void setOid(String oid) {
	this.oid = oid;
}

public String getPid() {
	return pid;
}

public void setPid(String pid) {
	this.pid = pid;
}

public String getCid() {
	return cid;
}

public void setCid(String cid) {
	this.cid = cid;
}

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public String getOdate() {
	return odate;
}

public void setOdate(String odate) {
	this.odate = odate;
}

public String getDdate() {
	return ddate;
}

public void setDdate(String ddate) {
	this.ddate = ddate;
}

public String getOstatus() {
	return ostatus;
}

public void setOstatus(String ostatus) {
	this.ostatus = ostatus;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getRemarks() {
	return remarks;
}

public void setRemarks(String remarks) {
	this.remarks = remarks;
}
 
}
