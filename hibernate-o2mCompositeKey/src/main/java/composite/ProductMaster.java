package composite;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name ="product_master")
public class ProductMaster implements Serializable{
	@EmbeddedId 
	ParentPK parentPK;
	public ParentPK getParentPK() {
		return parentPK;
	}
	public void setParentPK(ParentPK parentPK) {
		this.parentPK = parentPK;
	}
	private String pclass;
	
	
	@OneToMany
    @JoinColumns ({
        @JoinColumn(name="pid", referencedColumnName = "pid"),
        @JoinColumn(name="pname", referencedColumnName = "pname")
    })
	private Set<ClientMaster> set;

	public Set<ClientMaster> getSet() {
		return set;
	}
	public void setSet(Set<ClientMaster> set) {
		this.set = set;
	}

	public String getPclass() {
		return pclass;
	}
	public void setPclass(String pclass) {
		this.pclass = pclass;
	}

}
