package springrestAr.com.mah.model;

public class Customer {
	Integer id;
	String name;
	Integer walletId, addressId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", walletId=" + walletId + ", addressId=" + addressId + "]";
	}

}
