package composite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumns;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="client_master")
public class ClientMaster implements Serializable{
	
	@MapsId("parentPk")
	@ManyToOne
	@JoinColumns ({
        @JoinColumn(name="pid", referencedColumnName = "pid"),
        @JoinColumn(name="pname", referencedColumnName = "pname")
    })
	public ProductMaster productMaster;
	
	public ProductMaster getProductMaster() {
		return productMaster;
	}
	public void setProductMaster(ProductMaster productMaster) {
		this.productMaster = productMaster;
	}
	@Id @GeneratedValue
	private String cid;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}



}
