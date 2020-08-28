package mobileModel;

public class ProductModel {
 String pid,pname,brand,ram,rom,processor,battery,price,descrptn;

public ProductModel() {
	super();
}

public ProductModel(String pid, String pname, String brand, String ram, String rom, String processor, String battery,
		String price, String descrptn) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.brand = brand;
	this.ram = ram;
	this.rom = rom;
	this.processor = processor;
	this.battery = battery;
	this.price = price;
	this.descrptn = descrptn;
}

public String getPid() {
	return pid;
}

public void setPid(String pid) {
	this.pid = pid;
}

public String getPname() {
	return pname;
}

public void setPname(String pname) {
	this.pname = pname;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public String getRam() {
	return ram;
}

public void setRam(String ram) {
	this.ram = ram;
}

public String getRom() {
	return rom;
}

public void setRom(String rom) {
	this.rom = rom;
}

public String getProcessor() {
	return processor;
}

public void setProcessor(String processor) {
	this.processor = processor;
}

public String getBattery() {
	return battery;
}

public void setBattery(String battery) {
	this.battery = battery;
}

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public String getDescrptn() {
	return descrptn;
}

public void setDescrptn(String descrptn) {
	this.descrptn = descrptn;
}
 
}
