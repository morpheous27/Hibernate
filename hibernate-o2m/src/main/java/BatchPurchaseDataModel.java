

import java.util.Date;
import java.util.List;

public class BatchPurchaseDataModel {
	private Integer batchId;
	private String medicineName;
	private String medicineCode;
	private String sellerId;
	private String sellerAddress;
	private Integer noOfPakages;
	private Integer unitsPerPackage;
	private Date dateOfPurchase;
	private Date expDateOfPackage;
	private Integer costPrice;
	private Integer discountPercent;
	private Integer effectivePrice;
	private Integer vatPercent;
	
	
	public Integer getBatchId() {
		return batchId;
	}
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public String getMedicineCode() {
		return medicineCode;
	}
	public void setMedicineCode(String medicineCode) {
		this.medicineCode = medicineCode;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public Integer getNoOfPakages() {
		return noOfPakages;
	}
	public void setNoOfPakages(Integer noOfPakages) {
		this.noOfPakages = noOfPakages;
	}
	public Integer getUnitsPerPackage() {
		return unitsPerPackage;
	}
	public void setUnitsPerPackage(Integer unitsPerPackage) {
		this.unitsPerPackage = unitsPerPackage;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public Date getExpDateOfPackage() {
		return expDateOfPackage;
	}
	public void setExpDateOfPackage(Date expDateOfPackage) {
		this.expDateOfPackage = expDateOfPackage;
	}
	public Integer getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}
	public Integer getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(Integer discount) {
		this.discountPercent = discount;
	}
	public Integer getEffectivePrice() {
		return effectivePrice;
	}
	public void setEffectivePrice(Integer effectivePrice) {
		this.effectivePrice = effectivePrice;
	}
	public Integer getVatPercent() {
		return vatPercent;
	}
	public void setVatPercent(Integer vatPercent) {
		this.vatPercent = vatPercent;
	}

	
	


}